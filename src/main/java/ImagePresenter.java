import calculations.energies.CalculateEnergies;
import calculations.seams.MinimalEnergies;
import calculations.seams.MinimalEnergySeam;
import remove_seams.SeamRemover;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePresenter {

    //calculators
    CalculateEnergies calculateEnergies = new CalculateEnergies();
    MinimalEnergies minimalEnergies = new MinimalEnergies();
    MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();
    SeamRemover seamRemover = new SeamRemover();


    public ImageIcon resizeImage(ImageIcon currentIcon, int width, int height) {
        BufferedImage newBufferedImage = (BufferedImage) currentIcon.getImage();
        Color[][] colorArray = new Color[newBufferedImage.getWidth()][newBufferedImage.getHeight()];

        newBufferedImage = removeSeams(newBufferedImage, colorArray, width, height);

        return new ImageIcon(newBufferedImage);
    }

    private BufferedImage removeSeams(BufferedImage newBufferedImage, Color[][] colorArray,
                                      int newWidth, int newHeight) {
        double[][] energies = calculateEnergies.calculateEnergyValues(colorArray);
        int numVerticalToRemove = newBufferedImage.getWidth() - newWidth;
        int numHorizontalToRemove = newBufferedImage.getHeight() - newHeight;

        //remove vertical seams
        if (numVerticalToRemove > 0) {
            for (int i = 0; i < numVerticalToRemove; i++) {
                int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
                        minimalEnergies.calculateVerticalMinEnergies(energies));
                seamRemover.removeVerticalSeam(colorArray, lowestEnergySeam);
                energies = calculateEnergies.calculateEnergyValues(colorArray);
            }
        }

        //remove horizontal seams
        if (numHorizontalToRemove > 0) {
            for (int i = 0; i < numHorizontalToRemove; i++) {
                int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
                        minimalEnergies.calculateHorizontalMinEnergies(energies));
                seamRemover.removeHorizontalSeam(colorArray, lowestEnergySeam);
                energies = calculateEnergies.calculateEnergyValues(colorArray);
            }
        }

        //convert modified colorArray to a BufferedImage
        BufferedImage bufferedImage =
                new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                bufferedImage.setRGB(x, y, colorArray[x][y].getRGB());
            }
        }

        return bufferedImage;
    }


}
