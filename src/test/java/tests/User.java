package tests;

import com.github.javafaker.Faker;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String city;
    private String zipCode;
    private String phone;
    private String paragraph;

    public User() {
        Faker faker = new Faker();

        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = firstName + "." + lastName + "@test.test";
        this.streetAddress = faker.address().streetAddress();
        this.city = faker.address().city();
        this.zipCode = faker.address().zipCode();
        this.phone = faker.phoneNumber().cellPhone();

        this.paragraph = faker.lorem().paragraph();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getParagraph() {
        return paragraph;
    }
}
