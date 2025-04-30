package backend.study.webclient.initializer;

import backend.study.webclient.dto.specialweather.SpecialWeatherExternalRequest;
import backend.study.webclient.dto.specialweather.SpecialWeatherExternalResponse.SpecialWeatherExternalItem;
import backend.study.webclient.external.ExternalApiService;
import backend.study.webclient.service.specialweather.SpecialWeatherBusinessService;
import backend.study.webclient.util.DateUtil;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherApiDataInitializer {

    private final ExternalApiService externalApiService;
    private final SpecialWeatherBusinessService specialWeatherBusinessService;

    @PostConstruct
    public void init() {

        String serviceKey = System.getProperty("api.service.key");

        if (serviceKey == null) {
            throw new IllegalArgumentException("Service key is not set");
        }

        SpecialWeatherExternalRequest requestParam = new SpecialWeatherExternalRequest();
        requestParam.setDataType("JSON");
        requestParam.setServiceKey(serviceKey);
        requestParam.setNumOfRows(10);
        requestParam.setFromTmFc(DateUtil.getCurrentDateFromPattern("yyyyMMdd"));
        requestParam.setToTmFc(DateUtil.getCurrentDateFromPattern("yyyyMMdd"));

        Map<String, List<SpecialWeatherExternalItem>> specialWeatherApiResponse = externalApiService.specialWeatherApiCall(
            requestParam);
        specialWeatherBusinessService.saveSpecialWeathers(specialWeatherApiResponse);

    }


}
