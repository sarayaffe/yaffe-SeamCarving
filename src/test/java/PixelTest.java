import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void setEnergy() {
        //given
        Pixel[][] pixels = new Pixel[4][4];
        int[][] rgbValues = {{1, 2, 3, 4},
                {4, 5000, 156, 8},
                {9, 20, 11, 12},
                {13, 14, 40, 16}};

        //when
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Pixel currPixel = new Pixel();
                pixels[i][j] = currPixel;
                if (i + 1 >= 4 || i - 1 < 0
                        || j + 1 >= 4 || j - 1 < 0) {
                    currPixel.setEnergy(6 * 255 * 255);
                } else {
                    currPixel.setEnergy(rgbValues[i + 1][j], rgbValues[i - 1][j],
                            rgbValues[i][j - 1], rgbValues[i][j + 1]);
                }
            }

        }

        //then
        assertEquals(390150, pixels[0][0].getEnergy());
        assertEquals(390150, pixels[0][1].getEnergy());
        assertEquals(390150, pixels[0][2].getEnergy());
        assertEquals(390150, pixels[0][3].getEnergy());
        assertEquals(390150, pixels[1][0].getEnergy());
        assertEquals(23428, pixels[1][1].getEnergy());
        assertEquals(16809, pixels[1][2].getEnergy());
        assertEquals(390150, pixels[1][3].getEnergy());
        assertEquals(390150, pixels[2][0].getEnergy());
        assertEquals(15249, pixels[2][1].getEnergy());
        assertEquals(13520, pixels[2][2].getEnergy());
        assertEquals(390150, pixels[2][3].getEnergy());
        assertEquals(390150, pixels[3][0].getEnergy());
        assertEquals(390150, pixels[3][1].getEnergy());
        assertEquals(390150, pixels[3][2].getEnergy());
        assertEquals(390150, pixels[3][3].getEnergy());

    }
}