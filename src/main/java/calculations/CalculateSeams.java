package calculations;

public class CalculateSeams {
    private double[][] energies;
    private double[][] minEnergies;

    public CalculateSeams(double[][] energyArray) {
        this.energies = energyArray;
        this.minEnergies = calculateMinEnergies();
    }

    private double[][] calculateMinEnergies() {
        double[][] minEnergies = new double[energies.length][energies[0].length];
        for (int row = 0; row < minEnergies.length; row++) {
            for (int col = 0; col < minEnergies[row].length; col++) {
                double currEnergyIndex = energies[row][col];
                if (row - 1 < 0) {
                    minEnergies[row][col] = currEnergyIndex;
                } else {
                    minEnergies[row][col] = currEnergyIndex + aboveMin(row, col);
                }
            }
        }
        return minEnergies;
    }

    private double aboveMin(int row, int col) {
        if (col - 1 < 0) {
            return Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col + 1]);
        } else if (col + 1 >= energies[row].length) {
            return Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col - 1]);
        } else {
            return Math.min(Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col - 1]),
                    minEnergies[row - 1][col + 1]);
        }
    }

    public int[] getMinSeam() {
        int[] minSeam = new int[minEnergies.length];

        int currRow = minSeam.length - 1;
        int currIndex = getMinBottomIndex();
        minSeam[0] = currIndex;
        for (int i = 1; i < minSeam.length; i++) {
            currIndex = aboveMinIndex(currRow, minSeam[i - 1]);
            minSeam[i] = currIndex;
            currRow--;
        }

        return minSeam;
    }

    private int aboveMinIndex(int rowIndex, int colIndex) {
        double above = minEnergies[rowIndex - 1][colIndex];
        if (colIndex - 1 < 0) {
            if (above < minEnergies[rowIndex - 1][colIndex + 1]) {
                return colIndex;
            } else {
                return colIndex + 1;
            }
        } else if (colIndex + 1 >= energies[rowIndex].length) {
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

    private int getMinBottomIndex() {
        int minBottomIndex = 0;
        double minBottomEnergy = minEnergies[0][0];
        for (double[] minEnergyRow : minEnergies) {
            for (int col = 0; col < minEnergyRow.length; col++) {
                if (minEnergyRow[col] < minBottomEnergy) {
                    minBottomIndex = col;
                    minBottomEnergy = minEnergyRow[col];
                }
            }
        }
        return minBottomIndex;
    }
}
