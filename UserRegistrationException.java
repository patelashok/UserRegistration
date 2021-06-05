package userregistration;

public class UserRegistrationException extends Exception{
    /**
     * this method creates exception for invalid outcomes.
     * @return error message as invalid output.
     */
    String errorMessage;
    public UserRegistrationException(String message) {
        this.errorMessage=message;

    }
}
