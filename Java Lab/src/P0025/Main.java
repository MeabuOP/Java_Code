/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0025;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.readFile();
        m.normalizeContent();
        m.printResult();
        m.writeFile();
    }
}
