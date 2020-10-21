package ru.vsu.cs;

public class Picture {

    private final VerticalParabola verticalParabola;
    private final HorizontalParabola horizontalParabola;
    private final Line verticalLine;
    private final Line horizontalLine;

    public Picture(VerticalParabola verticalParabola, HorizontalParabola horizontalParabola, Line verticalLine, Line horizontalLine) {
        this.verticalParabola = verticalParabola;
        this.horizontalParabola = horizontalParabola;
        this.verticalLine = verticalLine;
        this.horizontalLine = horizontalLine;
    }

    public SimpleColor getColor(double x, double y) {
        if ((verticalParabola.isPointAbove(x, y) && !horizontalParabola.isPointAbove(x, y))
                || (!horizontalLine.isPointAbove(x, y)
                && verticalLine.isPointAbove(x, y))) return SimpleColor.GREEN;

        else if (!verticalParabola.isPointAbove(x, y) && horizontalParabola.isPointAbove(x, y)
                && horizontalLine.isPointAbove(x, y)) return SimpleColor.WHITE;

        else if (!(verticalLine.isPointAbove(x, y) || verticalParabola.isPointAbove(x, y)
                || horizontalParabola.isPointAbove(x, y))) return SimpleColor.ORANGE;
        else return SimpleColor.GRAY;
    }

}
