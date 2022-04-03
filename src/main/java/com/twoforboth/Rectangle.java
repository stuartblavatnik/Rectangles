package com.twoforboth;

import java.util.Objects;

public final class Rectangle {

    public final static double epsilon = 0.000001d;

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

    public double getBottom() { return top + height; }

    public double getRight()  { return left + width; }

    public Rectangle(double top, double left, double height, double width) throws RectanglesLibraryException {

        if (height < 0.0d) {
            throw new RectanglesLibraryException("height must be greater than or equal to 0.0");
        }

        if (width < 0.0d) {
            throw new RectanglesLibraryException("width must be greater than or equal to 0.0");
        }

        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public boolean intersects(Rectangle otherRectangle) {

        if (otherRectangle == null) {
            return false;
        }

        double otherLeft = otherRectangle.getLeft();
        double otherTop = otherRectangle.getTop();
        double otherWidth = otherRectangle.getWidth();
        double otherHeight = otherRectangle.getHeight();
        double left = getLeft();
        double top = getTop();

        return otherLeft + otherWidth > left &&
                otherTop + otherHeight > top &&
                otherLeft < left + getWidth() &&
                otherTop < top + getHeight();
    }

    public boolean contains(Rectangle otherRectangle) {

        if (otherRectangle == null) {
            return false;
        }

        double otherLeft = otherRectangle.getLeft();
        double otherTop = otherRectangle.getTop();
        double otherWidth = otherRectangle.getWidth();
        double otherHeight = otherRectangle.getHeight();
        double left = getLeft();
        double top = getTop();

        return (
                otherLeft >= left &&
                otherTop >= top &&
                (otherLeft + otherWidth) < (left + getWidth()) &&
                (otherTop + otherHeight) < (top + getHeight())
        );
    }

    public boolean isAdjacent(Rectangle otherRectangle) {

        if (otherRectangle == null) {
            return false;
        }

        if (Math.abs(getLeft() - otherRectangle.getRight()) < epsilon ||
            Math.abs(otherRectangle.getLeft()- getRight()) < epsilon) {
                return (getTop() < otherRectangle.getBottom() || otherRectangle.getTop() < getBottom());
        }

        if (Math.abs(getTop() - otherRectangle.getBottom()) < epsilon ||
            Math.abs(otherRectangle.getTop() - getBottom()) < epsilon) {
                return !(getRight() < otherRectangle.getLeft() ||
                        otherRectangle.getRight() < getLeft());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Top: " + top + " Left: " + left + " Height: " + height + " Width: " + width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.top, top) == 0 &&
                Double.compare(rectangle.left, left) == 0 &&
                Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, left, height, width);
    }
}
