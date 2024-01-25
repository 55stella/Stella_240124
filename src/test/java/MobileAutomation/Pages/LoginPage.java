package MobileAutomation.Pages;

import BaseClasses.PageBase;
import BaseClasses.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage  extends PageBase {
    TestBase testBase;
    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/email_input")
    WebElement emailInputField;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/password_input")
    WebElement passwordInputField;
    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_text")
    WebElement loginErrorMessage;
    @AndroidFindBy(id= "com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    WebElement doneBtn;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/loginBtn")
    WebElement loginBtn;

    @AndroidFindBy(xpath = "//*[contains(@text, 'empty')]")
    WebElement usernameOrPasswordEmptyErrors;
    @AndroidFindBy(id="com.wemabank.alat.office.alat_qa_test:id/textinput_error")
    WebElement invalidEmailError;
    @AndroidFindBy(id ="com.wemabank.alat.office.alat_qa_test:id/title")
    public WebElement invalidEmailOrPassword;



    // Methods

    public void sendEmail( String email){
        enterText(emailInputField, email );

    }
    public void sendPassword(String password){
        enterText(passwordInputField, password );
    }

    public WebElement returnLoginErrorMessage(){
        return  loginErrorMessage;
    }

    public  void clearEmailInput(){
         emailInputField.clear();
    }
    public  void clearPasswordInput(){
        passwordInputField.clear();
    }
    public  void clickDoneBtn(){
        click(doneBtn);
    }
    public void clickLoginBtn(){
        click(loginBtn);
    }

    public WebElement returnUsernameOrPasswordEmptyErrorsEle(){
        return  usernameOrPasswordEmptyErrors;
    }

    public WebElement returnInvalidEmailError(){
        return  invalidEmailError;
    }

    public WebElement returnLoginButtonEle(){
        return  loginBtn;
    }
}
