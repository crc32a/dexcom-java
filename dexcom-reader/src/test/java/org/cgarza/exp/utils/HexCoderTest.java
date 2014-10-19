package org.cgarza.exp.utils;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HexCoderTest {

    public HexCoderTest() {
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
    public void testToHex() {
        Assert.assertEquals("89AB", HexCoder.toHex((short) 0x89ab));
        Assert.assertEquals("0000", HexCoder.toHex((short) 0x0000));
        Assert.assertEquals("FFFF", HexCoder.toHex((short) 0xffff));
        Assert.assertEquals("AAAA", HexCoder.toHex((short) 0xaaaa));
        Assert.assertEquals("CBE0", HexCoder.toHex((short) 0xcbe0));
        Assert.assertEquals("7FFF", HexCoder.toHex((short) 0x7fff));
        Assert.assertEquals("ABBA", HexCoder.toHex((short) 0xabba));
        Assert.assertEquals("5555", HexCoder.toHex((short) 0x5555));
    }
}
