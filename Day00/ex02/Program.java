package day_00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum;
        int number;
        while (scanner.hasNext()) {
            number = scanner.nextInt();
            if (number == 42)
                break ;
            sum = getSumFromNumber(number);
            if (isSimpleNumber(sum) == true)
                count++;
        }
        System.out.println("Count of coffee-request - " + count);
    }

    public static int getSumFromNumber(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static boolean isSimpleNumber(int number) {
        if (number <= 0 || number == 1 || (number > 2 && number % 2 == 0)) {
            return false;
        }
        for (int d = 3; d * d <= number; d += 2) {
            if (number % d == 0) {
               return false;
            }
        }
        return true;
    }
}
