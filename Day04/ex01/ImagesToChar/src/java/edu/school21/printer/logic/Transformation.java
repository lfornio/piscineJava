package edu.school21.printer.logic;

import edu.school21.printer.app.Program;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Transformation {
    BufferedImage bufferedImage;

    public Transformation(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public char[][] takeArrayFromImage()
    {
        char whiteSymbol = Program.getWhiteSymbol();
        char blackSymbol = Program.getBlackSymbol();

        char [][] array = new char[bufferedImage.getHeight()][bufferedImage.getWidth()];

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                if (bufferedImage.getRGB(x, y) == Color.WHITE.getRGB()) {
                    array[y][x] = whiteSymbol;
                } else {
                    array[y][x] = blackSymbol;
                }
            }
        }
        return array;
    }
}
