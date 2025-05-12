package backend.study.adapterpattern.error.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponseDto {

    private String errorCode;
    private String errorMessage;

}
