package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import edu.emory.mathcs.backport.java.util.Arrays;

@RunWith(Parameterized.class)
public class Three {
    @Parameterized.Parameter(value = 0)
    public int varA;
    @Parameterized.Parameter(value = 1)
    public int varB;
    @Parameterized.Parameter(value = 2)
    public int varC;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, 2, 2},
                {3, 2, 1},
                {1, 4, 2}
        });
    }

    @Test
    public void test1() {
        Assert.assertTrue(true);
        System.out.println("test1 : tests.Three");
        System.out.println("varA = " + varA + "; varB = " + varB + "; varC = " + varC);
    }

    @Test
    public void test2() {
        Assert.assertFalse(false);
        System.out.println("test2 : tests.Three");
        System.out.println("varA = " + varA + "; varB = " + varB + "; varC = " + varC);
    }
}
