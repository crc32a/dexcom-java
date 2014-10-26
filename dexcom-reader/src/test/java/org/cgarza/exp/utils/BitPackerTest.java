package org.cgarza.exp.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.nio.ByteBuffer;

public class BitPackerTest {

    public BitPackerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testubyte2int() {
        assertEquals(0, BitPacker.ubyte2int((byte) 0x00));
        assertEquals(1, BitPacker.ubyte2int((byte) 0x01));
        assertEquals(2, BitPacker.ubyte2int((byte) 0x02));
        assertEquals(3, BitPacker.ubyte2int((byte) 0x03));
        assertEquals(128, BitPacker.ubyte2int((byte) 0x80));
        assertEquals(170, BitPacker.ubyte2int((byte) 0xAA));
    }

    @Test
    public void testSomething() {
        byte[] ba = new byte[]{(byte) 0x21, (byte) 0x43, (byte) 0x65,
            (byte) 0x87};
        assertEquals(-2023406815, BitPacker.intLE2int(ba, 0));
        ba = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff};
        assertEquals(-1, BitPacker.intLE2int(ba, 0));
        ba = new byte[]{(byte) 0xAA, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA};
        assertEquals(-1431655766, BitPacker.intLE2int(ba, 0));
    }
}
