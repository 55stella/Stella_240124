package BaseClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;

public class PageBase {

    public static AppiumDriver driver;
    public static final Duration WAIT = ofMillis(60000);
    public WebDriverWait wait;
    public JavascriptExecutor jsExecutor;


    public PageBase(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
        wait = new WebDriverWait(driver, WAIT);
        jsExecutor = (JavascriptExecutor) driver;
    }


    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
