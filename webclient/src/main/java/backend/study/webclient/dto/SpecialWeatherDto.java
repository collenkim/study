package backend.study.webclient.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class SpecialWeatherDto {

    @Setter
    @Getter
    public static class ReqList {

        private String areaCd;
        private LocalDateTime startDt;
        private LocalDateTime endDt;

    }


}
