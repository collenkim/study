package backend.study.adapterpattern.error.exception;

public class OAuth2UserNotRegisteredException extends RuntimeException {

    public OAuth2UserNotRegisteredException() {
        super("소셜 가입 정보가 존재하지 않음.");
    }

    public OAuth2UserNotRegisteredException(String message) {
        super(message);
    }

    public OAuth2UserNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public OAuth2UserNotRegisteredException(Throwable cause) {
        super(cause);
    }

    public OAuth2UserNotRegisteredException(String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
