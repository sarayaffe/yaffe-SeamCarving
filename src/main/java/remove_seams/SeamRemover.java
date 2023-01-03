package remove_seams;

import java.awt.*;

public class SeamRemover {
    public Color[][] removeVerticalSeam(Color[][] originalColors, int[] columnIndices) {
        Color[][] newColors = new Color[originalColors.length][originalColors[0].length - 1];

        for (int row = 0; row < newColors.length; row++) {
            int originalColorsCol = 0;
            for (int col = 0; col < newColors[row].length; col++) {
                if (columnIndices[row] == col) {
                    originalColorsCol++;
                }
                newColors[row][col] = originalColors[row][originalColorsCol];
                originalColorsCol++;
            }
        }

        return newColors;
    }

    public Color[][] removeHorizontalSeam(Color[][] originalColors, int[] rowIndices) {
        Color[][] newColors = new Color[originalColors.length - 1][originalColors[0].length];

        for (int col = 0; col < newColors[0].length; col++) {
            int originalColorsRow = 0;
            for (int row = 0; row < newColors.length; row++) {
                if (rowIndices[col] == row) {
                    originalColorsRow++;
                }
                newColors[row][col] = originalColors[originalColorsRow][col];
                originalColorsRow++;
            }
        }

        return newColors;
    }

}
