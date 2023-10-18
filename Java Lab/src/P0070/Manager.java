/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0070;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author ASUS
 */
public class Manager {

    //Read account file
    public static void readFile(ArrayList<Account> accountList) {
        accountList.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Account.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split("-");
                if (array.length < 2) {
                    continue;
                }
                accountList.add(new Account(array[0], array[1]));
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No available account list!");
        } catch (IOException ioe) {
            System.out.println("Input Output Error!");
        }
    }

    //Print menu
    public static void display(ArrayList<Account> accountList) {
        int choice;
        readFile(accountList);
        while (true) {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            choice = Validator.inputInteger("Enter choice: ", 1, 3);
            switch (choice) {
                case 1 -> {
                    login(accountList, new Locale("vi"));
                }
                case 2 -> {
                    login(accountList, new Locale("en"));
                }
                case 3 -> {
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }


    //Get message in language
    public static String getMessage(Locale language, String key) {
        ResourceBundle rb = ResourceBundle.getBundle("P0070/messages", language);
        String message = rb.getString(key);
        return message;
    }

    //Login
    private static void login(ArrayList<Account> accountList, Locale language) {
        System.out.println("--------------------------------------------------");
        //No account available
        if (accountList.isEmpty()) {
            System.out.println(getMessage(language, "emptyDataBaseErr"));
            return;
        }
        //Enter username until exist
        String userName = "";
        Account account;
        while (true) {
            userName = Validator.inputUserName(language);
            account = Validator.existedUserName(accountList, userName);
            if (account == null) {
                System.out.println(getMessage(language, "usernameNotFound"));
                continue;
            }
            break;
        }
        //Enter password until correct
        while (true) {
            String passWord = Validator.inputPassWord(language);
            if (passWord.equals(account.getPassWord())) {
                break;
            } else {
                System.out.println(getMessage(language, "wrongPassWord"));
            }
        }
        
        //Enter different captcha until correct
        while (true) {
            String captcha = generateRandomCaptcha();
            System.out.println("Captcha: " + captcha);
            String userInputCaptcha = Validator.inputString(getMessage(language, "inputCaptcha"),language);
            if (!userInputCaptcha.equals(captcha)) {
                System.out.println(getMessage(language, "wrongCaptcha"));
                continue;
            }
            System.out.println(getMessage(language, "loginSuccessful"));
            break;
        }
    }

    //Generate by mod randomChar length
    private static String generateRandomCaptcha() {
        String randomCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomChar = random.nextInt();
            if (randomChar < 0) {
                randomChar = -randomChar;
            }
            result = result + randomCharacters.charAt(randomChar % randomCharacters.length());
        }
        return result;
    }
}
