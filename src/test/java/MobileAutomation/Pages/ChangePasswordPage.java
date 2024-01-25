package MobileAutomation.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage  extends PageBase {
    public ChangePasswordPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/newPasswordEditText")
    WebElement newPassword;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/confirmNewPasswordEditText")
    WebElement confirmNewPassword;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/changePasswordBtn")
    WebElement changePasswordBtn;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/status_text")
    WebElement passwordChangeSuccess;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    WebElement ok;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Password']")
    WebElement newPasswordText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm New Password']")
    WebElement confirmPasswordText;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    WebElement toastMessage;






    //---Methods
    public void sendNewPassword(String recentPassword){enterText(newPassword, recentPassword);}
    public void sendConfirmNewPassword(String confirmPassword){enterText(confirmNewPassword, confirmPassword);}
    public void clickChangePasswordBtn(){click(changePasswordBtn);}
    public WebElement returnPasswordChangeSuccessEle(){ return  passwordChangeSuccess;}
    public void clickOk(){click(ok);}
    public WebElement returnNewPasswordEle(){return  newPasswordText;}
    public WebElement returnConfirmPasswordEle(){return confirmPasswordText;}

    public WebElement returnToastMessage(){return  toastMessage;}
    public void clearNewPassword(){newPassword.clear();}
    public void clearConfirmNewPassword(){confirmNewPassword.clear();}

}
