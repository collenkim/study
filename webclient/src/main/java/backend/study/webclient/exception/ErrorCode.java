package backend.study.webclient.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 Bad Request
    DEFAULT_400(HttpStatus.BAD_REQUEST, ErrorCode.DEFAULT_400_CODE, ErrorCode.DEFAULT_400_MESSAGE),

    // 401: Unauthorized
    DEFAULT_401(HttpStatus.UNAUTHORIZED, ErrorCode.DEFAULT_401_CODE, ErrorCode.DEFAULT_401_MESSAGE),

    // 403: Forbidden
    DEFAULT_403(HttpStatus.FORBIDDEN, ErrorCode.DEFAULT_403_CODE, ErrorCode.DEFAULT_403_MESSAGE),

    // 404: Not Found
    DEFAULT_404(HttpStatus.NOT_FOUND, ErrorCode.DEFAULT_404_CODE, ErrorCode.DEFAULT_404_MESSAGE),

    // 405: Method Not Allowed
    DEFAULT_405(HttpStatus.METHOD_NOT_ALLOWED, ErrorCode.DEFAULT_405_CODE,
        ErrorCode.DEFAULT_405_MESSAGE),

    // 500: Internal Server Error
    DEFAULT_500(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.DEFAULT_500_CODE,
        ErrorCode.DEFAULT_500_MESSAGE),

    // 503: Service Unavailable
    DEFAULT_503(HttpStatus.SERVICE_UNAVAILABLE, ErrorCode.DEFAULT_503_CODE,
        ErrorCode.DEFAULT_503_MESSAGE);

    public static final String DEFAULT_400_CODE = "400";
    public static final String DEFAULT_400_MESSAGE = "Bad Request";
    public static final String DEFAULT_401_CODE = "401";
    public static final String DEFAULT_401_MESSAGE = "Unauthorized";
    public static final String DEFAULT_403_CODE = "403";
    public static final String DEFAULT_403_MESSAGE = "Forbidden";
    public static final String DEFAULT_404_CODE = "404";
    public static final String DEFAULT_404_MESSAGE = "Not Found";
    public static final String DEFAULT_405_CODE = "405";
    public static final String DEFAULT_405_MESSAGE = "Method Not Allowed";
    public static final String DEFAULT_500_CODE = "500";
    public static final String DEFAULT_500_MESSAGE = "Internal Server Error";
    public static final String DEFAULT_503_CODE = "503";
    public static final String DEFAULT_503_MESSAGE = "Service Unavailable";

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
