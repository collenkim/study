package backend.study.adapterpattern.error.exception;

public class UnauthorizedTokenException extends RuntimeException {

    public UnauthorizedTokenException() {
        super("권한이 없는 토큰입니다.");
    }

    public UnauthorizedTokenException(String message) {
        super(message);
    }

    public UnauthorizedTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedTokenException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
