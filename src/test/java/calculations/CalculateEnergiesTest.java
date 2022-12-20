package calculations;

import image.ImageToResize;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculateEnergiesTest {
    CalculateEnergies calculateEnergies = new CalculateEnergies(new ImageToResize("/seam carving image.jpg"));
    final static int MAX_ENERGY = 6 * 255 * 255;

    @Test
    void setEnergy() {
        //given
        double[][] energyValues = new double[4][4];
        Color[][] colorArray =
                {{new Color(48, 89, 193), new Color(43, 165, 153), new Color(12, 51, 71),
                        new Color(163, 35, 152)},
                        {new Color(179, 193, 106), new Color(28, 34, 61), new Color(61, 48, 117),
                                new Color(40, 30, 1)},
                        {new Color(117, 79, 48), new Color(83, 94, 88), new Color(183, 191, 118),
                                new Color(86, 94, 76)},
                        {new Color(179, 193, 106), new Color(28, 34, 61), new Color(61, 48, 117),
                                new Color(40, 30, 1)}};

        //when
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i + 1 >= 4 || i - 1 < 0
                        || j + 1 >= 4 || j - 1 < 0) {
                    energyValues[i][j] = MAX_ENERGY;
                } else {
                    energyValues[i][j] =
                            calculateEnergies.CalculateEnergyValue(colorArray[i + 1][j], colorArray[i - 1][j],
                                    colorArray[i][j - 1], colorArray[i][j + 1]);

                }
            }

        }

        //then
        double[][] expected =
                new double[][] {{MAX_ENERGY, MAX_ENERGY, MAX_ENERGY, MAX_ENERGY},
                        {MAX_ENERGY, 45936, 54810, MAX_ENERGY},
                        {MAX_ENERGY, 21800, 153, MAX_ENERGY},
                        {MAX_ENERGY, MAX_ENERGY, MAX_ENERGY, MAX_ENERGY}};

        double[][] actual = new double[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(energyValues[i], 0, actual[i], 0, 4);
        }

        assertArrayEquals(expected, actual);
    }
}