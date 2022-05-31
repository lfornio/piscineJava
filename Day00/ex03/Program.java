package day_00.ex03;

import java.util.Scanner;

public class Program {
    private static final int MAX_NUMBERS_WEEK = 18;
    private static final int MAX_COUNT_GRADE = 5;
    private static final int MAX_GRADE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String week;
        long allGrades = 0;
        int countWeek = 0;
        int tmp;
        int countGrade;
        int minGrade;
        while (scanner.hasNext()) {
            week = scanner.nextLine();
            if (isWeekСorrect(week, countWeek) == false) {
                break ;
            }
            countWeek++;
            countGrade = 0;
            minGrade = MAX_GRADE;
            while (countGrade < MAX_COUNT_GRADE) {
                tmp = scanner.nextInt();
                if (tmp <= 0 || tmp > MAX_GRADE) {
                    printError("Grade is not between 1 and 9");
                }
                if (tmp < minGrade) {
                    minGrade = tmp;
                }
                countGrade++;
            }
            scanner.nextLine();
            allGrades = allGrades * 10 + minGrade;
            if (countWeek == MAX_NUMBERS_WEEK) {
                break ;
            }
        }
        printGrade(countWeek, allGrades);
    }

    public static boolean isWeekСorrect(String str, int count) {
        if (str.equals("42")) {
            return false;
        }
        if (str.equals("Week " + (count + 1)) == false) {
            printError("IllegalArgument");
        }
        return true;
    }

    public static void printError(String error) {
        System.err.println(error);
        System.exit(-1);
    }

    public static void printGrade(int weeks, long grades) {
        for (int index = 1; index <= weeks; index++) {
            System.out.print("Week ");
            System.out.print(index);
            System.out.print(" ");
            for (int i = 0; i < getMinFromAllGrades(grades, weeks, index); i++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }

    public static int getMinFromAllGrades(long grades, int weeks, int index) {
        int result;
        for (int i = 0; i < weeks - index; i++) {
            grades /= 10;
        }
        result = (int)(grades % 10);
        return result;
    }

}
