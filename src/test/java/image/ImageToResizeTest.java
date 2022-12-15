package image;

import calculations.CalculateEnergies;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class ImageToResizeTest {

    ImageToResize imageToResize = new ImageToResize("/seam carving image.jpg");
    BufferedImage bufferedImage = imageToResize.getImage();

    @Test
    void getImage() {
        //given

        //when

        //then
        assertNotNull(bufferedImage);
    }

    @Test
    void getColorArray() {
        //given
        Color[][] colorsArray = imageToResize.getColorArray();
        int imageHeight = bufferedImage.getHeight();
        int imageWidth = bufferedImage.getWidth();

        //when

        //then
        assertEquals(imageWidth, colorsArray.length);
        assertEquals(imageHeight, colorsArray[0].length);

    }
}