package org.cgarza.exp.dexcom;

public class StaticUtils {

    public static String toHex(short shortVal) {
        return Integer.toHexString(shortVal & 0xffff);
    }
}
