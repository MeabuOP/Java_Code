package P0058;

import P0056.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu  {

    protected String title;
    protected ArrayList<String> list = new ArrayList();
    
    public Menu(){}
    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = Validator.inputPositiveInt("Please choice one option: ");
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();//list the content of menu
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice < list.size());
    }
}
