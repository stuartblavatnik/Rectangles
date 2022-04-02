package com.twoforboth;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple Rectangle.
 */
public class RectangleTest
{
    @Test
    public void isEmptyWithEmptyRectangleShouldReturnTrue() {
        Rectangle rectangle = new Rectangle(0.0, 0.0, 0.0, 0.0);

        assertTrue(rectangle.isEmpty());
    }

    @Test
    public void isEmptyWithNonEmptyRectangleShouldReturnFalse() {
        Rectangle rectangle = new Rectangle(1.0, 1.0, 10.0, 20.0);

        assertFalse(rectangle.isEmpty());
    }

}
