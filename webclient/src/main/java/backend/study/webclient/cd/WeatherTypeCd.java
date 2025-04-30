package backend.study.webclient.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeatherTypeCd {

    SPECIAL("SPECIAL", "특보"),
    ;

    private final String code;
    private final String name;
}
