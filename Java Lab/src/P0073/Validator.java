package P0073;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String enterMessage) {
        while (true) {
            System.out.print(enterMessage);
            String value = sc.nextLine();
            if (value.isEmpty()) {
                System.out.println("Please enter something!");
            } else {
                return value;
            }
        }
    }

    public static String inputContent(String enterMessage) {
        while (true) {
            System.out.print(enterMessage);
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Please enter something!");
                continue;
            }
            if (!containsOnlyWord(name)) {
                System.out.println("Content can not contains number and special characters!");
                continue;
            }
            return name;
        }
    }

    public static boolean containsOnlyWord(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isAlphabetic(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int inputInteger(String enterMessage) {
        int integerValue = 0;
        while (true) {
            try {
                String value = inputString(enterMessage);
                integerValue = Integer.parseInt(value);
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer!");
            }
        }
    }

    public static Date inputDate(String enterMessage) {
        DateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy");
        pattern.setLenient(false);
        while (true) {
            try {
                String dateString = inputString(enterMessage);
                Date date = pattern.parse(dateString);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid format || Not existed date!");
            }

        }
    }

    public static double inputDouble(String enterMessage) {

        while (true) {
            try {
                double num;
                System.out.print(enterMessage);
                num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("You must input digit.");
            }
        }
    }

    public static double inputAmount(String enterMessage) {
        while (true) {
            double amount = inputDouble(enterMessage);
            if (amount <= 0){
                System.out.println("Must be > 0!");
                continue;
            }
            return amount;
        }
    }
}
