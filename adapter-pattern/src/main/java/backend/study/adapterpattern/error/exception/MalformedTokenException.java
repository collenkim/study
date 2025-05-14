package backend.study.adapterpattern.error.exception;

public class MalformedTokenException extends RuntimeException {

    public MalformedTokenException() {
        super("구조가 잘못된 JWT 토큰 입니다.");
    }

    public MalformedTokenException(String message) {
        super(message);
    }

    public MalformedTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedTokenException(Throwable cause) {
        super(cause);
    }

    public MalformedTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
