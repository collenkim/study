package backend.study.adapterpattern.error.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNSUPPORTED_PROVIDER(HttpStatus.BAD_REQUEST, "C_001", "지원하지 않는 로그인 제공자입니다."),
    EXPIRED_TOKEN(HttpStatus.BAD_REQUEST, "C_002", "만료된 토큰입니다."),
    UNAUTHORIZED_TOKEN(HttpStatus.BAD_REQUEST, "C_003", "권한이 없는 토큰입니다."),
    MALFORMED_TOKEN(HttpStatus.BAD_REQUEST, "C_004", "잘못된 형식의 토큰입니다."),
    INVALID_SIGN_TOKEN(HttpStatus.BAD_REQUEST, "C_005", "서명이 위조되었거나 인증 실패 입니다."),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "C_006", "유효하지 않은 토큰입니다."),
    UNKNOWN_TOKEN(HttpStatus.BAD_REQUEST, "C_007", "알수 없는 토큰 에러 입니다."),
    INVALID_REQUEST_BODY(HttpStatus.BAD_REQUEST, "C_008", "요청 본문 형식이 올바르지 않습니다."),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "C_009", "입력값이 유효하지 않습니다."),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "C_010", "이미 존재하는 사용자입니다."),

    BAD_CREDENTIAL(HttpStatus.UNAUTHORIZED, "U_001", "아이디 또는 비밀번호가 올바르지 않습니다."),
    NOT_FOUND_USER(HttpStatus.UNAUTHORIZED, "U_002", "아이디 또는 비밀번호가 올바르지 않습니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S_001", "서버 내부 오류입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
