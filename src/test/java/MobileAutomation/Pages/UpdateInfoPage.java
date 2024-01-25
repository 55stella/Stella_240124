package MobileAutomation.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class UpdateInfoPage  extends PageBase {
    public UpdateInfoPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/firstNameEditText")
    WebElement firstNameInput;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/lastNameEditText")
    WebElement lastNameInput;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/updateBtn")
    WebElement updateInfoBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='First name']")
    WebElement firstNameText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Last name']")
    WebElement lastNameText;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/status_text")
    WebElement infoUpdateSuccess;

    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    WebElement okBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    WebElement toastMessage;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/textView2")
    WebElement updatedFirstName;


     //#---Methods-------

    public void sendFirstName(String firstname){enterText(firstNameInput, firstname);}
    public void sendLastName(String lastname){enterText(lastNameInput, lastname);}
    public void clickUpdateInfoBtn(){click(updateInfoBtn);}
    public WebElement returnFirstNameText(){return firstNameText;}
    public WebElement returnLastNameText(){return lastNameText;}
    public WebElement returnInfoUpdateSuccess(){return infoUpdateSuccess;}
    public void clickOkBtn(){click(okBtn);}
    public WebElement returnToastMessage(){return  toastMessage;}
    public WebElement returnUpdatedFirstName(){return  updatedFirstName;}

}
