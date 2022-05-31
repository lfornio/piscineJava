package edu.school21.printer.app;

import edu.school21.printer.logic.Transformation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    private static char whiteSymbol;
    private static char blackSymbol;
    private static String filePath;

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            printError("Error arguments");
        }

        whiteSymbol = foundSymbol(args[0]);
        blackSymbol = foundSymbol(args[1]);
        filePath = args[2];

        File file = new File(filePath);
        if (!file.exists() || !file.canRead() || file.isDirectory()) {
            printError("Error file");
        }

        BufferedImage sourceImg = ImageIO.read(file);

        char[][] array = new Transformation(sourceImg).takeArrayFromImage();

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
