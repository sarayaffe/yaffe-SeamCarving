package calculations.seams;

public class MinimalEnergySeam {

    //should this just be included in CalculateSeams class
    private double[][] minEnergies;
    private int[] minSeam;

    public MinimalEnergySeam(double[][] minEnergies) {
        this.minEnergies = minEnergies;
        this.minSeam = new int[minEnergies.length];
        calculateMinSeam();
    }

    public int[] getMinSeam() {
        return minSeam;
    }

    public int[] calculateMinSeam() {
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

    private int getMinBottomIndex() {
        int numColumns = minSeam.length - 1;
        int minBottomIndex = 0;
        double minBottomEnergy = minEnergies[numColumns][minBottomIndex];
        for (int bottomIndex = 0; bottomIndex < minEnergies[0].length; bottomIndex++) {
            double currBottomEnergy = minEnergies[numColumns][bottomIndex];
            if(currBottomEnergy < minBottomEnergy){
                minBottomEnergy = currBottomEnergy;
                minBottomIndex = bottomIndex;
            }
        }
        return minBottomIndex;
    }
}
