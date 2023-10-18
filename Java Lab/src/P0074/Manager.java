/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0074;

/**
 *
 * @author ASUS
 */
public class Manager {

    private static int[][] inputMatrix(int matrixNumber) {
        int row = Validator.inputInteger("Enter row matrix " + matrixNumber + ":");
        int column = Validator.inputInteger("Enter column matrix " + matrixNumber + ":");
        int[][] matrix = new int[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Validator.inputInteger("Enter matrix" + matrixNumber + "["+i+"]["+j+"]:");
            }
        }
        return matrix;
    }
    
    private static int[][] additionMatrix (int[][] matrix1, int[][]matrix2){
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] additionMatrix = new int[row][column];
        for (int i = 0; i < additionMatrix.length; i++) {
            for (int j = 0; j < additionMatrix[i].length; j++) {
                additionMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }         
        return additionMatrix;
    }
    
    private static int[][] subtractionMatrix (int[][] matrix1, int[][]matrix2){
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] subtractionMatrix = new int[row][column];
        for (int i = 0; i < subtractionMatrix.length; i++) {
            for (int j = 0; j < subtractionMatrix[i].length; j++) {
                subtractionMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }         
        return subtractionMatrix;
    }
    
    //True : Addtion, False : Subtraction
    public static void matrix_Addition_Or_Subtraction(boolean flag){
        if (flag) System.out.println("=======Addition=======");
        else System.out.println("=======Subtraction=======");
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        //Different row or column
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            System.out.println("Both matrix must have same size!");
            return;
        }
            displayMatrix(matrix1);
            if (flag) System.out.println("+");
            else System.out.println("-");
            displayMatrix(matrix2);
            System.out.println("=");
            if (flag) displayMatrix(additionMatrix(matrix1, matrix2));
            else displayMatrix(subtractionMatrix(matrix1, matrix2));
    }
    
    private static int[][] multiplicationMatrix (int[][] matrix1, int[][]matrix2){
        int row = matrix1.length;
        int column = matrix2[0].length;
        int[][] subtractionMatrix = new int[row][column];
        for (int i = 0; i < subtractionMatrix.length; i++) {
            for (int j = 0; j < subtractionMatrix[i].length; j++) {
                 subtractionMatrix[i][j] = calculateMultiMatrixEntry(matrix1, matrix2, i, j);
            }
        }
        return subtractionMatrix;
    }
    
    private static int calculateMultiMatrixEntry(int[][] matrix1,int[][] matrix2,int row,int column){
        int sum = 0;
        for (int i = 0;i < matrix1[0].length; i ++){
           sum = sum + matrix1[row][i] * matrix2[i][column];
        }
        return sum;
    }
    
    public static void matrix_Multiplication(){
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        //Matrix1 column != Matrix2 row
        if (matrix1[0].length != matrix2.length){
            System.out.println("Matrix 1 columns must be the same with Matrix 2 rows!");
        }
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(multiplicationMatrix(matrix1, matrix2));
    }
    public static void displayMatrix(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }        
    }
}    
