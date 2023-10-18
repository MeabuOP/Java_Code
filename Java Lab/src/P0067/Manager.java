/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0067;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Manager {
    
    //Return an array with numbers
    private static int[] getNumberArray(String line){
      String[] stringNumberArray = line.split("\\D+");
      int[] intNumberArray = new int[stringNumberArray.length];
      for (int i = 0;i < stringNumberArray.length; i++){
          intNumberArray[i] = Integer.parseInt(stringNumberArray[i]);
      }
      return intNumberArray;
    }
    
    //Perfect Square Number
    private static boolean checkPerfectSquare(int number){
        for (int i=0;i<=number/2;i++){
            if (i*i == number) return true;
        }
        return false;
    }
    
    private static int[] getPerfectSquareNumberArray(int[] numberArray){
        int n = 0;
        for (int i:numberArray){
            if (checkPerfectSquare(i)) n++;
        }
        int[] perfectSquareNumber = new int[n];
        n = 0;
        for (int i:numberArray){
            if (checkPerfectSquare(i)) perfectSquareNumber[n++] = i;
        }
        return perfectSquareNumber;        
    }
    
    //Even number
    private static int[] getEvenNumberArray(int[] numberArray){
        int n = 0;
        for (int i:numberArray){
            if (i%2==0) n++;
        }
        int[] evenNumber = new int[n];
        n = 0;
        for (int i:numberArray){
            if (i%2==0) evenNumber[n++] = i;
        }
        return evenNumber;
    }    
    //Odd number
    private static int[] getOddNumberArray(int[] numberArray){
        int n = 0;
        for (int i:numberArray){
            if (i%2!=0) n++;
        }
        int[] oddNumber = new int[n];
        n = 0;
        for (int i:numberArray){
            if (i%2!=0) oddNumber[n++] = i;
        }
        return oddNumber;
    }
    //Return a String with no number
    private static String getAllCharacters(String line){
        String result = "";
        for (char c:line.toCharArray()){
            if (!Character.isDigit(c) && c!=' '){
                result = result + c;
            }
        }
        return result;
    }
    
    //Line have no number
    private static String getSpecialCharacters(String line){
        String result = "";
        for (char c:line.toCharArray()){
            if (!Character.isAlphabetic(c)){
                result = result + c;
            }
        }
        return result;
    }
    
    //Line have no number
    private static String getLowerCaseCharacters(String line){
        String result = "";
        for (char c:line.toCharArray()){
            if (c >= 'a' && c <= 'z'){
                result = result + c;
            }
        }
        return result;
    }

    //Line have no number
    private static String getUpperCaseCharacters(String line){
        String result = "";
        for (char c:line.toCharArray()){
            if (c >= 'A' && c <= 'Z'){
                result = result + c;
            }
        }
        return result;
    }
    
    public static void stringAnalyse(String line){
        String allCharacters = getAllCharacters(line);
        int[] numberArray = getNumberArray(line);
        int[] oddNumberArray = getOddNumberArray(numberArray);
        int[] evenNumberArray = getEvenNumberArray(numberArray);
        int[] perfectSquareNumberArray = getPerfectSquareNumberArray(numberArray);
        System.out.println("Perfect Square Numbers: " + Arrays.toString(perfectSquareNumberArray));
        System.out.println("Odd Numbers: " + Arrays.toString(oddNumberArray));
        System.out.println("Even Numbers: " + Arrays.toString(evenNumberArray));
        System.out.println("All Numbers: " + Arrays.toString(numberArray));
        System.out.println("Uppercase Characters: " + getUpperCaseCharacters(allCharacters));
        System.out.println("Lowercase Characters: " + getLowerCaseCharacters(allCharacters));
        System.out.println("Special Characters: " + getSpecialCharacters(allCharacters));
        System.out.println("All Characters: " + allCharacters);
    }
    
}
