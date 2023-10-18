/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0070;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static int inputInteger(String enterMessage, int min, int max) {
        int integer = 0;
        while (true) {
            try {
                System.out.print(enterMessage);
                integer = Integer.parseInt(sc.nextLine().trim());
                if (integer < min || integer > max) {
                    System.out.println("Must >" + min + " and <" + max + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }
            return integer;
        }
    }

    public static String inputString(String enterMessage, Locale language) {
        while (true) {
            System.out.print(enterMessage);
            String value = sc.nextLine();
            if (value.isEmpty()) {
                System.out.println(Manager.getMessage(language, "emptyInput"));
            } else {
                return value;
            }
        }
    }

    public static String inputUserName(Locale language) {
        while (true) {
            String userName = inputString(Manager.getMessage(language, "inputUserName"),language);
            if (userName.length() < 5 || userName.contains("\\s+")) {
                System.out.println(Manager.getMessage(language, "wrongUserNameFormat"));
            } else {
                return userName;
            }
        }
    }

    public static String inputPassWord(Locale language) {
        while (true) {
            String passWord = inputString(Manager.getMessage(language, "inputPassWord"),language);
            if (passWord.length() < 6 || passWord.contains("\\s+")) {
                System.out.println(Manager.getMessage(language, "wrongPassWordFormat"));
            } else {
                return passWord;
            }
        }
    }

    public static Account existedUserName(ArrayList<Account> accountList, String userName) {
        for (Account account : accountList) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }
}
