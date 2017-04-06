package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestFixture {
    @BeforeClass
    public static void globalSetup() {
        System.out.println("Fixture: Before each class");
    }

    @AfterClass
    public static void globalTearDown() {
        System.out.println("Fixture: After each class");
    }

    @Before
    public void setup() {
        System.out.println("Fixture: Before each method");
    }

    @After
    public void tearDown() {
        System.out.println("Fixture: After each method");
    }
}
