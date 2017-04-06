package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import edu.emory.mathcs.backport.java.util.Arrays;

@RunWith(Parameterized.class)
public class FirstTest extends TestFixture{
    private static double varA;
    private static double varB;

    public FirstTest(double varA, double varB) {
        this.varA = varA;
        this.varB = varB;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, 2},
                {3, 2},
                {1, 4}
        });
    }

    /*@BeforeClass
    public static void testSetup() {
        varA = 2;
        varB = 2;
    }*/

    @After
    public void tearDown() {
        //varA = 3;
    }

    @Test
    public void testA() {
        System.out.println("varA = " + varA + "; varB = " + varB);
        Assert.assertEquals(4, varA + varB, 1);
        Assert.assertEquals(varA + " + " + varB + " should equal 5 but is: " + (varA + varB), 5, varA + varB, 0);
    }

    @Test
    public void testB() {
        System.out.println("varA = " + varA + "; varB = " + varB);
        Assert.assertNotEquals(4, varA + varB, 0);
    }

    @Test
    public void testC() {
        System.out.println("varA = " + varA + "; varB = " + varB);
        Assert.assertTrue(varA + varB == 4);
        Assert.assertFalse(varA + varB < 4);

        //Assert.fail("Test failed!");
    }
}
