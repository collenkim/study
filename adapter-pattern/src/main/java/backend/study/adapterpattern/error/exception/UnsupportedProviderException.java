package backend.study.adapterpattern.error.exception;

/**
 * Custom exception class for unsupported login providers.
 */
public class UnsupportedProviderException extends RuntimeException {

    public UnsupportedProviderException(String message) {
        super(message);
    }

    public UnsupportedProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedProviderException(Throwable cause) {
        super(cause);
    }

    public UnsupportedProviderException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
