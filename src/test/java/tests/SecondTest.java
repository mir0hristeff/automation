package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SecondTest extends TestFixture {
    @BeforeClass
    public static void classSetup() {
        System.out.println("Before each test class");
    }

    @Before
    public void setup() {

        System.out.println("Before each test method");
    }

    @After
    public void tearDown() {

        System.out.println("After each test method");
    }

    @AfterClass
    public static void classTearDown() {

        System.out.println("After each test class");
    }

    @Test(timeout = 1)
    public void testOne() {

        System.out.println("Test One");
    }

    @Ignore
    @Test
    public void testTwo() {

        System.out.println("Test Two");
    }

    @Test
    public void testThree() {
        System.out.println("Test tests.Three");
    }
}
