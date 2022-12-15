package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageToResize {
    private BufferedImage image = null;
    private Color[][] colorArray;
    public BufferedImage getImage() {
        return image;
    }

    public ImageToResize(String filePath) {
        try (InputStream inputStream = ImageToResize.class.getResourceAsStream(filePath)) {
            image = ImageIO.read(inputStream);

            this.colorArray = new Color[image.getWidth()][image.getHeight()];
            setColors();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Color[][] getColorArray() {
        return colorArray;
    }

    private void setColors() {
        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < colorArray[i].length; j++) {
                colorArray[i][j] = new Color(image.getRGB(i,j));
            }
        }
    }
/*
   1. Read image -> BufferedImage -> 2d array of colors or ints
   2. double[][] energy
   3. find lowest energy vertical seam
           seam - array of ints - ints being list of j coordinates for vertical seam and i coordinates for horizontal seam
   4. remove seam
   5. goto 2 and repeat until remove the amount of columns you want and then do same horizontally

   TESTS
   generating for seams horizontally and vertically
   removing seams
 */

}

