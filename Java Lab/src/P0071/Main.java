

package P0071;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {
    
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        while (true) {            
            System.out.println("========= Task program =========");
            System.out.println("1.	Add Task");
            System.out.println("2.	Delete task");
            System.out.println("3.	Display Task");
            System.out.println("4.	Exit");
            int choice = Validator.inputInteger("Enter choice:");
            switch (choice){
                case 1 -> {
                    Manager.addTask(taskList);
                }
                case 2 -> {
                    Manager.deleteTask(taskList);
                }
                case 3 -> {
                    Manager.displayTask(taskList);
                }
                case 4 -> {
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }
}
