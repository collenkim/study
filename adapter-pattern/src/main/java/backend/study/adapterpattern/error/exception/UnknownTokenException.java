package backend.study.adapterpattern.error.exception;

public class UnknownTokenException extends RuntimeException {

    public UnknownTokenException() {
        super("알수 없는 토큰 에러 입니다.");
    }

    public UnknownTokenException(String message) {
        super(message);
    }

    public UnknownTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownTokenException(Throwable cause) {
        super(cause);
    }

    public UnknownTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
