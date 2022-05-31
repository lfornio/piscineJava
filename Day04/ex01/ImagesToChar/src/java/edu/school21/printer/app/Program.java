package edu.school21.printer.app;

import edu.school21.printer.logic.Transformation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class Program {

    private static char whiteSymbol;
    private static char blackSymbol;
    private static char[][] array;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            printError("Error arguments");
        }

        whiteSymbol = foundSymbol(args[0]);
        blackSymbol = foundSymbol(args[1]);

        try {
            BufferedImage sourceImg = ImageIO.read(Program
                    .class.getResource("/resources/image.bmp"));
            array = new Transformation(sourceImg).takeArrayFromImage();
        } catch (Exception ex) {
            printError("Error file");
        }

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                System.out.print(array[y][x]);
            }
            System.out.println();
        }
    }

    public static char getWhiteSymbol() {
        return whiteSymbol;
    }

    public static char getBlackSymbol() {
        return blackSymbol;
    }

    public static char foundSymbol(String source) {
        if (source.length() != 1) {
            printError("Error arguments");
        }
        char result = source.charAt(0);
        return result;
    }

    public static void printError(String error) {
        System.err.println(error);
        System.exit(-1);
    }
}
