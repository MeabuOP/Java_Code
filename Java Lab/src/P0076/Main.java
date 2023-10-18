
package P0076;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CSV> csvList = new ArrayList<>();
        while (true) {            
            System.out.println("======= Format CSV Program =======");
            System.out.println("1. Import CSV");
            System.out.println("2. Format Address");
            System.out.println("3. Format Name");
            System.out.println("4. Export CSV");
            System.out.println("5. Exit");
            int choice = Validator.inputInteger("Enter choice:");
            switch (choice){
                case 1 ->{
                    Manager.readFile(csvList);
                }
                case 2 ->{
                    Manager.formatAddress(csvList);
                }
                case 3 ->{
                    Manager.formatName(csvList);
                }
                case 4 ->{
                    Manager.writeFile(csvList);
                }
                case 5 ->{
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }
}
