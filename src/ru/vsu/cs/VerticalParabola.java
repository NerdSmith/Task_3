package ru.vsu.cs;

public class VerticalParabola {
    // y = a * (x - x0)^2
    public double x0;
    public double a;

    public VerticalParabola(double x0, double a) {
        this.x0 = x0;
        this.a = a;
    }

    public boolean isPointAboveTheParabola(double x, double y) {
        return y >= a*Math.pow(x - x0, 2);
    }
}
