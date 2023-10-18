/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class P0011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputBase = 0, outputBase = 0;
        do {
            System.out.println("Enter base number input (1 is binary, 2 is decimal,  3 is hexadecimal): ");
            inputBase = sc.nextInt();
            System.out.println("Enter base number output (1 is binary, 2 is decimal,  3 is hexadecimal): ");
            outputBase = sc.nextInt();
        } while ((inputBase <= 0 || inputBase > 3) || (outputBase <= 0 || outputBase > 3));

        //Delete buffer;
        sc.nextLine();
        String value = " ";
        do {
            System.out.println("Enter input value: ");
            value = sc.nextLine();
            value = value.trim();
        } while (!validValue(inputBase, value));

        System.out.println("Output value: " + changeBase(inputBase, outputBase, value));

    }

    public static boolean validDecimal(String value) {
        if (!value.isEmpty() && value.charAt(0) == '0') {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validBinary(String value) {
        if (!value.isEmpty() && value.charAt(0) == '0') {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean validHexa(String value) {
        if (!value.isEmpty() && value.charAt(0) == '0') {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c) && (c < 'A' || c > 'F')) {
                return false;
            }
        }
        return true;
    }

    public static boolean validValue(int base, String value) {
        if (base == 1) {
            return validBinary(value);
        }
        if (base == 2) {
            return validDecimal(value);
        } else {
            return validHexa(value);
        }
    }

    public static String changeBase(int inputBase, int outputBase, String value) {
        if (inputBase == outputBase) {
            return value;
        } else {
            switch (inputBase) {
                case 1 -> {
                    if (outputBase == 2) {
                        return binToDec(value);
                    }
                    if (outputBase == 3) {
                        return binToHex(value);
                    }
                }
                case 2 -> {
                    if (outputBase == 1) {
                        return decToBin(value);
                    }
                    if (outputBase == 3) {
                        return decToHex(value);
                    }
                }
                default -> {
                    if (outputBase == 1) {
                        return hexToBin(value);
                    }
                    if (outputBase == 2) {
                        return hexToDec(value);
                    }
                }
            }
        }
        return null;
    }

    public static String binToDec(String value) {
        int decimal = 0;
        int exponent = 0;
        for (int i = value.length() - 1; i>=0;i--) {
            decimal = (int) (decimal + Character.getNumericValue(value.charAt(i)) * Math.pow(2, exponent++));
        }
        return String.valueOf(decimal);
    }

    public static String binToHex(String value) {
        return decToHex(binToDec(value));
    }

    //Vẫn chưa nghĩ ra cách giữ nguyên string
    public static String decToBin(String value) {
        int decimal = Integer.parseInt(value);
        String binary = "";
        while (decimal != 0) {
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        }
        return binary;
    }

    //Same
    public static String decToHex(String value) {
        int decimal = Integer.parseInt(value);
        String heximal = "";
        while (decimal != 0) {
            char c = 0;
            int remainder = decimal % 16;
            if (remainder <= 9) {
                c = (char) (decimal % 16 + '0');
            } else {
                switch (remainder) {
                    case 10 -> c = 'A';
                    case 11 -> c = 'B';
                    case 12 -> c = 'C';
                    case 13 -> c = 'D';
                    case 14 -> c = 'E';
                    case 15 -> c = 'F';
                }
            }
            heximal = c + heximal;
            decimal = decimal / 16;
        }
        return heximal;
    }

    public static String hexToDec(String value) {
        int decimal = 0;
        int exponent = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            int val = 0;
            char c = value.charAt(i);
            if (c >= '0' && c <= '9') {
                val = Character.getNumericValue(c);
            } else {
                switch (c) {
                    case 'A' -> val = 10;
                    case 'B' -> val = 11;
                    case 'C' -> val = 12;
                    case 'D' -> val = 13;
                    case 'E' -> val = 14;
                    case 'F' -> val = 15;
                }
            }
            decimal = (int) (decimal + val * Math.pow(16, exponent++));
        }
        return String.valueOf(decimal);
    }

    public static String hexToBin(String value) {
        return decToBin(hexToDec(value));
    }
}
