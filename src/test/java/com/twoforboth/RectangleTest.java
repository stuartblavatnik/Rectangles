package com.twoforboth;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple Rectangle.
 */
public class RectangleTest
{
    @Test
    public void isEmptyWithEmptyRectangleShouldReturnTrue() throws Exception {

        Rectangle rectangle = new Rectangle(0.0, 0.0, 0.0, 0.0);

        assertTrue(rectangle.isEmpty());
    }

    @Test
    public void isEmptyWithNonEmptyRectangleShouldReturnFalse() throws Exception {
        Rectangle rectangle = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertFalse(rectangle.isEmpty());
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
    public void intersectsReturnsFalseWhenOneRectangleIsEmpty() throws Exception {
        Rectangle rectangle1 = new Rectangle(1.0, 1.0, 10.0, 20.0);
        Rectangle rectangle2 = new Rectangle(0.0, 0.0, 0.0, 0.0);

        assertFalse(rectangle1.intersects(rectangle2));
    }


}
