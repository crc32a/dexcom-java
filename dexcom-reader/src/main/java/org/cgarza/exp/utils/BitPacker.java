package org.cgarza.exp.utils;

public class BitPacker {

    public static int ubyte2int(byte in) {
        return (in >= 0) ? (int) in : (int) in + 256;
    }

    public static byte int2ubyte(int in) {
        in &= 0xff;
        return (in < 128) ? (byte) in : (byte) (in - 256);
    }

    public static int ushortLE2Int(byte[] data, int idx) {
        return ubyte2int(data[idx]) + ubyte2int(data[idx + 1]) << 8;
    }
}
