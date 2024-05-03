public class OptionsLoadException extends Exception{
    public OptionsLoadException(String message) {
        super(message);
    }

    public OptionsLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptionsLoadException(Throwable cause) {
        super(cause);
    }

    public OptionsLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
