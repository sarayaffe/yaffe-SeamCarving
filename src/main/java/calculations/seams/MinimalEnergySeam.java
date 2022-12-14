package calculations.seams;

import java.awt.*;

public class MinimalEnergySeam {

    //vertical minSeam -> array of column indices to be removed starting from top row
    //horizontal minSeam -> array of row indices to be removed starting from first column

    public int[] calculateMinSeam(double[][] minEnergies) {
        int[] minSeam = new int[minEnergies.length];
        int currRow = minSeam.length - 1;
        int currIndex = getMinBottomIndex(minSeam, minEnergies);
        minSeam[minSeam.length - 1] = currIndex;
        for (int i = minSeam.length - 2; i >= 0; i--) {
            currIndex = aboveMinIndex(minEnergies, currRow, minSeam[i + 1]);
            minSeam[i] = currIndex;
            currRow--;
        }
        return minSeam;
    }

    private int aboveMinIndex(double[][] minEnergies, int rowIndex, int colIndex) {
        double above = minEnergies[rowIndex - 1][colIndex];
        if (colIndex - 1 < 0) {
            if (above < minEnergies[rowIndex - 1][colIndex + 1]) {
                return colIndex;
            } else {
                return colIndex + 1;
            }
        } else if (colIndex + 1 >= minEnergies[rowIndex].length) {
            if (above < minEnergies[rowIndex - 1][colIndex - 1]) {
                return colIndex;
            } else {
                return colIndex - 1;
            }
        } else {
            if (above < minEnergies[rowIndex - 1][colIndex - 1] &&
                    above < minEnergies[rowIndex - 1][colIndex + 1]) {
                return colIndex;
            } else if (
                    minEnergies[rowIndex - 1][colIndex - 1] < above &&
                            minEnergies[rowIndex - 1][colIndex - 1] <
                                    minEnergies[rowIndex - 1][colIndex + 1]) {
                return colIndex - 1;
            } else {
                return colIndex + 1;
            }
        }

    }

    private int getMinBottomIndex(int[] minSeam, double[][] minEnergies) {
        int numColumns = minSeam.length - 1;
        int minBottomIndex = 0;
        double minBottomEnergy = minEnergies[numColumns][minBottomIndex];
        for (int bottomIndex = 0; bottomIndex < minEnergies[0].length; bottomIndex++) {
            double currBottomEnergy = minEnergies[numColumns][bottomIndex];
            if (currBottomEnergy < minBottomEnergy) {
                minBottomEnergy = currBottomEnergy;
                minBottomIndex = bottomIndex;
            }
        }
        return minBottomIndex;
    }
}
