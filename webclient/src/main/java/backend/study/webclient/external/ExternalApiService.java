package backend.study.webclient.external;

import backend.study.webclient.cd.AreaCd;
import backend.study.webclient.dto.specialweather.SpecialWeatherExternalRequest;
import backend.study.webclient.dto.specialweather.SpecialWeatherExternalResponse;
import backend.study.webclient.dto.specialweather.SpecialWeatherExternalResponse.SpecialWeatherExternalItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class ExternalApiService {

    private final String SPECIAL_WEATHER_END_POINT_URL = "https://apis.data.go.kr/1360000/WthrWrnInfoService/getWthrWrnList?";
    private final WebClient webClient;

    /**
     * 기상 특보 API 호출
     *
     * @param requestParam
     * @return
     */
    public Map<String, List<SpecialWeatherExternalItem>> specialWeatherApiCall(
        SpecialWeatherExternalRequest requestParam) {

        List<Integer> areaCodes = Arrays.stream(AreaCd.values())
            .map(AreaCd::getCode)
            .toList();

        return areaCodes.stream()
            .map(areaCd -> getSpecialWeatherForArea(areaCd, requestParam))
            .flatMap(List::stream)
            .collect(Collectors.groupingBy(SpecialWeatherExternalItem::getStnId));
    }

    private List<SpecialWeatherExternalItem> getSpecialWeatherForArea(
        Integer areaCd, SpecialWeatherExternalRequest requestParam) {

        requestParam.setStnId(areaCd);

        SpecialWeatherExternalResponse.Res initialResponse = callApiByPage(requestParam, 1);
        List<SpecialWeatherExternalItem> firstPageItems = initialResponse.getResponse()
            .getBody().getItems().getItem();

        int totalCount = initialResponse.getResponse().getBody().getTotalCount();
        int numOfRows = initialResponse.getResponse().getBody().getNumOfRows();
        int totalPages = (int) Math.ceil((double) totalCount / numOfRows);

        if (totalPages <= 1) {
            return firstPageItems;
        }

        List<SpecialWeatherExternalItem> allItems = new ArrayList<>(firstPageItems);
        for (int page = 2; page <= totalPages; page++) {
            SpecialWeatherExternalResponse.Res pageResponse = callApiByPage(requestParam, page);
            allItems.addAll(pageResponse.getResponse().getBody().getItems().getItem());
        }

        return allItems;
    }

    /**
     * 기상 특보 API 호출
     *
     * @param requestParam
     * @param pageNo
     * @return
     */
    private SpecialWeatherExternalResponse.Res callApiByPage(
        SpecialWeatherExternalRequest requestParam, int pageNo) {
        requestParam.setPageNo(pageNo);

        String url = UriComponentsBuilder.fromUriString(SPECIAL_WEATHER_END_POINT_URL)
            .queryParam("serviceKey", requestParam.getServiceKey())
            .queryParam("pageNo", requestParam.getPageNo())
            .queryParam("numOfRows", requestParam.getNumOfRows())
            .queryParam("dataType", requestParam.getDataType())
            .queryParam("stnId", requestParam.getStnId())
            .queryParam("fromTmFc", requestParam.getFromTmFc())
            .queryParam("toTmFc", requestParam.getToTmFc())
            .toUriString();

        return webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(SpecialWeatherExternalResponse.Res.class)
            .block();
    }

}
