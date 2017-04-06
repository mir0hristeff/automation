package tests;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import helpers.HelperMethods;

public class ObjectMap {
    Properties properties;

    public ObjectMap() {
        properties = HelperMethods.loadProperties("objectmap.properties");
    }

    public By getLocator(String element) throws Exception {
        String locator = properties.getProperty(element);

        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];

        switch (locatorType.toLowerCase()) {
            case "id": return By.id(locatorValue);
            case "name": return By.name(locatorValue);
            case "xpath": return By.xpath(locatorValue);
            case "class": return By.className(locatorValue);
            case "cssselector": return By.cssSelector(locatorValue);
            case "linktext": return By.linkText(locatorValue);
            case "partiallinktext": return By.partialLinkText(locatorValue);
            case "tag": return By.tagName(locatorValue);
            default: throw new Exception(locatorType + " is not defined!");
        }
    }
}
