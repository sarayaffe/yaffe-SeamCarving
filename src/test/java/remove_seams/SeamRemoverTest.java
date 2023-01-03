package remove_seams;

import org.junit.jupiter.api.Test;
import remove_seams.SeamRemover;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SeamRemoverTest {
    SeamRemover seamRemover = new SeamRemover();

    Color[][] colorArray = {
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

    //not actual min energy seam
    int[] seamToRemove = {0, 1, 2, 1};

    @Test
    void removeVerticalSeam() {
        //given

        //when

        //then
        Color[][] expectedNewColors = {
                {new Color(43, 165, 153),
                        new Color(12, 51, 71),
                        new Color(163, 35, 152)},
                {new Color(179, 193, 106),
                        new Color(61, 48, 117),
                        new Color(40, 30, 1)},
                {new Color(117, 79, 48),
                        new Color(83, 94, 88),
                        new Color(86, 94, 76)},
                {new Color(179, 193, 106),
                        new Color(61, 48, 117),
                        new Color(40, 30, 1)}
        };
        assertArrayEquals(expectedNewColors,
                seamRemover.removeVerticalSeam(colorArray, seamToRemove));
    }

    @Test
    void removeHorizontalSeam() {
        //given

        //when

        //then
        Color[][] expectedNewColors = {
                {new Color(179, 193, 106),
                        new Color(43, 165, 153),
                        new Color(12, 51, 71),
                        new Color(163, 35, 152)},
                {new Color(117, 79, 48),
                        new Color(83, 94, 88),
                        new Color(61, 48, 117),
                        new Color(86, 94, 76)},
                {new Color(179, 193, 106),
                        new Color(28, 34, 61),
                        new Color(61, 48, 117),
                        new Color(40, 30, 1)}
        };
        assertArrayEquals(expectedNewColors,
                seamRemover.removeHorizontalSeam(colorArray, seamToRemove));
    }
}