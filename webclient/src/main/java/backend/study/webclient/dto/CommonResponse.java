package backend.study.webclient.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class CommonResponse {

    @Setter
    @Getter
    public static class Header {

        private String resultCode;
        private String resultMsg;
    }

    @Setter
    @Getter
    public static class Page {

        private Integer pageNo;
        private Integer numOfRows;
        private Integer totalCount;
    }

    @Setter
    @Getter
    public static class Body extends Page {

        private String dataType;
        private List<Object> items;

    }

}
