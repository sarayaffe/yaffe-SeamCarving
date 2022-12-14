import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

import static org.junit.jupiter.api.Assertions.*;

class ImageToResizeTest {

    ImageToResize imageToResize = new ImageToResize(new File("src/seam carving image.jpg"));
    BufferedImage bufferedImage = imageToResize.getImage();

    @Test
    void getImage() {
        //given

        //when

        //then
        assertNotNull(bufferedImage);
    }

    @Test
    void getPixels() {
        //given
        Pixel[][] pixels = imageToResize.getPixels();
        int imageHeight = bufferedImage.getHeight();
        int imageWidth = bufferedImage.getWidth();

        //when

        //then
        assertTrue(pixels.length == imageHeight && pixels[0].length == imageWidth);
    }
}