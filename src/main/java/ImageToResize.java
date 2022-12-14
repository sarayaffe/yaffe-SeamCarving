import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageToResize {
    private BufferedImage image = null;
    private Pixel[][] pixels;
    final static int MAX_ENERGY = 6 * 255 * 255;


    public ImageToResize(String filePath) {
        try (InputStream inputStream = ImageToResize.class.getResourceAsStream(filePath)) {

            image = ImageIO.read(inputStream);

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
        pixels = new Pixel[image.getWidth()][image.getHeight()];

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel();
            }
        }
    }

    private void setPixelEnergies() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if(isPixelBorder(i, j)){
                    pixels[i][j].setEnergy(MAX_ENERGY);
                }
                else {
                    pixels[i][j].setEnergy(image.getRGB(i + 1, j), image.getRGB(i - 1, j),
                            image.getRGB(i, j - 1), image.getRGB(i, j + 1));
                }
            }
        }
    }

    private boolean isPixelBorder(int xCoordinate, int yCoordinate) {
        int maxX = image.getWidth();
        int maxY = image.getHeight();
        return xCoordinate + 1 >= maxX || xCoordinate - 1 < 0
                || yCoordinate + 1 >= maxY || yCoordinate - 1 < 0;
    }

}



    /*
        TODO: calculate brightness
        energy photo based on max and min energies. calculate bright = ((energy-min)/(max-min))*255
        brightness = new color(bright, bright, bright)
        dont include borders when calculating max. borders can just be white
     */

