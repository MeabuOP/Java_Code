/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0077;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Manager {

    public static int countWordInFile(String path, String word) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\s+");
                for (String s : split) {
                    if (s.equals(word)) {
                        count++;
                    }
                }
            }
            reader.close();
            return count;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ioe) {
            System.out.println("Input Output Error!");
        }
        return 0;
    }

    public static void getFileNameContainsWordInDirectory(String path, String word) {
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("Must be a directory path!");
            return;
        }
        File[] folder = file.listFiles();
        System.out.println("------------ File Name ------------");
        for (File f : folder) {
            if (countWordInFile(f.getAbsolutePath(), word) != 0) {
                System.out.println(f.getName());
            }
        }
    }
}
