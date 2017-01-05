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
public class Example {
    int[] example;
    int T;

    public Example(int[] example, int T) {
        this.example = new int[example.length + 1];
        this.example[0] = 1;
        for(int i = 1; i<example.length; i++){
            this.example[i] = example[i-1];
        }
       
        this.T = T;
    }

    public int getT() {
        return T;
    }

    public int[] getExample() {
        return example;
    }
}
