package tests;

import org.junit.Test;

public class TestsWithFaker {
    @Test
    public void testFaker() {
        User user = new User();

        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getStreetAddress());
        System.out.println(user.getCity());
        System.out.println(user.getZipCode());
        System.out.println(user.getPhone());
        System.out.println();
        System.out.println(user.getParagraph());
    }
}
