/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0052;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class ManageEastAsiaCountries {
    
    //allow user input infomation of contries
    public static void inputCountry(ArrayList<EastAsiaCountries> countryList) {
        System.out.print("Enter code of country: ");
        String countryCode = Validator.inputString();
        //check code country exist or not
        if (!Validator.checkCountryExist(countryList, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of country: ");
        String countryName = Validator.inputString();
        float totalArea = (float) Validator.inputTotalArea("Enter total area: ");
        System.out.print("Enter terrain of country: ");
        String countryTerrain = Validator.inputString();
        countryList.add(new EastAsiaCountries(countryCode,countryName, totalArea,countryTerrain));
        System.err.println("Add successful.");
    }    
    
    public static void printCountry(ArrayList<EastAsiaCountries> countryList) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area","Terrain");
        for (EastAsiaCountries eac : countryList) {
            eac.display();
        }
    }

    public static void printSortedCountry(ArrayList<EastAsiaCountries> countryList) {
        Collections.sort(countryList);
        printCountry(countryList);
    }    
    
    public static void searchByName(ArrayList<EastAsiaCountries> countryList) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = Validator.inputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries eac: countryList) {
            if (eac.getCountryName().equalsIgnoreCase(countryName)) {
                eac.display();
            }
        }        
    }    
}
