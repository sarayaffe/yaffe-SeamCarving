import calculations.energies.CalculateEnergies;
import calculations.seams.MinimalEnergies;
import calculations.seams.MinimalEnergySeam;
import image.ImageToResize;

import java.awt.*;

public class ImagePresenter {

    ImageToResize imageToResize = new ImageToResize("/Broadway_tower_edit.jpg");
    Color[][] colorArray = imageToResize.getColorArray();

    //calculators
    CalculateEnergies calculateEnergies = new CalculateEnergies();
    MinimalEnergies minimalEnergies = new MinimalEnergies();
    MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();


    /*remove seams*/

    double[][] energies = calculateEnergies.calculateEnergyValues(colorArray);
    //for # of vertical seams to remove
    int[] lowestEnergySeam = minimalEnergySeam.calculateMinSeam(
            minimalEnergies.calculateVerticalMinEnergies(energies));
    //remove seam in colorArray
    //recaluclate energyArray
    //repeat for horizontal seams

}
