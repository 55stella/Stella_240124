package MobileAutomation.Tests.Login;

import BaseClasses.TestBase;
import MobileAutomation.Pages.DashboardPage;
import MobileAutomation.Pages.LandingPage;
import MobileAutomation.Pages.LoginPage;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static java.lang.Thread.sleep;
import static utils.extentReports.ExtentTestManager.startTest;

public class Login  extends TestBase {
    LandingPage landingPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;


    String testCategory ="Login";

   public void initializer(){
       landingPage = new LandingPage(driver);
       loginPage = new LoginPage(driver);
       dashboardPage = new DashboardPage(driver);
   }


    @Test(priority = 1, description = "Validate that the App lunches Within a Reasonable Period of time.")
    public void TC2_ValidateAppLunchesWithinAReasonableTime(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        initializer();
        sleep(10);
        validateText(landingPage.returnLoginTextInDashboard(), "Log In");
    }
    @Test(priority = 2, description = "Validate that the User can Launch the Qa App.")
    public void TC1_ValidateUserCanLaunchQaApp(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        validateText(landingPage.returnLoginTextInDashboard(), "Log In");
    }
    @Test(priority = 3, description = "Validate that the Log in Button is Displayed  Once App is Launched .")
    public void TC5_ValidateLoginBtnIsDisplayed(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        validateText(landingPage.returnLoginTextInDashboard(), "Log In");
    }

    @Test(priority = 4, description = "Validate that the Login Button is clickable")
    public void TC6_ValidateLoginButtonIsClickable(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        validateAttribute(landingPage.returnLoginTextInDashboard() ,"clickable", true);
        landingPage.clickLoginBtn();
    }

    @Test(priority = 5, description = "Confirm that the Password length cannot be Less than Five (5)Characters.")
    public void TC7_ConfirmPasswordLengthCannotBeLessThanFiveCharacters(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.sendEmail(testDataProp.getProperty("username"));
        loginPage.sendPassword(testDataProp.getProperty("invalidPasswordLength"));
        loginPage.clickLoginBtn();
        validateText(loginPage.returnLoginErrorMessage(), "Password is incorrect.");
        loginPage.clickDoneBtn();
    }
    @Test(priority = 6, description = "Validate that the Username Follows email format Only.")
    public void TC8_ValidateUserNameFollowsEmailFormatOnly(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clearEmailInput();
        loginPage.clearPasswordInput();
        loginPage.sendEmail(testDataProp.getProperty("username"));
        loginPage.sendPassword(testDataProp.getProperty("password"));
        loginPage.clickLoginBtn();
        validateText(dashboardPage.returnWelcomeText(), "Hi");
        dashboardPage.clickLogOutButton();

    }

    @Test(priority = 7, description = "Validate that the username Only follows allowed Character Restrictions.")
    public void TC10_ValidateUserNameFollowsAllowedCharacterRestriction(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clickLoginBtn();
        loginPage.sendEmail(testDataProp.getProperty("username"));
        loginPage.sendPassword(testDataProp.getProperty("password"));
        loginPage.clickLoginBtn();
        validateText(dashboardPage.returnWelcomeText(), "Hi");
        dashboardPage.clickLogOutButton();
    }

    @Test(priority = 8, description = "Validate that User Cannot Log In with Email address that does not follow Email format")
    public void TC9_ValidateUserCannotLoginWithEmailAddressThatDoesNotFollowEmailFormat(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        landingPage.clickLoginBtn();
        loginPage.sendEmail(testDataProp.getProperty("invalidEmail"));
        loginPage.sendPassword(testDataProp.getProperty("password"));
        sleep(4);
        loginPage.clickLoginBtn();
        validateText(loginPage.returnInvalidEmailError(), "'Email' is not a valid email address.");

    }
//
    @Test(priority = 9, description = "Validate that the User cannot Proceed to Log in with empty Values for Username and Password.")
    public void TC13_ConfirmUserCannotProceedToLoginWithEmptyValues(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clearEmailInput();
        loginPage.clearPasswordInput();
        loginPage.clickLoginBtn();
        validateText(loginPage.returnUsernameOrPasswordEmptyErrorsEle(), "must not be empty");

    }
    @Test(priority = 10, description = "Validate that the User cannot Log in with an Invalid Username and Password.")
    public void TC15_ValidateUserCannotLoginWithInvalidUsernameAndPassword(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clearEmailInput();
        loginPage.clearPasswordInput();
        loginPage.sendEmail(testDataProp.getProperty("invalidEmail2"));
        loginPage.sendPassword(testDataProp.getProperty("invalidPassword"));
        loginPage.clickLoginBtn();
        validateText(loginPage.invalidEmailOrPassword, "Error");


    }
    @Test(priority = 11, description = "Confirm that the log in button is disabled until both the username and password fields are filled.")
    public void TC11_ValidateLoginButtonIsDisabledUntilUsernameAndPasswordIsEntered(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clickDoneBtn();
        loginPage.clearEmailInput();
        loginPage.clearPasswordInput();
        loginPage.sendEmail(testDataProp.getProperty("username"));
        validateAttribute(loginPage.returnLoginButtonEle(), "clickable", false);
    }
    @Test(priority = 12, description = "Validate that User can Login with a Valid Username and Password.")
    public void TC12_ValidateUsersCanLoginWithValidUsernameAndPassword(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        loginPage.clearEmailInput();
        loginPage.sendEmail(testDataProp.getProperty("username"));
        loginPage.sendPassword(testDataProp.getProperty("password"));
        loginPage.clickLoginBtn();
        validateText(dashboardPage.returnWelcomeText(), "Hi");

    }






}
