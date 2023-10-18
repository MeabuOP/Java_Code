/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0052;

/**
 *
 * @author ASUS
 */
public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries>{
    private String countryTerrain;

    public EastAsiaCountries() {
        
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea,String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.5f%-25s\n", this.countryCode,this.countryName, this.totalArea, this.countryTerrain);
    }

    @Override
    public int compareTo(EastAsiaCountries o) {
        return this.getCountryName().compareTo(o.getCountryName());
    }
    
}
