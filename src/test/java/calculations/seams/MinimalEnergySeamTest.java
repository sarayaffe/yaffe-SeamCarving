package calculations.seams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalEnergySeamTest {

    @Test
    void calculateMinSeam_vertical() {
        //given
        double[][] verticalMinEnergies = {{1, 4, 3, 5, 2}, {4, 3, 8, 4, 5}, {8, 5, 7, 6, 5}};
        MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam(verticalMinEnergies);

        //when

        //then
        int[] expectedMinSeam = {1, 1, 0};
        assertArrayEquals(expectedMinSeam, minimalEnergySeam.getMinSeam());
    }

    @Test
    void calculateMinSeam_horizontal() {
        //given
        double[][] horizontalMinEnergies = {{1, 3, 5}, {5, 3, 5}, {6, 8, 7}, {11, 8, 9}, {10, 11, 9}};
        MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam(horizontalMinEnergies);

        //when

        //then
        int[] expectedMinSeam = {2, 1, 0, 1, 0};
        assertArrayEquals(expectedMinSeam, minimalEnergySeam.getMinSeam());
    }

}