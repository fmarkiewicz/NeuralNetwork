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
public class Perceptron {

    float threshold;
    float[] weights;

    public Perceptron(float threshold, float[] weights) {
        this.threshold = threshold;
        this.weights = weights;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public void setWeights(float[] weights) {
        this.weights = weights;
    }

    public float getThreshold() {
        return threshold;
    }

    public float[] getWeights() {
        return weights;
    }

    
}
