package backend.study.adapterpattern.error.exception;

public class ExpiredTokenException extends RuntimeException {

    public ExpiredTokenException() {
        super("만료된 토큰입니다.");
    }

    public ExpiredTokenException(String message) {
        super(message);
    }

    public ExpiredTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredTokenException(Throwable cause) {
        super(cause);
    }

    public ExpiredTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
