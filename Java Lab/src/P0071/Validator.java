package P0071;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    private static final Scanner sc = new Scanner(System.in);
    private static final double timeValue[] = new double[]{8, 8.5, 9.0, 9.5, 10.0, 10.5, 11.0, 11.5, 12.0, 12.5, 13.0, 13.5, 14, 14.5, 15, 15.5, 16, 16.5, 17,17.5};

    private static boolean existedTimeValue(double num){
        for (int i = 0;i < timeValue.length;i++){
            if (num == timeValue[i]) return true;
        }
        return false;
    }
    
    public static double inputTime(String enterMessage) {
        double num;
        Arrays.sort(timeValue);
        while (true) {
            try {
                num = Double.parseDouble(Validator.inputString(enterMessage));
                if (!existedTimeValue(num)){
                    System.out.println("Value must be from 8 8.5 9.0 9.5 ... 17.5!");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid double input!");
            }
        }
    }

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

    public static String inputName(String enterMessage) {
        while (true) {
            System.out.print(enterMessage);
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Please enter something!");
                continue;
            }
            if (!containsOnlyWord(name)) {
                System.out.println("Name can not contains number and special characters!");
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

    public static int inputTaskType(String enterMessage) {
        while (true) {
            int integerValue = Validator.inputInteger(enterMessage);
            if (integerValue < 1 || integerValue > 4) {
                System.out.println("Task type must >= 1 && <= 4");
                continue;
            }
            return integerValue;
        }
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
        while (true) {
            try {
                DateFormat pattern = new SimpleDateFormat("dd-MM-yyyy");
                pattern.setLenient(false);
                String dateString = inputString(enterMessage);
                Date date = pattern.parse(dateString);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid format || Not existed date!");
            }
        }
    }
}
