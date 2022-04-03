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

    public boolean isEmpty() {
        boolean isEmpty;

        isEmpty = (Math.abs(top - 0.0d) < epsilon) &&
                    (Math.abs(left - 0.0d) < epsilon) &&
                    (Math.abs(height - 0.0d) < epsilon) &&
                    (Math.abs(width - 0.0d) < epsilon);

        return isEmpty;
    }

    public boolean intersects(Rectangle otherRectangle) {

        double otherLeft = otherRectangle.getLeft();
        double otherTop = otherRectangle.getTop();
        double otherWidth = otherRectangle.getWidth();
        double otherHeight = otherRectangle.getHeight();
        double left = getLeft();
        double top = getTop();

        if (isEmpty() && otherRectangle.isEmpty()) {
            return true;
        }
        else if (isEmpty() || otherRectangle.isEmpty()) {
            return false;
        }

        return otherLeft + otherWidth > left &&
                otherTop + otherHeight > top &&
                otherLeft < left + getWidth() &&
                otherTop < top + getHeight();
    }

    public boolean contains(Rectangle otherRectangle) {

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

        boolean isAdjacent = false;

        return isAdjacent;
    }

    @Override
    public String toString() {
        return "Top: " + top + " Left: " + left + " Height: " + height + " Width: " + width;
    }

}
