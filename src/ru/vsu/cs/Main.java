package ru.vsu.cs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static void printColorForPoint(double x, double y, Picture picture) {
        System.out.printf("(%.2f, %.2f) -> %s%n", x, y, picture.getColor(x, y));
    }

    private static double readPoint(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the %s point ", name);
        return scanner.nextDouble();
    }

    private static void printTest(SimpleColor currentResult, SimpleColor correctResult, String testResult) {
        System.out.printf("Result is %s: %s is %s \n", testResult, currentResult, correctResult);
    }

    private static void testPoints(Picture picture) {
        double[][] pointsArr = {{-2, 3, -8, 5, 5, -7, 7}, {-2, 6, -8, 2, -4, 0, 0}};
        SimpleColor[] correctResultsArr = {SimpleColor.ORANGE, SimpleColor.GREEN, SimpleColor.GREEN, SimpleColor.GRAY,
                SimpleColor.GRAY, SimpleColor.GRAY, SimpleColor.WHITE};

        for (int i = 0; i < 7; i++) {
            SimpleColor currentResult = picture.getColor(pointsArr[0][i], pointsArr[1][i]);
            SimpleColor correctResult = correctResultsArr[i];

            if (currentResult == correctResult) {
                printTest(currentResult, correctResult, "correct");
            }
            else {
                printTest(currentResult, correctResult, "incorrect");
            }
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Picture picture = new Picture(new VerticalParabola(5, 0, 0.25),
                new HorizontalParabola(2, 0, 0.125), new Line(0, 13.5, 5.5),
                new Line(-1, -4, 0.25));

        testPoints(picture);

        double x = readPoint("first");
        double y = readPoint("second");
        printColorForPoint(x, y, picture);

    }
}
