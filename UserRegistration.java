package UserRegistration;
import java.util.Scanner;
import java.util.regex.*;
public class UserRegistration {
    private boolean check;
    private String firstName,lastName,email,phoneNumber;
    private static final Scanner SCANNER  = new Scanner(System.in);
/**
 * This checkFirstname method will check the user input according to the pattern.
 * for this operation i have imported regex module and Scanner module.
 */
    public void checkFirstName() {
        System.out.println("Enter First-name starts with capital letter and has minimum 3 character : ");
        firstName = SCANNER.nextLine();
        check = Pattern.compile("[A-Z]{1}[a-z]{2,}").matcher(firstName).matches();
        if (!check) {
            System.out.println("Invalid!!Please Enter your name according to the instruction.");
            checkFirstName();
        }
        else {
            System.out.println(" It's a Valid Firstname ");
        }
    }

    /**
     * This checkLastname method will check the user input according to the pattern.
     */
    public void checkLastName() {
        System.out.println("Enter Lastname starts with capital letter and has minimum 3 character : ");
        lastName = SCANNER.nextLine();
        check = Pattern.compile("[A-Z]{1}[a-z]{2,}").matcher(lastName).matches();
        if (!check) {
            System.out.println("Invalid!!Please Enter your name according to the instruction.");
            checkLastName();
        }
        else
            System.out.println(" It's a valid Lastname ");
    }

    /**
     * Added checkEmail method to match the email ids according to the given pattern.
     */
    public void checkEmail() {
        System.out.println("Enter a valid email(Eg. abc.xyz@bl.co.in) : ");
        email = SCANNER.nextLine();
        check = Pattern.compile("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]{2,}+)*$").matcher(email).matches();
        if (!check) {
            System.out.println(" Invalid!!Email-id...Please Enter a Valid one. ");
            checkEmail();
        }
        else {
            System.out.println(" Email-Id is valid ");
        }
    }

    /**
     * This checkPhonenumber method will check the user input(Mobile Number) according to the pattern.
     */
    public void checkPhoneNumber() {
        System.out.println("Enter Your Mobile Number (Eg. 91 9919819801) : ");
        phoneNumber = SCANNER.nextLine();
        check = Pattern.compile("^[0-9]{1,3} [0-9]{10}$").matcher(phoneNumber).matches();
        if (!check) {
            System.out.println(" Number is invalid!!Please Enter a Valid one. ");
            checkPhoneNumber();
        }
        else {
            System.out.println("Valid Number ");
        }
    }

    public static void main(String[]args) {
        UserRegistration user = new UserRegistration();
        user.checkFirstName();
        user.checkLastName();
        user.checkEmail();
        user.checkPhoneNumber();
    }
}