package MobileAutomation.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LandingPage extends PageBase {
    public LandingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/loginBtn")
    WebElement loginBtnEle;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/gettingStartedBtn")
    WebElement getStartedBtnEle;








    // Methods

    public void clickLoginBtn(){
        click(loginBtnEle);
    }
    public WebElement returnLoginTextInDashboard(){
        return   loginBtnEle;

    }
    public void clickGetStartedBtn(){
        click(getStartedBtnEle);
    }
}




