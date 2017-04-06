package helpers;

import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import entities.Product;

public class HelperMethods {
    public static Product getProductByTitle(List<Product> products, String title) {
        Product product = null;
        for (Product p : products) {
            if (p.getTitle().equals(title)) {
                product = p;
                break;
            }
        }

        return product;
    }

    public static double getSubTotalPrice(List<Product> products) {
        double subTotal = 0;
        for (Product p : products) {
            subTotal += p.getQuantity() * p.getPrice();
        }

        return subTotal;
    }

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        String filePath = System.getProperty("user.dir") + "/" + fileName;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return properties;
    }

    public static void handleAlert(WebDriver driver, Boolean accept) {
        Alert alert = driver.switchTo().alert();
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void enterTextInJsPromtp(WebDriver driver, String textToSend) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(textToSend);
    }
}
