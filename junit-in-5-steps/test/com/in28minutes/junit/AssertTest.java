package com.in28minutes.junit;

import org.junit.Test;

import static org.junit.Assert.*;


public class AssertTest {

    @Test
    public void test() {
        assertEquals(true, true);
        assertTrue(1==1);
        assertFalse(1==2);
        assertNotNull(new Object());
        assertNull(null);
        assertArrayEquals(new int[]{1}, new int[]{1});
    }
}
