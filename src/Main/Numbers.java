/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hayab_000
 */
public class Numbers {
//    int rows = 7;
//    int cols = 7;

    List<int[][]> zeros = new ArrayList<>();
    List<int[][]> ones = new ArrayList<>();
    List<int[][]> twos = new ArrayList<>();
    List<int[][]> threes = new ArrayList<>();
    List<int[][]> fours = new ArrayList<>();
    List<int[][]> fives = new ArrayList<>();
    List<int[][]> sixs = new ArrayList<>();
    List<int[][]> sevens = new ArrayList<>();
    List<int[][]> eights = new ArrayList<>();
    List<int[][]> nines = new ArrayList<>();

    List<List<int[][]>> numbersList = new ArrayList<>();

    static public int[] matrixToVector(int[][] matrix) {
        int iterator = 0;
        int[] vector = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                vector[iterator] = matrix[i][j];
                iterator++;
            }
        }
        return vector;
    }

    public List<List<int[][]>> getNumbersList() {
        return numbersList;
    }

    public List<int[][]> getEights() {
        return eights;
    }

    public List<int[][]> getFives() {
        return fives;
    }

    public List<int[][]> getFours() {
        return fours;
    }

    public List<int[][]> getNines() {
        return nines;
    }

    public List<int[][]> getOnes() {
        return ones;
    }

    public List<int[][]> getSevens() {
        return sevens;
    }

    public List<int[][]> getSixs() {
        return sixs;
    }

    public List<int[][]> getThrees() {
        return threes;
    }

    public List<int[][]> getTwos() {
        return twos;
    }

    public List<int[][]> getZeros() {
        return zeros;
    }

    static int[][] zero1 = new int[][]{
        {1, 1, 1, 1, 1, 1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] zero2 = new int[][]{
        {1, 1, 1, 1, 1, 1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, -1, -1, -1, -1, -1, 1},
        {1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] one1 = new int[][]{
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, 1, 1, -1, -1, -1},
        {-1, 1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] one2 = new int[][]{
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, 1, 1, -1, -1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] two1 = new int[][]{
        {-1, -1, 1, 1, 1, -1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, 1, -1, -1, -1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] two2 = new int[][]{
        {-1, -1, 1, 1, 1, -1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, 1, -1, -1, -1, -1},
        {-1, -1, 1, 1, 1, 1, -1}
    };

    static int[][] three1 = new int[][]{
        {-1, -1, 1, 1, 1, -1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, 1, 1, -1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, 1, 1, 1, -1, -1}
    };

    static int[][] three2 = new int[][]{
        {-1, -1, 1, 1, 1, -1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, 1, 1, -1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, 1, 1, 1, -1, -1}
    };

    static int[][] four1 = new int[][]{
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, 1, -1, -1},
        {-1, -1, 1, -1, 1, -1, -1},
        {-1, 1, 1, 1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1}
    };

    static int[][] four2 = new int[][]{
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, 1, -1, -1},
        {-1, -1, 1, -1, 1, -1, -1},
        {-1, -1, 1, 1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1}
    };

    static int[][] five1 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] five2 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, -1, 1, 1, 1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] six1 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] six2 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, -1, -1, -1, -1, -1},
        {-1, 1, 1, 1, 1, -1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] seven1 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1}
    };

    static int[][] seven2 = new int[][]{
        {-1, 1, 1, 1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, -1, 1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1},
        {-1, -1, -1, 1, -1, -1, -1}
    };

    static int[][] eight1 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] eight2 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, -1, -1}
    };

    static int[][] nine1 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    static int[][] nine2 = new int[][]{
        {-1, 1, 1, 1, 1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, 1, -1, -1, -1, 1, -1},
        {-1, -1, 1, 1, 1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, -1, -1, -1, -1, 1, -1},
        {-1, 1, 1, 1, 1, 1, -1}
    };

    public Numbers() {
        zeros.add(zero1);
        zeros.add(zero2);
        ones.add(one1);
        ones.add(one2);
        twos.add(two1);
        twos.add(two2);
        threes.add(three1);
        threes.add(three2);
        fours.add(four1);
        fours.add(four2);
        fives.add(five1);
        fives.add(five2);
        sixs.add(six1);
        sixs.add(six2);
        sevens.add(seven1);
        sevens.add(seven2);
        eights.add(eight1);
        eights.add(eight2);
        nines.add(nine1);
        nines.add(nine2);
        numbersList.add(zeros);
        numbersList.add(ones);
        numbersList.add(twos);
        numbersList.add(threes);
        numbersList.add(fours);
        numbersList.add(fives);
        numbersList.add(sixs);
        numbersList.add(sevens);
        numbersList.add(eights);
        numbersList.add(nines);
    }

}
