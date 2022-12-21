package calculations.seams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalEnergySeamTest {

    @Test
    void calculateMinSeam() {
        //given
        double[][] minEnergies = {{1, 4, 3, 5, 2}, {4, 3, 8, 4, 5}, {8, 5, 7, 6, 5}};
        MinimalEnergySeam minimalEnergySeam = new MinimalEnergySeam(minEnergies);

        //when

        //then
        int[] expectedMinSeam = {1, 1, 0};
        assertArrayEquals(expectedMinSeam, minimalEnergySeam.getMinSeam());
    }

}