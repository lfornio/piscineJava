package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.BColor;

import edu.school21.printer.logic.Transformation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Parameters(separators = "=")
public class Program {
    private static final int W = 1;
    private static final int B = 0;

    @Parameter(names={"--white"})
    private static BColor whitePixel;
    @Parameter(names={"--black"})
    private static BColor blackPixel;
    private static int[][] array;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            printError("Error arguments");
        }

        Program program = new Program();
        try {
            JCommander.newBuilder()
                    .addObject(program)
                    .build()
                    .parse(args);
        }
        catch (Exception ex) {
            printError("Error arguments");
        }

        try {
            BufferedImage sourceImg = ImageIO.read(Program
                    .class.getResource("/resources/image.bmp"));
            array = new Transformation(sourceImg).takeArrayFromImage();
            printArray();
        }
         catch (Exception ex) {
             printError("Error file");
         }
    }

    public static void printArray() {
        ColoredPrinter white = new ColoredPrinter.Builder(1, false)
                .background(whitePixel)
                .build();
        ColoredPrinter black = new ColoredPrinter.Builder(1, false)
                .background(blackPixel)
                .build();

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                if (array[y][x] == W) {
                    white.print("  ");
                } else if (array[y][x] == B) {
                    black.print("  ");
                }
            }
            System.out.println();
        }

    }

    public static void printError(String error) {
        System.err.println(error);
        System.exit(-1);
    }
}
