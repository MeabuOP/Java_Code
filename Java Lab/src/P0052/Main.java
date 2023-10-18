/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0052;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
        Menu menu = new Menu("=============Menu=============", new String[]{"Input the information of 11 countries in East Asia","Display the information of country you've just input","Search the information of country by user-entered name","Display the information of countries sorted name in ascending","Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice){
                    case 1 -> {
                        ManageEastAsiaCountries.inputCountry(countryList);
                    }
                    case 2 -> {
                        ManageEastAsiaCountries.printCountry(countryList);
                    }
                    case 3 -> {
                        ManageEastAsiaCountries.searchByName(countryList);
                    }
                    case 4 -> {
                        ManageEastAsiaCountries.printSortedCountry(countryList);
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
