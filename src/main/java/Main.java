import calculations.energies.CalculateEnergies;
import calculations.seams.MinimalEnergies;
import calculations.seams.MinimalEnergySeam;
import image.ImageToResize;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ImageToResize imageToResize = new ImageToResize("/seam carving image.jpg");
        Color[][] colorArray = imageToResize.getColorArray();

        //calculators
        CalculateEnergies calculateEnergies = new CalculateEnergies();
        MinimalEnergies minimalEnergies = new MinimalEnergies();
        MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();

        //remove seams
        //for # of vertical seams to remove
            double[][] energies = calculateEnergies.calculateEnergyValues(colorArray);
            int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
                    minimalEnergies.calculateVerticalMinEnergies(energies));
            //remove seam in energies
            //remove seam in colorArray
        //repeat for horizontal seams

        //return new image
    }
}
