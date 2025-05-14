package backend.study.adapterpattern.error.exception;

public class InvalidSignatureException extends RuntimeException {

    public InvalidSignatureException() {
        super("서명이 위조되었거나 인증 실패 입니다.");
    }

    public InvalidSignatureException(String message) {
        super(message);
    }

    public InvalidSignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSignatureException(Throwable cause) {
        super(cause);
    }

    public InvalidSignatureException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
