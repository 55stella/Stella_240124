package BaseClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import DeviceCapabilities.DeviceCaps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static AppiumDriver driver;
    public static DesiredCapabilities caps;
    public static String filePath_testDataProp = "src/test/java/TestData.properties";
    public static String filePath_deviceProp = "src/test/java/device.properties";
    public static FileInputStream fis;
    public static FileInputStream fis2;
    public static Properties testDataProp;
    public static Properties deviceProp;
    public static String device;



    public TestBase() {
        loadPropFile();
    }

    public static void loadPropFile() {
        testDataProp = new Properties();
        deviceProp = new Properties();
        try {
            fis = new FileInputStream(filePath_testDataProp);
            fis2 = new FileInputStream(filePath_deviceProp);
            testDataProp.load(fis);
            deviceProp.load(fis2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mainSetup() {
                try {
                    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), caps);
                    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
    }


    public void validateText(WebElement element, String message) {
        String actualMessage = "";
        try {
            actualMessage = element.getText();
            Assert.assertTrue(actualMessage.contains(message));
            System.out.println(actualMessage);
        } catch (AssertionError | NoSuchElementException e) {
            System.out.println("Expect " + actualMessage + " to contain " + message);
            throw new AssertionError(e);
        }
    }

    public void validateAttribute(WebElement element, String attribute, Boolean value) {
        try {
            Assert.assertTrue(Boolean.parseBoolean(element.getAttribute(attribute)) == value);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }


    @BeforeClass
    public void setup() {
        device = deviceProp.getProperty("device1");
        try {
            switch (device) {
                case "TecnoCamon19":
                    DeviceCaps.TecnoCamon19();
                    break;
                case "InfinixHot8":
                    DeviceCaps.InfinixHot8();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mainSetup();
        }
    }


    public void DynamicWait(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
