package com.in28minutes.junit;

import org.junit.*;

import static org.junit.Assert.*;

public class MyMathTest {

   static MyMath myMath;

    @Before
    public void before() {

        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @BeforeClass
    public static void beforeClass() {
        myMath = new MyMath();
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Test
    public void sum_with3numbers() {
        System.out.println("sum_with3numbers");
        assertEquals(6, myMath.sum(new int[]{1, 2, 3}));
    }

    @Test
    public void sum_with1number() {
        System.out.println("sum_with1number");
        assertEquals(3, myMath.sum(new int[]{3}));
    }
}
