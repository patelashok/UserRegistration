package userregistration;

import java.util.Scanner;
import java.util.regex.*;

/**
 * for lambda implementation i have refactored the code.
 * added Functional interface.
 * i have taken Iuser interface and taken one abstract method.
 */
@FunctionalInterface
interface IUser{
    void validateUser(String pattern, String input);
}

public class UserRegistration {
    private static boolean check;
    private String email;
    private String firstName, lastName, phoneNumber, password;
    /**
     * Here i have taken all the patterns which i have to compare with the userinputs.
     */
    private final String FIRSTANDLASTNAME="[A-Z]{1}[a-z]{2,}";
    private final String EMAIL="^[a-zA-Z0-9]+(?:\\+*-*.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]{2,}+)*$";
    private final String PASSWORD="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=-]?){8,}.*$";
    private final String PHONENUMBER="^[0-9]{1,3} [0-9]{10}$";
    private final Scanner SCAN=new Scanner(System.in);

    /**
     * Added an Uservalidate method.
     * it'll perform user validation operations.
     * Added exception Handling.
     */
    public void userValidate(){
        IUser userRegistration=(checkPattern, givenInput)->{
            try{
                if (givenInput==null){
                    throw new UserRegistrationException("Enter valid Input ");
                }else if (!(Pattern.matches(checkPattern, givenInput))){
                    throw new UserRegistrationException("Enter valid input ");
                }
                System.out.println(givenInput+" is a valid input.");
            } catch (UserRegistrationException e) {
                String printMessage=e.errorMessage;
                System.out.println(printMessage);
                userValidate();
            }
        };
        System.out.println("Enter Your Firstname: ");
        firstName=SCAN.nextLine();
        userRegistration.validateUser(FIRSTANDLASTNAME,firstName);

        System.out.println("Enter Your Lastname: ");
        lastName=SCAN.nextLine();
        userRegistration.validateUser(FIRSTANDLASTNAME,lastName);

        System.out.println("Enter Your Email-Id: ");
        email=SCAN.nextLine();
        userRegistration.validateUser(EMAIL,email);

        System.out.println("Enter Your Phone Number: ");
        phoneNumber=SCAN.nextLine();
        userRegistration.validateUser(PHONENUMBER,phoneNumber);

        System.out.println("Enter Your Password: ");
        password=SCAN.nextLine();
        userRegistration.validateUser(PASSWORD,password);
    }

    /**
     * Creating objects for every method in the UserRegistration.
     * it will call the method and proceed the opration.
     * @param args
     */
    public static void main(String[] args) {
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.userValidate();
    }
}