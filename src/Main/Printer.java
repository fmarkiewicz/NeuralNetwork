/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Hayab_000
 */
public class Printer {
    
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------");
    }

    static void printVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
        }
        System.out.println("------------------------------------------");
    }
}
