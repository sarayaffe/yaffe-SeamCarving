package calculations.seams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalEnergiesTest {

    @Test
    void calculateMinEnergies() {
        //given
        double[][] energies = {{1, 4, 3, 5, 2}, {3, 2, 5, 2, 3}, {5, 2, 4, 2, 1}};
        MinimalEnergies minimalEnergies =
                new MinimalEnergies(energies);

        //when

        //then
        double[][] expectedMinEnergies = {{1, 4, 3, 5, 2}, {4, 3, 8, 4, 5}, {8, 5, 7, 6, 5}};

        assertArrayEquals(expectedMinEnergies, minimalEnergies.getMinEnergies());

    }

}