package calculations.seams;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MinimalEnergySeamTest {
    MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam();

    @Test
    void calculateMinSeam_vertical() {
        //given
        double[][] verticalMinEnergies = {{1, 4, 3, 5, 2}, {4, 3, 8, 4, 5}, {8, 5, 7, 6, 5}};

        //when

        //then
        int[] expectedMinSeam = {0, 1, 1};
        assertArrayEquals(expectedMinSeam,
                minimalEnergySeam.calculateMinSeam(verticalMinEnergies));
    }

    @Test
    void calculateMinSeam_horizontal() {
        //given
        double[][] horizontalMinEnergies =
                {{1, 3, 5}, {5, 3, 5}, {6, 8, 7}, {11, 8, 9}, {10, 11, 9}};

        //when

        //then
        int[] expectedMinSeam = {0, 1, 0, 1, 2};
        assertArrayEquals(expectedMinSeam,
                minimalEnergySeam.calculateMinSeam(horizontalMinEnergies));
    }

}