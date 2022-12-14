import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {
    private int energy;
    private Color brightness;

    public Pixel() {
    }

    public void setEnergy(int borderEnergy) {
        energy = borderEnergy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int abovePixel, int belowPixel, int leftPixel, int rightPixel) {
        Color abovePixelColor = new Color(abovePixel);
        Color belowPixelColor = new Color(belowPixel);
        Color rightPixelColor = new Color(rightPixel);
        Color leftPixelColor = new Color(leftPixel);

        energy = (abovePixelColor.getRed() - belowPixelColor.getRed()) *
                (abovePixelColor.getRed() - belowPixelColor.getRed())
                + (abovePixelColor.getGreen() - belowPixelColor.getGreen()) *
                (abovePixelColor.getGreen() - belowPixelColor.getGreen())
                + (abovePixelColor.getBlue() - belowPixelColor.getBlue()) *
                (abovePixelColor.getBlue() - belowPixelColor.getBlue())
                + (rightPixelColor.getRed() - leftPixelColor.getRed()) *
                (rightPixelColor.getRed() - leftPixelColor.getRed())
                + (rightPixelColor.getGreen() - leftPixelColor.getGreen()) *
                (rightPixelColor.getGreen() - leftPixelColor.getGreen())
                + (rightPixelColor.getBlue() - leftPixelColor.getBlue()) *
                (rightPixelColor.getBlue() - leftPixelColor.getBlue());
    }

    public void setBrightness(int minEnergy, int maxEnergy) {
        int bright = (energy - minEnergy) / (maxEnergy - minEnergy) * 255;
        brightness = new Color(bright, bright, bright);
    }

}
