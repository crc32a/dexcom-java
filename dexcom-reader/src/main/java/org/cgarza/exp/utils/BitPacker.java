package org.cgarza.exp.utils;

import java.nio.ByteBuffer;

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

    public static long uintLE2long(byte[] data, int idx) {
        return ubyte2int(data[idx]) + ubyte2int(data[idx + 1]) << 8
                + ubyte2int(data[idx + 2]) << 16 + ubyte2int(data[idx + 3]) << 24;
    }

    public static int intLE2int(byte[] data, int idx) {
        return ubyte2int(data[idx + 3]) << 24 | ubyte2int(data[idx + 2]) << 16
                | ubyte2int(data[idx + 1]) << 8 | ubyte2int(data[idx]);
    }
}
