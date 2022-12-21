package calculations.seams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalEnergiesTest {

    double[][] energies = {{1, 4, 3, 5, 2}, {3, 2, 5, 2, 3}, {5, 2, 4, 2, 1}};
    MinimalEnergies minimalEnergies =
            new MinimalEnergies();

    @Test
    void calculateVerticalMinEnergies() {
        //given

        //when

        //then
        double[][] expectedMinEnergies = {{1, 4, 3, 5, 2}, {4, 3, 8, 4, 5}, {8, 5, 7, 6, 5}};
        assertArrayEquals(expectedMinEnergies, minimalEnergies.calculateVerticalMinEnergies(energies));

    }

    @Test
    void calculateHorizontalMinEnergies() {
        //given

        //when

        //then
        double[][] expectedMinEnergies = {{1, 3, 5}, {5, 3, 5}, {6, 8, 7}, {11, 8, 9}, {10, 11, 9}};
        assertArrayEquals(expectedMinEnergies, minimalEnergies.calculateHorizontalMinEnergies(energies));
    }

}