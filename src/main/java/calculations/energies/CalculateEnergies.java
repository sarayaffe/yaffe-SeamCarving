package calculations.energies;

import image.ImageToResize;

import java.awt.*;

public class CalculateEnergies {
    private Color[][] colorArray;
    private double[][] energyArray;
    final static int MAX_ENERGY = 6 * 255 * 255;

    public CalculateEnergies(Color[][] colorArray) {
        this.colorArray = colorArray;

        this.energyArray = new double[colorArray.length][colorArray[0].length];
        setEnergyValues();
    }

    public double[][] getEnergyArray() {
        return energyArray;
    }

    private void setEnergyValues() {
        for (int i = 0; i < energyArray.length; i++) {
            for (int j = 0; j < energyArray[i].length; j++) {
                if (isBorderPixel(i, j)) {
                    energyArray[i][j] = MAX_ENERGY;
                } else {
                    energyArray[i][j] = CalculateEnergyValue(colorArray[i + 1][j], colorArray[i - 1][j],
                            colorArray[i][j - 1], colorArray[i][j + 1]);
                }
            }
        }
    }

    private boolean isBorderPixel(int xCoordinate, int yCoordinate) {
        int maxX = colorArray.length - 1;
        int maxY = colorArray[0].length - 1;
        return xCoordinate == maxX || xCoordinate == 0
                || yCoordinate == maxY || yCoordinate == 0;
    }

    public double CalculateEnergyValue(Color abovePixel, Color belowPixel, Color leftPixel, Color rightPixel) {

        return (abovePixel.getRed() - belowPixel.getRed()) *
                (abovePixel.getRed() - belowPixel.getRed())
                + (abovePixel.getGreen() - belowPixel.getGreen()) *
                (abovePixel.getGreen() - belowPixel.getGreen())
                + (abovePixel.getBlue() - belowPixel.getBlue()) *
                (abovePixel.getBlue() - belowPixel.getBlue())
                + (rightPixel.getRed() - leftPixel.getRed()) *
                (rightPixel.getRed() - leftPixel.getRed())
                + (rightPixel.getGreen() - leftPixel.getGreen()) *
                (rightPixel.getGreen() - leftPixel.getGreen())
                + (rightPixel.getBlue() - leftPixel.getBlue()) *
                (rightPixel.getBlue() - leftPixel.getBlue());
    }

    public Color calculateBrightness(int energy, int minEnergy, int maxEnergy) {
        int bright = (energy - minEnergy) / (maxEnergy - minEnergy) * 255;
        return new Color(bright, bright, bright);
    }


}
