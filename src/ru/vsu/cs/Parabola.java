package ru.vsu.cs;

public class Parabola {
    /**
     * y = a * (x - x0) + y0
     * x = a * (y - y0) + x0
     */
    private final double x0;
    private final double y0;
    private final double a;

    public Parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointRightOfParabola(double x, double y) {
        return x > a * Math.pow(y - y0, 2) + x0;
    }

    public boolean isPointAboveOfParabola(double x, double y) {
        return y > a * Math.pow(x - x0, 2) + y0;
    }
}
