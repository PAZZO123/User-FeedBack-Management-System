import java.util.regex.Pattern;

public class MasterClass {
    // Check if email is valid
    public static boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
    }

    // Get the length of a string
    public static int getStringLength(String txt) {
        return txt.length();
    }

    // Convert a string to uppercase
    public static String changeToUpper(String txt) {
        return txt.toUpperCase();
    }
}