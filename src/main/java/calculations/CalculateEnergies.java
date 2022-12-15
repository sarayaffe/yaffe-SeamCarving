package calculations;

import image.ImageToResize;

import java.awt.*;

public class CalculateEnergies {
    private ImageToResize image;
    private double[][] energyArray;
    final static int MAX_ENERGY = 6 * 255 * 255;

    public CalculateEnergies(ImageToResize image) {
        this.image = image;

        this.energyArray = new double[image.getImage().getWidth()][image.getImage().getHeight()];
        setEnergyValues();
    }

    public double[][] getEnergyArray() {
        return energyArray;
    }

    private void setEnergyValues() {
        for (int i = 0; i < energyArray.length; i++) {
            for (int j = 0; j < energyArray[i].length; j++) {
                if (isBorderPixel(i, j)) {
                    energyArray[i][j] = setEnergy(MAX_ENERGY);
                } else {
                    energyArray[i][j] = setEnergy(image.getColorArray()[i + 1][j], image.getColorArray()[i - 1][j],
                            image.getColorArray()[i][j - 1], image.getColorArray()[i][j + 1]);
                }
            }
        }
    }

    private boolean isBorderPixel(int xCoordinate, int yCoordinate) {
        int maxX = image.getImage().getWidth();
        int maxY = image.getImage().getHeight();
        return xCoordinate == maxX - 1 || xCoordinate == 0
                || yCoordinate == maxY - 1 || yCoordinate == 0;
    }

    public double setEnergy(int borderEnergy) {
        return borderEnergy;
    }

    public double setEnergy(Color abovePixel, Color belowPixel, Color leftPixel, Color rightPixel) {

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
