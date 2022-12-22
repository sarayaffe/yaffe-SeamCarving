package calculations;

import image.ImageToResize;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculateEnergiesTest {

    Color[][] colorArray =
            {
                    {new Color(48, 89, 193),
                            new Color(43, 165, 153),
                            new Color(12, 51, 71),
                            new Color(163, 35, 152)},
                    {new Color(179, 193, 106),
                            new Color(28, 34, 61),
                            new Color(61, 48, 117),
                            new Color(40, 30, 1)},
                    {new Color(117, 79, 48),
                            new Color(83, 94, 88),
                            new Color(183, 191, 118),
                            new Color(86, 94, 76)},
                    {new Color(179, 193, 106),
                            new Color(28, 34, 61),
                            new Color(61, 48, 117),
                            new Color(40, 30, 1)}
            };
    CalculateEnergies calculateEnergies =
            new CalculateEnergies(colorArray);
    final static int MAX_ENERGY = 6 * 255 * 255;

    @Test
    void setEnergy() {
        //given
        double[][] energyValues = calculateEnergies.getEnergyArray();

        //when

        //then
        double[][] expectedEnergyArray =
                new double[][] {{MAX_ENERGY, MAX_ENERGY, MAX_ENERGY, MAX_ENERGY},
                        {MAX_ENERGY, 45936, 54810, MAX_ENERGY},
                        {MAX_ENERGY, 21800, 153, MAX_ENERGY},
                        {MAX_ENERGY, MAX_ENERGY, MAX_ENERGY, MAX_ENERGY}};

        assertArrayEquals(expectedEnergyArray, energyValues);
    }
}