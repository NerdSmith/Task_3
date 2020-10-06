package ru.vsu.cs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Parabola verticalParabola = new Parabola(5, 0, 0.25);
    public static Parabola horizontalParabola = new Parabola(2, 0, 0.125);
    public static Line verticalLine = new Line(0, 13.5, 5.5);
    public static Line horizontalLine = new Line(-1, -4, 0.25);

    private static SimpleColor getColor(double x, double y) {
        if ((verticalParabola.isPointAboveOfParabola(x, y) && !horizontalParabola.isPointRightOfParabola(x, y))
                || (!horizontalLine.isPointAboveLine(x, y)
                && verticalLine.isPointAboveLine(x, y))) return SimpleColor.GREEN;

        else if (!verticalParabola.isPointAboveOfParabola(x, y) && horizontalParabola.isPointRightOfParabola(x, y)
                && horizontalLine.isPointAboveLine(x, y)) return SimpleColor.WHITE;

        else if (!(verticalLine.isPointAboveLine(x, y) || verticalParabola.isPointAboveOfParabola(x, y)
                || horizontalParabola.isPointRightOfParabola(x, y))) return SimpleColor.ORANGE;
        else return SimpleColor.GRAY;
    }

    private static void printColorForPoint(double x, double y) {
        System.out.println("(" + x +", " + y + ") -> " + getColor(x, y));
    }

    public static double enterPoint(String name){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the %s point ", name);
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        printColorForPoint(-2, -2);
        printColorForPoint(3, 6);
        printColorForPoint(-8, -8);
        printColorForPoint(5, 2);
        printColorForPoint(5, -4);
        printColorForPoint(-7, 0);
        printColorForPoint(7, 0);

        double x = enterPoint("first");
        double y = enterPoint("second");
        printColorForPoint(x, y);

    }
}
