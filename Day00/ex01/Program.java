package day_00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        if (number <= 0 || number == 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (number > 2 && number % 2 == 0) {
            count++;
            System.out.println("false " + count);
            System.exit(0);
        }
        for (int d = 3; d * d <= number; d += 2) {
            count++;
            if (number % d == 0) {
                System.out.println("false " + count);
                System.exit(0);
            }
        }
        count++;
        System.out.printf("true " + count);
    }
}
