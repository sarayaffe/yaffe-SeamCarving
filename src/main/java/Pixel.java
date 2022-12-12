import java.awt.*;

public class Pixel {
    private ImageToResize image;
    private int xCoordinate;
    private int yCoordinate;
    private Color color;
    private int energy;
    boolean isBorder;


    public Pixel(ImageToResize image, int xCoordinate, int yCoordinate) {
        this.image = image;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        color = new Color(image.getImage().getRGB(xCoordinate, yCoordinate));
        energy = setEnergy();
    }

    private int setEnergy() {
        //TODO: check for borders (one or more of below pixels wont exist) borders should be highest possible value
        Pixel abovePixel = image.getPixels()[xCoordinate+1][yCoordinate];
        Pixel belowPixel = image.getPixels()[xCoordinate-1][yCoordinate];
        Pixel rightPixel = image.getPixels()[xCoordinate][yCoordinate+1];
        Pixel leftPixel = image.getPixels()[xCoordinate][yCoordinate-1];
        return (abovePixel.color.getRed() - belowPixel.color.getRed()) * (abovePixel.color.getRed() - belowPixel.color.getRed())
                + (abovePixel.color.getGreen() - belowPixel.color.getGreen()) * (abovePixel.color.getGreen() - belowPixel.color.getGreen())
                + (abovePixel.color.getBlue() - belowPixel.color.getBlue()) * (abovePixel.color.getBlue() - belowPixel.color.getBlue())
                + (rightPixel.color.getRed() - leftPixel.color.getRed()) * (rightPixel.color.getRed() - leftPixel.color.getRed())
                + (rightPixel.color.getGreen() - leftPixel.color.getGreen()) * (rightPixel.color.getGreen() - leftPixel.color.getGreen())
                + (rightPixel.color.getBlue() - leftPixel.color.getBlue()) * (rightPixel.color.getBlue() - leftPixel.color.getBlue());
    }


}
