/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import processing.core.PApplet;
import static processing.core.PApplet.sin;

public class Sketch extends PApplet {

    List<List<int[][]>> numbersList;
    ArrayList<Perceptron> perceptrons = new ArrayList<>();
    boolean learned = false;
    Cell[][] grid;
    int gridX0 = 0;
    int gridY0 = 0;
    int cellWidth = 30;
    int cellHeight = 30;
    int cols = 7;
    int rows = 7;

    Button clearButton;
    int clearButtonX0 = cellWidth * rows + gridX0 + 50;
    int clearButtonY0 = 30;
    int clearButtonWidth = 100;
    int clearButtonHeight = 30;

    Button learnButton;
    int learnButtonX0 = clearButtonX0;
    int learnButtonY0 = clearButtonY0 + clearButtonHeight;
    int learnButtonWidth = clearButtonWidth;
    int learnButtonHeight = clearButtonHeight;

    Button recognizeButton;
    int recognizeButtonX0 = learnButtonX0;
    int recognizeButtonY0 = learnButtonY0 + learnButtonHeight;
    int recognizeButtonWidth = learnButtonWidth;
    int recognizeButtonHeight = learnButtonHeight;

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main.Sketch"});
    }

    @Override
    public void setup() {

        Numbers numbers = new Numbers();
        numbersList = numbers.numbersList;

        textSize(25);
        grid = new Cell[cols][rows];
        for (int i = gridY0; i < cols; i++) {
            for (int j = gridX0; j < rows; j++) {
                grid[i][j] = new Cell(i * cellWidth, j * cellHeight, cellWidth, cellHeight, 128);
                grid[i][j].display();
            }
        }

        clearButton = new Button(clearButtonX0, clearButtonY0, clearButtonHeight, clearButtonWidth, "clear");
        clearButton.display();

        learnButton = new Button(learnButtonX0, learnButtonY0, learnButtonHeight, learnButtonWidth, "learn");
        learnButton.display();

        recognizeButton = new Button(recognizeButtonX0, recognizeButtonY0, recognizeButtonHeight, recognizeButtonWidth, "answ");
        recognizeButton.display();

    }

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void draw() {

    }

    @Override
    public void mousePressed() {
        update(mouseX, mouseY);
    }

    void update(int x, int y) {
        if (isOverRec(gridX0, gridY0, rows * cellWidth, cols * cellHeight)) {
            switchColorOfCell(x, y);
        } else if (isOverRec(clearButtonX0, clearButtonY0, clearButtonWidth, clearButtonHeight)) {
            clearButton.clear(grid, rows, cols);
        } else if (isOverRec(learnButtonX0, learnButtonY0, learnButtonWidth, learnButtonHeight)) {
            learnButton.learn();
        } else if (isOverRec(recognizeButtonX0, recognizeButtonY0, recognizeButtonWidth, recognizeButtonHeight)) {
            recognizeButton.answer();
        }
    }

    void switchColorOfCell(int x, int y) {
        boolean foundCell = false;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (isOverRec(grid[i][j].x, grid[i][j].y, cellWidth, cellHeight)) {
                    grid[i][j].changeColor();
                    foundCell = true;
                    break;
                }
            }
            if (foundCell) {
                break;
            }
        }
    }

    boolean isOverRec(int x, int y, int width, int height) {
        return mouseX > x && mouseX < x + width
                && mouseY > y && mouseY < y + height;
    }

    class Cell {

        // A cell object knows about its location in the grid 
        // as well as its size with the variables x,y,w,h
        int active = -1;
        int activeColor = 0;
        int inactiveColor = 128;
        int x, y;   // x,y location
        int w, h;   // width and height
        float angle; // angle for oscillating brightness

        // Cell Constructor
        Cell(int tempX, int tempY, int tempW, int tempH, float tempAngle) {
            x = tempX;
            y = tempY;
            w = tempW;
            h = tempH;
            angle = tempAngle;
        }

        protected void setInactive() {
            active = -1;
            display(inactiveColor);
        }

        public void changeColor() {
            if (active == -1) {
                changeActive();
                display(activeColor);
            } else {
                changeActive();
                display(inactiveColor);
            }
        }

        public void changeActive() {
            active = -active;
        }

        // Oscillation means increase angle
        void display() {
            stroke(255);
            // Color calculated using sine wave
            fill(127 + 127 * sin(angle));
            rect(x, y, w, h);
        }

        public void display(float angle) {
            stroke(255);
            // Color calculated using sine wave
            fill(127 + 127 * sin(angle));
            rect(x, y, w, h);
        }
    }

    class Button {

        int x, y;
        int height, width;
        String text;

        void clear(Cell[][] grid, int rows, int cols) {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    grid[i][j].setInactive();
                }
            }
        }

        void learn() {
            Button button = new Button(30, cols*cellHeight+30+30, 50, 400, "uczy");
            button.display();
            Random generator = new Random();
            for (int i = 0; i < 10; i++) {
                List<Example> thisExamples = new ArrayList<>();
                float threshold = Methods.setThreshold();
                float[] weights = Methods.setWages(49, threshold);
                perceptrons.add(new Perceptron(threshold, weights));
                
                for (int k = 0; k < numbersList.size(); k++) {
                    
                    List<int[][]> number = numbersList.get(k);
                    for (int o = 0; o < number.size(); o++) {
                        
                        int[][] n = number.get(o);
                        if (k == i) {
                            thisExamples.add(new Example(Numbers.matrixToVector(n), 1));
                            
      
                        } else {
                            thisExamples.add(new Example(Numbers.matrixToVector(n), -1));
                            

                        }

                    }

                }

                for (int j = 0; j < 10000; j++) {
                    Example currentExample = thisExamples.get(generator.nextInt(thisExamples.size()));
                    float activator = Methods.activator(perceptrons.get(i).weights, currentExample.example, perceptrons.get(i).threshold);
                    float err = currentExample.T - activator;
                   
                    if (err != 0) {

                        perceptrons.get(i).weights = Methods.correctWeights(perceptrons.get(i).weights, currentExample.example, err);
                        perceptrons.get(i).threshold = Methods.correctThreshold(perceptrons.get(i).threshold, err);
                    } 
                }
            }
            button = new Button(30, cols*cellHeight+30+30, 50, 400, "nauczono");
            button.display();
            learned = true;
        }

        void answer() {
            if (learned) {
                char[] tab = new char[10];
                int[][] inputGrid = Methods.cellMatrixToInt(grid);

                int[] input = new int[perceptrons.get(0).weights.length];

                int[] inGrid = Numbers.matrixToVector(inputGrid);
                input[0] = 1;

                for (int j = 1; j < input.length; j++) {
                    input[j] = inGrid[j - 1];
                }

                for (int i = 0; i < 10; i++) {
                    tab[i] = '-';
                    if (1 == Methods.activator(perceptrons.get(i).weights, input, perceptrons.get(i).threshold)) {
                        tab[i] = String.valueOf(i).charAt(0);
                        
                        
                    }
                }
                String recognized="";
                for(int i = 0; i<tab.length;i++){
                    recognized += tab[i];
                }
                Button button = new Button(30, cols*cellHeight+30+30, 50, 400, recognized);
            button.display();
            } else {
                Button button = new Button(30, cols*cellHeight+30+30, 50, 400, "naucz najpierw");
            button.display();
            }
        }

        public Button(int x, int y, int height, int width, String text) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
            this.text = text;
        }

        public void display() {
            stroke(255);
            fill(204, 102, 0);
            rect(x, y, width, height);
            fill(100, 100, 255);
            text(text, x + width / 4, y + height - height / 4);
        }
    }
}
