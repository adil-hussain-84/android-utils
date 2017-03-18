package com.thinkincode.utils.graphics;

import android.graphics.Color;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for the methods in the {@link ColorUtils} class.
 */
@RunWith(AndroidJUnit4.class)
public class ColorUtilsIntegrationTest {

    @Test
    public void test_rgbColorToHexString_black() {
        // When.
        String actual = ColorUtils.rgbColorToHexString(Color.BLACK);

        // Then.
        assertEquals("#000000", actual);
    }

    @Test
    public void test_rgbColorToHexString_white() {
        // When.
        String actual = ColorUtils.rgbColorToHexString(Color.WHITE);

        // Then.
        assertEquals("#FFFFFF", actual);
    }

    @Test
    public void test_rgbColorToHexString_blue() {
        // When.
        String actual = ColorUtils.rgbColorToHexString(Color.BLUE);

        // Then.
        assertEquals("#0000FF", actual);
    }

    @Test
    public void test_rgbColorToHexString_green() {
        // When.
        String actual = ColorUtils.rgbColorToHexString(Color.GREEN);

        // Then.
        assertEquals("#00FF00", actual);
    }

    @Test
    public void test_rgbColorToHexString_red() {
        // When.
        String actual = ColorUtils.rgbColorToHexString(Color.RED);

        // Then.
        assertEquals("#FF0000", actual);
    }
}
