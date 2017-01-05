/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Sketch.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hayab_000
 */
public class Methods {

    public static float learnStatic = (float) 0.1;
    static Random generator = new Random();
    
    private static boolean checkIfDiffValues(List<Float> values, float val){
        boolean diff = true;
        for (int i = 0; i < values.size(); i++){
            if (values.get(i) == val) diff = false;
        }
        return diff;
    }

    public static float[] getRandomFloats(int amount) {
        List<Float> wagi = new ArrayList<>();
        
        boolean diff = true;
        float[] weights = new float[amount + 1];
        for (int i = 0; i < amount; i++) {
            while (diff){
                weights[i] = (float) (generator.nextInt(200) - 100) / 100;
                wagi.add(weights[i]);
                diff = checkIfDiffValues(wagi, weights[i]);
            }
        }
        return weights;
    }

    public static float getSumOfMultiplications(float[] weights, int[] input) {
        float sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * input[i];
        }
        
        return sum;
    }

    public static int activator(float[] weights, int[] input, float threshold) {
        int output = 0;
        float sum = getSumOfMultiplications(weights, input);
        if (sum >= threshold) {
            output = 1;
        } else {
            output = -1;
        }
        return output;
    }

    public static float[] correctWeights(float[] weights, int[] input, float err) {
        float[] tmpWeights = new float[weights.length];
        for (int i = 0; i < weights.length; i++) {
            tmpWeights[i] = weights[i] + learnStatic * err * input[i];
        }
        return tmpWeights;
    }

    public static float correctThreshold(float threshold, float err) {
        return threshold -= err * learnStatic;
    }

    public static float setThreshold() { // zwraca floaty od -0.5 do 0.5 czyli -learnStatic do learnStatic
        int limit = (int) (learnStatic * 100);
        return (float) (generator.nextInt(limit * 2) - limit) / 100;
    }

    public static float[] setWages(int amount, float threshold) {
        float[] weights = getRandomFloats(amount);
        float toLast = weights[0];
        weights[0] = -1 * threshold;
        weights[weights.length - 1] = toLast;
        return weights;
    }

    public static int[][] cellMatrixToInt(Cell[][] matrix) {
        int[][] intMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                intMatrix[i][j] = matrix[i][j].active;
            }
        }
        return intMatrix;
    }
}
