package myjavaproject;


import java.util.regex.Pattern;

public class MasterClass {
   
    public static boolean checkEmail(String email) {
        return email.matches(".*@(gmail\\.com|yahoo\\.com|hotmail\\.com)$");
    }
    public static int getStringLength(String txt) {
        return txt.length();
    }
    public static String changeToUpper(String txt) {
        return txt.toUpperCase();
    }
}