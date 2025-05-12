package backend.study.adapterpattern.error.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNSUPPORTED_PROVIDER(HttpStatus.BAD_REQUEST, "C_001", "지원하지 않는 로그인 제공자입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S_001", "서버 내부 오류입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
