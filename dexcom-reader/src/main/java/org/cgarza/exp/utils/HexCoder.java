package org.cgarza.exp.utils;

public class HexCoder {

    private static final String[] hexMap = {"0", "1", "2", "3",
        "4", "5", "6", "7",
        "8", "9", "A", "B",
        "C", "D", "E", "F"
    };

    public static String toHex(short shortVal) {
        StringBuilder sb = new StringBuilder();
        sb.append(hexMap[(shortVal >> 12) & 0xf]);
        sb.append(hexMap[(shortVal >> 8) & 0xf]);
        sb.append(hexMap[(shortVal >> 4) & 0xf]);
        sb.append(hexMap[(shortVal >> 0) & 0xf]);
        return sb.toString();
    }
}
