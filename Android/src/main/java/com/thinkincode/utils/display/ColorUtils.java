package com.thinkincode.utils.display;

/**
 * Provides helper methods for converting between different colour representations.
 */
public class ColorUtils {

    /**
     * Converts an RGB int color to its Hex String representation.
     *
     * @param rgbColor the RGB int color to convert.
     * @return the Hex String representation of the provided RGB int color.
     */
    public String rgbColorToHexString(int rgbColor) {
        return String.format("#%06X", (0xFFFFFF & rgbColor));
    }
}