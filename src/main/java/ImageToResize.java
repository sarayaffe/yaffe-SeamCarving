import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToResize {
    private BufferedImage image = null;
    private Pixel[][] pixels;

    public ImageToResize() {
        try {

            File imageFile = new File("src/seam carving image.jpg");
            image = ImageIO.read(imageFile);

            createPixelsArray();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pixel[][] getPixels() {
        return pixels;
    }

    public BufferedImage getImage() {
        return image;
    }
    private void createPixelsArray() {
        pixels = new Pixel[image.getHeight()][image.getWidth()];

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel(this, i, j);
            }
        }
    }
}



    /*
        border should be highest possible value - 6*255^2

        test energy with 3x3 array of ints[][] or colors[][] (maybe switch first dimension to be y and 2nd to be x
        make sure that 3x3 array of pixels->correct 3x3 array of energy
        energy is based off colors of neighbors, not off energy of neighbors

        energy photo based on max and min energies. calculate bright = ((energy-min)/(max-min))*255
        brightness = new color(bright, bright, bright)
        dont include borders when calculating max. borders can just be white

        - energy calculator and energy test classes
     */

