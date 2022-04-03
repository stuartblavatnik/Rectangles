package com.twoforboth;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple Rectangle.
 */
public class RectangleTest
{
    @Test
    public void getRightShouldReturnSummationOfLeftAndWidth() throws Exception {
        Rectangle rectangle = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertEquals(21.0, rectangle.getRight(), Rectangle.EPSILON);
    }

    @Test
    public void getBottomShouldReturnSummationOfTopAndHeight() throws Exception {
        Rectangle rectangle = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertEquals(11.0, rectangle.getBottom(), Rectangle.EPSILON);
    }

    @Test
    public void intersectsReturnsTrueForIntersectingRectangles() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 8.0, 10.0, 20.0);

        assertTrue(rectangle1.intersects(rectangle2));
    }

    @Test
    public void intersectsReturnsTrueForIntersectingRectanglesConverseOrder() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 8.0, 10.0, 20.0);

        assertTrue(rectangle2.intersects(rectangle1));
    }

    @Test
    public void intersectsReturnsTrueForOneRectangle() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertTrue(rectangle1.intersects(rectangle1));
    }

    @Test
    public void intersectsReturnsFalseWhenRectanglesDoNotIntersect() throws Exception {
        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 21.0, 10.0, 20.0);

        assertFalse(rectangle1.intersects(rectangle2));
    }

    @Test
    public void intersectsReturnsFalseWhenRectanglesDoNotIntersectConverseOrder() throws Exception {
        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 21.0, 10.0, 20.0);

        assertFalse(rectangle2.intersects(rectangle1));
    }

    @Test
    public void intersectsReturnsFalseWhenOneRectangleIsNull() throws Exception {
        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = null;

        assertFalse(rectangle1.intersects(rectangle2));
    }


    @Test
    public void containsReturnsTrueForRectangleContainingOtherRectangle() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(2.0, 2.0, 5.0, 10.0);

        assertTrue(rectangle1.contains(rectangle2));
    }

    @Test
    public void containsReturnsFalseForRectangleNotContainingOtherRectangle() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(2.0, 2.0, 5.0, 10.0);

        assertFalse(rectangle2.contains(rectangle1));
    }

    @Test
    public void containsReturnsFalseForIntersectingRectangles() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 8.0, 10.0, 20.0);

        assertFalse(rectangle1.contains(rectangle2));
    }

    @Test
    public void containsReturnsFalseWhenOneRectangleIsNull() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = null;

        assertFalse(rectangle1.contains(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForSub_LineAdjacentOnRight() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(4.0, 21.0, 2.0, 4.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForSub_LineAdjacentOnLeft() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(4.0, 21.0, 2.0, 4.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForProperAdjacentOnRight() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(1.0, 21.0, 10.0, 4.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForProperAdjacentOnLeft() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(1.0, 21.0, 10.0, 4.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForPartialAdjacentOnRight() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 21.0, 10.0, 4.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForPartialAdjacentOnLeft() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 21.0, 10.0, 4.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForSub_LineAdjacentOnTop() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 10.0, 2.0, 4.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForSub_LineAdjacentOnBottom() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 10.0, 2.0, 4.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForProperAdjacentOnTop() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 1.0, 2.0, 20.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForProperAdjacentOnBottom() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 1.0, 2.0, 20.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsTrueForPartialAdjacentOnTop() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 10.0, 2.0, 34.0);

        assertTrue(rectangle2.isAdjacent(rectangle1));
    }

    @Test
    public void isAdjacentReturnsTrueForPartialAdjacentOnBottom() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(11.0, 10.0, 2.0, 34.0);

        assertTrue(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsFalseForNonAdjacentRectangles() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(8.0, 8.0, 10.0, 20.0);

        assertFalse(rectangle1.isAdjacent(rectangle2));
    }

    @Test
    public void isAdjacentReturnsFalseWhenOneRectangleIsNull() throws Exception {

        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertFalse(rectangle1.isAdjacent(null));
    }
}
