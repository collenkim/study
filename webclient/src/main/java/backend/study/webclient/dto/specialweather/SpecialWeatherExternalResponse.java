package backend.study.webclient.dto.specialweather;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class SpecialWeatherExternalResponse {

    @Getter
    @Setter
    public static class Res {

        private Response response;
    }

    @Getter
    @Setter
    public static class Response {

        private Header header;
        private Body body;
    }

    @Getter
    @Setter
    public static class Header {

        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    public static class Body {

        private String dataType;
        private int pageNo;
        private int numOfRows;
        private int totalCount;
        private Items items;
    }

    @Getter
    @Setter
    public static class Items {

        private List<SpecialWeatherExternalItem> item;

    }

    @Setter
    @Getter
    public static class SpecialWeatherExternalItem {

        private String stnId;
        private String title;
        private Long tmFc;
        private Integer tmSeq;
    }

}
