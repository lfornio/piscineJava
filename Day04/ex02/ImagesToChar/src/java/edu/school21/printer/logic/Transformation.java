package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Transformation {
    private static final int W = 1;
    private static final int B = 0;

    BufferedImage bufferedImage;

    public Transformation(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int[][] takeArrayFromImage()
    {
       int [][] array = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                if (bufferedImage.getRGB(x, y) == Color.WHITE.getRGB()) {
                    array[y][x] = W;
                } else {
                    array[y][x] = B;
                }
            }
        }
        return array;
    }
}
