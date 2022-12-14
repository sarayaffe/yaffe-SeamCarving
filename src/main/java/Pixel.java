import java.awt.*;

public class Pixel {
    final static int MAX_ENERGY = 6 * 255 * 255;
    private ImageToResize image;
    private int xCoordinate;
    private int yCoordinate;
    private Color color;
    private int energy;

    public Pixel(ImageToResize image, int xCoordinate, int yCoordinate) {
        this.image = image;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        color = new Color(image.getImage().getRGB(yCoordinate, xCoordinate));
    }

    private boolean isPixelBorder() {
        int maxX = image.getImage().getHeight();
        int maxY = image.getImage().getWidth();
        return xCoordinate + 1 >= maxX || xCoordinate - 1 < 0
                || yCoordinate + 1 >= maxY || yCoordinate - 1 < 0;
    }

    public void setEnergy() {
        if (isPixelBorder()) {
            energy = MAX_ENERGY;
        } else {
            Color abovePixel = image.getPixels()[xCoordinate + 1][yCoordinate].color;
            Color belowPixel = image.getPixels()[xCoordinate - 1][yCoordinate].color;
            Color rightPixel = image.getPixels()[xCoordinate][yCoordinate + 1].color;
            Color leftPixel = image.getPixels()[xCoordinate][yCoordinate - 1].color;


            energy = (abovePixel.getRed() - belowPixel.getRed()) *
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
    }


}
