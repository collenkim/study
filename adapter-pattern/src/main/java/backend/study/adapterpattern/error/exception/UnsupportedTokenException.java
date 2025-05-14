package backend.study.adapterpattern.error.exception;

public class UnsupportedTokenException extends RuntimeException {

    public UnsupportedTokenException() {
        super("지원하지 않는 JWT 구조 입니다.");
    }

    public UnsupportedTokenException(String message) {
        super(message);
    }

    public UnsupportedTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedTokenException(Throwable cause) {
        super(cause);
    }

    public UnsupportedTokenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
