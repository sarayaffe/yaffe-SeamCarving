package calculations.seams;

public class MinimalEnergies {
    private double[][] energies;
    private double[][] verticalMinEnergies;
    private double[][] horizontalMinEnergies;


    public MinimalEnergies(double[][] energyArray) {
        this.energies = energyArray;


        //values for horizontal array will have inverse index values of the vertical array.
        // ex: horizontal[0][1] == vertical [1][0]
        this.verticalMinEnergies = new double[energies.length][energies[0].length];
        this.horizontalMinEnergies = new double[energies[0].length][energies.length];

        calculateVerticalMinEnergies();
        calculateHorizontalMinEnergies();

    }

    public double[][] getVerticalMinEnergies() {
        return verticalMinEnergies;
    }

    public double[][] getHorizontalMinEnergies() {
        return horizontalMinEnergies;
    }

    private void calculateVerticalMinEnergies() {
        for (int row = 0; row < verticalMinEnergies.length; row++) {
            for (int col = 0; col < verticalMinEnergies[row].length; col++) {
                double currEnergyIndex = energies[row][col];
                if (row - 1 < 0) {
                    verticalMinEnergies[row][col] = currEnergyIndex;
                } else {
                    verticalMinEnergies[row][col] =
                            currEnergyIndex + aboveMin(verticalMinEnergies, row, col);
                }
            }
        }
    }

    private void calculateHorizontalMinEnergies() {
        for (int row = 0; row < horizontalMinEnergies.length; row++) {
            for (int col = 0; col < horizontalMinEnergies[row].length; col++) {
                double currEnergyIndex = energies[col][row];
                if (row - 1 < 0) {
                    horizontalMinEnergies[row][col] = currEnergyIndex;
                } else {
                    horizontalMinEnergies[row][col] =
                            currEnergyIndex + aboveMin(horizontalMinEnergies, row, col);
                }
            }
        }
    }

    private double aboveMin(double[][] minEnergies, int row, int col) {
        if (col - 1 < 0) {
            return Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col + 1]);
        } else if (col + 1 >= minEnergies[row].length) {
            return Math.min(minEnergies[row - 1][col], minEnergies[row - 1][col - 1]);
        } else {
            return Math.min(Math.min(
                            minEnergies[row - 1][col], minEnergies[row - 1][col - 1]),
                    minEnergies[row - 1][col + 1]);
        }
    }
}
