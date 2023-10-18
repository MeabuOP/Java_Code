package P0075;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Manager {

    private static final Scanner sc = new Scanner(System.in);

    public static void checkInputPath() {
        while (true) {
            System.out.println("------ Check Path ------");
            String path = Validator.inputString("Enter path (0 to exit):");
            File file = new File(path);
            if (path.equals("0")) {
                return;
            } else if (file.isDirectory()) {
                System.out.println("Path to Directory");
            } else if (file.isFile()) {
                System.out.println("Path to File");
            } else {
                System.out.println("Path doesn't exist");
            }
        }
    }

    public static void getAllFileNameJavaInDirectory() {
        while (true) {
            System.out.println("------ Get file name with type java ------");
            String path = Validator.inputString("Enter path (0 to exit):");
            if (path.equals("0")) {
                return;
            }
            File file = new File(path);

            if (!file.isDirectory()) {
                System.out.println("Please enter a directory path!");
                continue;
            }
            File[] javaFileList = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java");
                }

            });

            for (File f : javaFileList) {
                System.out.println(f.getName());
            }
            System.out.println("Result " + javaFileList.length + " files!");

        }
    }

    public static void getFileWithSizeGreaterThanInput() {
        while (true) {
            System.out.println("------ Get file with size greater than input ------");
            int minFileSize = Validator.inputSize();
            String path = Validator.inputString("Enter path (0 to exit):");
            if (path.equals("0")) {
                return;
            }

            File file = new File(path);
            if (!file.isDirectory()) {
                System.out.println("Please enter a directory path!");
                continue;
            }

            FileFilter filter = new FileFilter() {
                public boolean accept(File file) {
                    return file.length() > minFileSize;
                }
            };

            File[] javaFileList = file.listFiles(filter);

            for (File f : javaFileList) {
                System.out.println(f.getName());
            }
            System.out.println("Result " + javaFileList.length + " files!");

        }
    }

    public static void appendContentToFile() {
        while (true) {
            System.out.println("------ Write more content to file ------");
            String content = Validator.inputString("Enter content:");
            String path = Validator.inputString("Enter path (0 to exit):");
            if (path.equals("0")) {
                return;
            }
            File file = new File(path);
            if (!file.isFile() || (!file.getName().endsWith(".txt") && !file.getName().endsWith(".txt"))) {
                System.out.println("Please enter a .txt or .java file path!");
                continue;
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.append(content);
                System.out.println("Write done!");
                writer.close();
            } catch (IOException ex) {
                System.out.println("Input Output Error!");
            }
        }
    }

    public static void countCharacter() {
        while (true) {
            System.out.println("------ Read file and count characters ------");
            String path = Validator.inputString("Enter path (0 to exit):");
            if (path.equals("0")) {
                return;
            }
            File file = new File(path);
            if (!file.isFile() || (!file.getName().endsWith(".txt") &&  !file.getName().endsWith(".java"))) {
                System.out.println("Please enter a .txt or .java file path!");
                continue;
            }
            int count = 0;
            try {
               
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    count += words.length;
                }
                reader.close();

            } catch (IOException ioe) {
                System.out.println("Input Output Error!");
            }
            System.out.println("Total: " + count);
        }
    }
}
