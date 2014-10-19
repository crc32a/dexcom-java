package org.cgarza.exp.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Crc16Test {

    private static final int ONE_MEG = 1024 * 1024;

    public Crc16Test() {
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
    public void testCrc16() {
        byte[] bytes = new byte[ONE_MEG];
        int i;
        for (i = 0; i < ONE_MEG; i++) {
            bytes[i] = (byte) (i & 0xff);
        }
        int crc = Crc16.crc16(bytes);
        assertEquals(36841, crc);
    }
}
