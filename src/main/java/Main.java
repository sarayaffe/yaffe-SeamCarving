import calculations.energies.CalculateEnergies;
import calculations.seams.MinimalEnergies;
import calculations.seams.MinimalEnergySeam;
import image.ImageToResize;

public class Main {
    public static void main(String[] args) {

        ImageToResize imageToResize = new ImageToResize("/seam carving image.jpg");

        //modify color array in imageToResize or instantiate new one here?
        CalculateEnergies calculateEnergies = new CalculateEnergies();
        MinimalEnergies minimalEnergies = new MinimalEnergies();
        MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();




        /*
        * Removing Seams:
        * 1. find lowest energy vertical seam
        * 2. remove seam
        * 3. reset arrays and repeat until remove the amount of columns you want
        * 4. repeat for horizontal seams
        */
    }
}
