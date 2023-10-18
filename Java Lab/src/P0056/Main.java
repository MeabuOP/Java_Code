/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0056;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> workerList = new ArrayList<>();
        ArrayList<History> historyList = new ArrayList<>();
        workerList.add(new Worker("W 1", "Nghia", 20, 1200, "15 Ha Huy Giap"));
        workerList.add(new Worker("W 2", "Minh", 28, 2000, "28 Tran Duy"));
        workerList.add(new Worker("W 3", "Huy", 45, 800, "74 Minh Mang"));
        Menu menu = new Menu("======== Worker Management =========", new String[]{"Add worker", "Up salary", "Down salary", "Display information salary", "Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 ->  {
                        Manager.addWorker(workerList);
                    }
                    case 2 ->  {
                        Manager.adjustSalary(workerList, historyList, true);
                    }
                    case 3 ->  {
                        Manager.adjustSalary(workerList, historyList, false);
                    }
                    case 4 -> {
                        Manager.displayHistory(historyList);
                    }
                    case 5 -> {
                        System.out.println("Thanks for using!");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
