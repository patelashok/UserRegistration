package UserRegistration;
import java.util.Scanner;
import java.util.regex.*;
public class UserRegistration {
    private boolean check;
    private String firstandlast;
    private static  Scanner SCANNER  = new Scanner(System.in);
/**
 * This checkFirstname method will check the user input according to the pattern.
 * for this operation i have imported regex module and Scanner module.
 */
    public void checkFirstName() {
        System.out.println("Enter First-name and Last name starts with capital letter and has minimum 3 character : ");
        firstandlast = SCANNER.nextLine();
        check = Pattern.compile("[A-Z]{1}[a-z]{2,} [A-Z]{1}[a-z]{2,}").matcher(firstandlast).matches();
        if (!check) {
            System.out.println("Invalid!!Please Enter your name according to the instruction.");
            checkFirstName();
        }
        else {
            System.out.println(" It's a Valid Firstname ");
        }
    }

   
    public static void main(String[]args) {
        UserRegistration user = new UserRegistration();
        user.checkFirstName();
       
    }
}