
package se.lamm.model;



import java.time.LocalDate;
import java.util.Scanner;

public class Utilities {

    static private Scanner sc = new Scanner(System.in);

    public static int nextInt(String s) {
        System.out.println(s);
        int num = 0;
        try {
            num = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            //System.err.println("Wrong input!");    
            num = nextInt("Enter number: ");
        }
        return num;
    }
    public static double nextDouble(String s) {
        System.out.println(s);
        double num = 0;
        try {
            num = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            //System.err.println("Wrong input!");    
            num = nextDouble("Enter number: ");
        }
        return num;
    }

    public static boolean isName(String name) {
        String alfabet = "ABCDEFJHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuwxyz ";
        for (int i = 0; i < name.length(); i++) {
            boolean isWord = false;
            for (int j = 0; j < alfabet.length(); j++) {
                if (name.charAt(i) == alfabet.charAt(j)) {
                    isWord = true;
                }
            }
            if (!isWord) {
                return false;
            }
        }
        return true;
    }

    public static String isDateBirth() {
        String dob = null;
        System.out.print("Enter date of birth (yyyy-mm-dd):");
        LocalDate l = null;
        try {
            dob = sc.nextLine();
            l = LocalDate.parse(dob);
        } catch (Exception e) {
            System.err.println("Invalid date format, input as yyyy-mm-dd");
            dob = isDateBirth();
        }
        return dob;
    }
    
    public static void header(){
        System.out.println("ID  PROFESSION    NAME                     GENDER  SALARY   JOINING DATE   BIRTH DATE");
        System.out.println("-------------------------------------------------------------------------------------");
    }
}