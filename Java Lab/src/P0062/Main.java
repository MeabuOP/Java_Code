/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0062;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("===== Analysis Path Program =====");
            System.out.println("Please input Path:");
            String path = sc.nextLine();
            if (!validPath(path)) continue;
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));   
            System.out.println("Folders: " + getFolders(path));
        }
    }
    
    public static boolean validPath(String path){
        File file = new File(path);
        if (!file.isFile() || !file.exists()){
            System.out.println("Error!");
            return false;
        }

        return true;
    }
    public static String getPath(String path){
        int endIndex = path.lastIndexOf("\\");
        return path.substring(0, endIndex);
    }
    public static String getFileName(String path){
        int startIndex = path.lastIndexOf("\\");
        int endIndex = path.indexOf(".");
        return path.substring(startIndex+1,endIndex);
    }
    public static String getExtension(String path){
        int startIndex = path.indexOf(".");
        return path.substring(startIndex+1);
    }
    public static String getDisk(String path){
        int endIndex = path.indexOf("\\");
        return path.substring(0,endIndex);
    }
    public static String getFolders(String path){
        String[] splitFile = path.split("\\\\");
        return "["+ splitFile[splitFile.length - 2] + "]";
    }    
}
