import calculations.energies.CalculateEnergies;
import calculations.seams.MinimalEnergies;
import calculations.seams.MinimalEnergySeam;
import remove_seams.SeamRemover;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePresenter {

    CalculateEnergies calculateEnergies = new CalculateEnergies();
    MinimalEnergies minimalEnergies = new MinimalEnergies();
    MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();
    SeamRemover seamRemover = new SeamRemover();


    public ImageIcon resizeImage(BufferedImage originalImage, ImageIcon currentIcon, int width,
                                 int height) {
        BufferedImage imageToBeResized = (BufferedImage) currentIcon.getImage();
        boolean resizeFromOriginalImage = false;

        //confirm whether to resize from original image
        int originalImageHeight = originalImage.getHeight();
        int originalImageWidth = originalImage.getWidth();
        if (width > imageToBeResized.getWidth() || height > imageToBeResized.getHeight()) {
            resizeFromOriginalImage = true;
            //check that height/width don't exceed dimensions of original image
            if (width > originalImageWidth) {
                width = originalImageWidth;
            }
            if (height > originalImageHeight) {
                height = originalImageHeight;
            }
        }

        BufferedImage newBufferedImage;
        //resize from original image
        if (resizeFromOriginalImage) {
            newBufferedImage = removeSeams(originalImage, width, height);
        }
        //resize from current image
        else {
            newBufferedImage = removeSeams(imageToBeResized, width, height);
        }


        return new ImageIcon(newBufferedImage);
    }

    private BufferedImage removeSeams(BufferedImage bufferedImage,
                                      int newWidth, int newHeight) {
        Color[][] colorArray = createColorArray(bufferedImage);

        int numHorizontalToRemove = bufferedImage.getHeight() - newHeight;
        int numVerticalToRemove = bufferedImage.getWidth() - newWidth;
        double[][] energies = calculateEnergies.calculateEnergyValues(colorArray);

        //remove vertical seams
        if (numVerticalToRemove > 0) {
            for (int i = 0; i < numVerticalToRemove; i++) {
                int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
                        minimalEnergies.calculateVerticalMinEnergies(energies));
                colorArray = seamRemover.removeVerticalSeam(colorArray, lowestEnergySeam);
                energies = calculateEnergies.calculateEnergyValues(colorArray);
            }
        }

        //remove horizontal seams
        if (numHorizontalToRemove > 0) {
            for (int i = 0; i < numHorizontalToRemove; i++) {
                int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
                        minimalEnergies.calculateHorizontalMinEnergies(energies));
                colorArray = seamRemover.removeHorizontalSeam(colorArray, lowestEnergySeam);
                energies = calculateEnergies.calculateEnergyValues(colorArray);
            }
        }

        return convertColorsToImage(colorArray, newWidth, newHeight);
    }

    private BufferedImage convertColorsToImage(Color[][] colorArray, int newWidth,
                                               int newHeight) {
        BufferedImage newBufferedImage =
                new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < newHeight; x++) {
            for (int y = 0; y < newWidth; y++) {
                newBufferedImage.setRGB(y, x, colorArray[x][y].getRGB());
            }
        }
        return newBufferedImage;
    }
    private Color[][] createColorArray(BufferedImage imageToResize) {
        Color[][] colorArray = new Color[imageToResize.getHeight()][imageToResize.getWidth()];

        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < colorArray[i].length; j++) {
                colorArray[i][j] = new Color(imageToResize.getRGB(j, i));
            }
        }

        return colorArray;
    }

}
