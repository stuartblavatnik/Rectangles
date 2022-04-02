package com.twoforboth;

public final class Rectangle {

    private final double epsilon = 0.000001d;

    private double top;
    private double left;
    private double height;
    private double width;

    public double getTop() {
        return top;
    }

    public double getLeft() {
        return left;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle(double top, double left, double height, double width) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public boolean isEmpty() {
        boolean isEmpty;

        isEmpty = (Math.abs(top - 0.0d) < epsilon) &&
                    (Math.abs(left - 0.0d) < epsilon) &&
                    (Math.abs(height - 0.0d) < epsilon) &&
                    (Math.abs(width - 0.0d) < epsilon);

        return isEmpty;
    }

    public boolean intersects(Rectangle otherRectangle) {

        boolean intersects;

        double x = otherRectangle.getLeft();
        double y = otherRectangle.getTop();
        double w = otherRectangle.getWidth();
        double h = otherRectangle.getHeight();
        double x0 = getLeft();
        double y0 = getTop();

        if(isEmpty() || w <= 0 || h <= 0)
            return false;

                intersects = x + w > x0 &&
                        y + h > y0 &&
                        x < x0 + getWidth() &&
                        y < y0 + getHeight();



        return intersects;
    }

    public boolean contains(Rectangle otherRectangle) {

        boolean contains = false;

        return contains;
    }

    public boolean isAdjacent(Rectangle otherRectangle) {

        boolean isAdjacent = false;

        return isAdjacent;
    }


}
