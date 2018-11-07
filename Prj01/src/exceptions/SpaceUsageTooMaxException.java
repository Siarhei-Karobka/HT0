package exceptions;

/**
 * @author OK
 * @since 31.10.2018
 */
public class SpaceUsageTooMaxException extends Exception {
    public SpaceUsageTooMaxException(String message) {
        super(message);
    }
}
