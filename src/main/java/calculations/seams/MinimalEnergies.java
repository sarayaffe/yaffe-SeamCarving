package calculations.seams;

public class MinimalEnergies {
    private double[][] energies;
    private double[][] minEnergies;

    public MinimalEnergies(double[][] energyArray) {
        this.energies = energyArray;
        this.minEnergies = new double[energies.length][energies[0].length];
        calculateMinEnergies();
    }

    public double[][] getMinEnergies() {
        return minEnergies;
    }

    private double[][] calculateMinEnergies() {
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
        } else if (col + 1 >= minEnergies[row].length) {
            return Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col - 1]);
        } else {
            return Math.min(Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col - 1]),
                    minEnergies[row - 1][col + 1]);
        }
    }
}
