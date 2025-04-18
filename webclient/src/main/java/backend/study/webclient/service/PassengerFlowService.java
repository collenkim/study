package backend.study.webclient.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class PassengerFlowService {

    private final String END_POINT_URL = "http://apis.data.go.kr/B551177/PassengerNoticeKR/getfPassengerNoticeIKR?";
    @Resource
    private Environment env;
    @Resource
    private WebClient webClient;

    /**
     * 공항 승객 예보 조회 - 공공 데이터 포털 API 호출
     *
     * @param selectDate
     * @return
     */
    public void getPassengerFlowBySelectDate(String selectDate) {

    }

    /**
     * 공항 승객 예보 정보 저장
     *
     * @param selectDate
     */
    public void insertPassengerFlowBySelectDate(String selectDate) {

        String type = "json";
        String serviceKey = env.getProperty("api.service.key");

        webClient.get().uri(uriBuilder ->
                uriBuilder
                    .path(END_POINT_URL)
                    .queryParam("serviceKey", serviceKey)
                    .queryParam("type", type)
                    .queryParam("selectDate", selectDate)
                    .build()
            )
            .retrieve() //
            .toEntity(String.class)
            .subscribe(
                responseEntity -> {
                    log.info("Response: {}", responseEntity.getBody());
                },
                error -> {
                    log.error("Error: {}", error.getMessage());
                }
            );

    }

    public void updatePassengerFlowById(String id) {

    }

    public void deletePassengerFlowById(String id) {

    }

}
