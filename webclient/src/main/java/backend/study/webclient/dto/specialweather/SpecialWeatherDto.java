package backend.study.webclient.dto.specialweather;

import backend.study.webclient.dto.CommonResponse.Page;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class SpecialWeatherDto {

    @Setter
    @Getter
    public static class ResApi {

    }

    @Setter
    @Getter
    public static class ResList {

        private String areaCd;
        private LocalDateTime startDt;
        private LocalDateTime endDt;
    }

    @Setter
    @Getter
    public static class ReqList extends Page {


    }

}
