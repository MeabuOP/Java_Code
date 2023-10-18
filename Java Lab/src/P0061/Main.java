/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0061;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            double width = Validator.inputPositiveDouble("Please input side width of Rectangle:");
            double length = Validator.inputPositiveDouble("Please input length of Rectangle:");
            Rectangle rectangle = new Rectangle(width, length);
            double radius = Validator.inputPositiveDouble("Please input radius of Circle:");
            Circle circle = new Circle(radius);
            double sideA;
            double sideB;
            double sideC;
            do {
                sideA = Validator.inputPositiveDouble("Please input side A of Triangle:");
                sideB = Validator.inputPositiveDouble("Please input side B of Triangle:");
                sideC = Validator.inputPositiveDouble("Please input side C of Triangle:");
            } while (!Validator.validTriangle(sideA, sideB, sideC));
            Triangle triangle = new Triangle(sideA, sideB, sideC);
            rectangle.printResult();
            circle.printResult();
            triangle.printResult();
        }
    }
}
