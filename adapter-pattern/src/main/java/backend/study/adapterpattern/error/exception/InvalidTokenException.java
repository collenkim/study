package backend.study.adapterpattern.error.exception;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("JWT 파싱 중 일반적인 오류 입니다.");
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTokenException(Throwable cause) {
        super(cause);
    }

    public InvalidTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
