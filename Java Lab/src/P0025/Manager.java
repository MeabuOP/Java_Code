/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Manager {
    ArrayList<String> fileContent;
    String outputString = "";
    public void readFile(){
        fileContent = new ArrayList<>();
        try {
            String line;
            BufferedReader read = new BufferedReader(new FileReader("input.txt"));
            while ((line = read.readLine()) != null){
                fileContent.add(line);
            }
            read.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Input output exception!");
        }
        
    }
    
    public void normalizeContent(){     
        deleteBlankLines();
        //File trống : return
        if (outputString.isBlank()) return;           
        upperCaseFirstLetter(); 
        addDotAtTheEnd();         
        splitComma();
        splitCollon();
        splitDot();
        splitQuote();
        deleteExtraSpace();

    }
    
    //Gộp paragraph lại thành 1 đoạn văn
    public void deleteBlankLines(){
        for (String s: fileContent){
            outputString += s + " ";
        }
    }
    
    //In hoa chữ cái đầu
    public void upperCaseFirstLetter(){
        outputString = Character.toUpperCase(outputString.charAt(0)) + outputString.substring(1);
    }
    
    public void addDotAtTheEnd(){
        if (outputString.charAt(outputString.length() - 1) == '.') return;
        outputString = outputString + ".";
    }
    
    public void splitComma(){
        String[] stringArr = outputString.split(",");
        if (stringArr.length == 0) return;
        //Xóa để từ đứng trước dấu , không có kcach thừa
        stringArr[0] = stringArr[0].trim();
        //Trừ thằng đầu tiên, các thằng nằm sau đều ở sau dấu , or :
        for (int i = 1; i < stringArr.length;i++){
            //Xóa k/cách dư ở 2 đầu, in thường kí tự đầu tiên và add 1 space vào trước
            stringArr[i] = stringArr[i].trim();
            stringArr[i] = Character.toLowerCase(stringArr[i].charAt(0)) + stringArr[i].substring(1);
            stringArr[i] = " " + stringArr[i];
        }
        //Add lại vào outputString
        outputString = "";
        for (int i = 0; i < stringArr.length;i++){
            outputString += stringArr[i];
            if (i < stringArr.length - 1) outputString = outputString + ",";
        }
    }

    public void splitDot(){
        String[] stringArr = outputString.split("\\.");
        //Xóa để từ đứng trước dấu , không có kcach thừa
        stringArr[0] = stringArr[0].trim();        
        //Trừ thằng đầu tiên, các thằng nằm sau đều ở sau dấu , or :
        for (int i = 1; i < stringArr.length;i++){
            if (stringArr[i].isBlank()) continue;
            //Xóa k/cách dư ở 2 đầu, in thường kí tự đầu tiên và add 1 space vào trước
            stringArr[i] = stringArr[i].trim();
            stringArr[i] = Character.toUpperCase(stringArr[i].charAt(0)) + stringArr[i].substring(1);
            stringArr[i] = " " + stringArr[i];
        }
        //Add lại vào outputString
        outputString = "";
        for (int i = 0; i < stringArr.length;i++){
            outputString += stringArr[i];
            outputString = outputString + ".";
        }
    }

    public void splitCollon(){
        String[] stringArr = outputString.split(":");
        if (stringArr.length == 0) return;
        //Trừ thằng đầu tiên, các thằng nằm sau đều ở sau dấu , or :
        for (int i = 1; i < stringArr.length;i++){
            //Xóa k/cách dư ở 2 đầu, in thường kí tự đầu tiên và add 1 space vào trước
            stringArr[i] = stringArr[i].trim();
            stringArr[i] = Character.toLowerCase(stringArr[i].charAt(0)) + stringArr[i].substring(1);
            stringArr[i] = " " + stringArr[i];
        }
        //Add lại vào outputString
        outputString = "";
        for (int i = 0; i < stringArr.length;i++){
            outputString += stringArr[i];
            if (i < stringArr.length - 1) outputString = outputString + ":";
        }
    }
    
    public void deleteExtraSpace(){
        outputString = outputString.replaceAll("\\s+"," ");
    }
    
    public void splitQuote(){
        String[] stringArr = outputString.split("\"");
        if (stringArr.length == 0) return;
        //Trừ thằng đầu tiên, các thằng nằm sau đều ở sau dấu , or :
        for (int i = 1; i < stringArr.length;i++){
            //Nếu là số lẻ thì nằm giữa quotes
            if (i%2 != 0) stringArr[i] = stringArr[i].trim();
        }
        //Add lại vào outputString
        outputString = "";
        for (int i = 0; i < stringArr.length;i++){
            String newString = stringArr[i];
            if (i % 2 != 0 && i!=0) newString ="\"" + newString + "\"";
            outputString += newString;
        }  
    }
    
    public void writeFile(){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("output.txt"));
            write.write(outputString);
            write.close();
        } catch (IOException ex) {
            System.out.println("Input output error!");
        }
        
    }
    
    
    public void printResult(){
        System.out.println(outputString);
    }
}
