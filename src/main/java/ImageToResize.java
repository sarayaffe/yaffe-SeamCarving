import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToResize {
    private BufferedImage image = null;
    private Pixel[][] pixels;

    public ImageToResize(File imageFile) {
        try {

            image = ImageIO.read(imageFile);

            createPixelsArray();
            setPixelEnergies();

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

    private void setPixelEnergies() {
        for (Pixel[] pixelRow : pixels) {
            for (Pixel pixel : pixelRow) {
                pixel.setEnergy();
            }
        }
    }

}



    /*

        test energy with 3x3 array of ints[][] or colors[][]
        make sure that 3x3 array of pixels->correct 3x3 array of energy

        TODO: calculate brightness
        energy photo based on max and min energies. calculate bright = ((energy-min)/(max-min))*255
        brightness = new color(bright, bright, bright)
        dont include borders when calculating max. borders can just be white
     */

