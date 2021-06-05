package userregistration;

/**
 * Added a subclass of exception class to print the exception message.
 */
public class IllegalArgumentException extends Exception {
    public IllegalArgumentException(String message) {
        super(message);
    }
}
