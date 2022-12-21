package calculations.seams;

public class MinimalEnergies {
        //values for horizontal array will have inverse index values of the vertical array.
        // ex: horizontal[0][1] == vertical [1][0]

    public double[][] calculateVerticalMinEnergies(double[][] energies) {
        double[][] verticalMinEnergies = new double[energies.length][energies[0].length];

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
        return verticalMinEnergies;
    }

    public double[][] calculateHorizontalMinEnergies(double[][] energies) {
        double[][] horizontalMinEnergies = new double[energies[0].length][energies.length];
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
        return horizontalMinEnergies;
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
