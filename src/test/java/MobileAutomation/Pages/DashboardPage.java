package MobileAutomation.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DashboardPage  extends PageBase {
    public DashboardPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/textView2")
    WebElement welcomeText;
    @AndroidFindBy(id= "com.wemabank.alat.office.alat_qa_test:id/logOutBtn")
    WebElement logoutButton;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/changePassBtn")
    WebElement changePassword;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/updateInfoBtn")
    WebElement updateInfo;




    // ----Methods

    public WebElement returnWelcomeText(){
        return welcomeText;
    }

    public void clickLogOutButton(){
        click(logoutButton);
    }

    public void clickChangePassword(){
        click(changePassword);
    }
    public void clickUpdateInfo(){
        click(updateInfo);
    }
}
