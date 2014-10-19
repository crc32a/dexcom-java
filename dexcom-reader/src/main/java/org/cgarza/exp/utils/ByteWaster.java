package org.cgarza.exp.utils;

public class ByteWaster {

    private byte[] bytes;

    public ByteWaster(int nBytes) {
        int i;
        bytes = new byte[nBytes];
        for (i = 0; i < nBytes; i++) {
            bytes[i] = (byte)(i & 0xff);
        }
        Debug.nop(0);
    }

    public int size() {
        return bytes.length;
    }
}
