package backend.study.webclient.dto.specialweather;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpecialWeatherExternalRequest {

    private String serviceKey;
    private Integer pageNo;
    private Integer numOfRows;
    private String dataType;
    private Integer stnId;
    private String fromTmFc;
    private String toTmFc;

}
