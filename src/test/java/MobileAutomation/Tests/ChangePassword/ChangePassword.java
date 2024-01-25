package MobileAutomation.Tests.ChangePassword;

import BaseClasses.TestBase;
import MobileAutomation.Pages.ChangePasswordPage;
import MobileAutomation.Pages.DashboardPage;
import MobileAutomation.Pages.LandingPage;
import MobileAutomation.Pages.LoginPage;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static java.lang.Thread.sleep;
import static utils.extentReports.ExtentTestManager.startTest;

public class ChangePassword  extends TestBase {
LandingPage landingPage;
LoginPage loginPage;
DashboardPage dashboardPage;
ChangePasswordPage changePasswordPage;

String testCategory ="Change Password";
    public void initializer(){
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);

    }

    public void loginToDashboard(String Email, String Password){
        landingPage.clickLoginBtn();
        loginPage.sendEmail(Email);
        loginPage.sendPassword(Password);
        loginPage.clickLoginBtn();
    }

    @Test(priority = 1, description = "Validate that the User can Successfully Change  their Password.")
    public void TC16_ValidateUserCanSuccessfullyChangePassword(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        initializer();
        loginToDashboard(testDataProp.getProperty("user2"), testDataProp.getProperty("password"));
        dashboardPage.clickChangePassword();
        changePasswordPage.sendNewPassword(testDataProp.getProperty("newPassword"));
        changePasswordPage.sendConfirmNewPassword(testDataProp.getProperty("confirmPassword"));
        changePasswordPage.clickChangePasswordBtn();
        validateText(changePasswordPage.returnPasswordChangeSuccessEle(), "Password changed successfully.");
    }

    @Test(priority = 2, description = "Confirm that the \"Change Password\" page includes fields for the current password, new password, and confirm new password.")
    public void TC17_ValidateThatAllRequiredFieldsArePresent(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        changePasswordPage.clickOk();
        dashboardPage.clickChangePassword();
        validateText(changePasswordPage.returnNewPasswordEle(),"New Password" );
        validateText(changePasswordPage.returnConfirmPasswordEle(), "Confirm New Password");
        validateText(changePasswordPage.returnNewPasswordEle(), "Current Password");

    }
    @Test(priority = 3, description = "Validate that the User cannot Proceed to  Change Password With empty values for the New Password and Confirm new password Fields.")
    public void TC18_ValidateThatUserCannotChangePasswordWithEmptyValues(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        changePasswordPage.clickChangePasswordBtn();
        validateText(changePasswordPage.returnToastMessage(), "New Password is empty");

    }
    @Test(priority = 4, description = "Validate that the User Cannot proceed with Password Change Using a Mismatched New Password and Confirm Password.")
    public void TC19_ValidateUsersCannotProceedWithMisMatchedValues(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        changePasswordPage.sendNewPassword(testDataProp.getProperty("misMatchedNewPassword"));
        changePasswordPage.sendConfirmNewPassword(testDataProp.getProperty("misMatchedConfirmPassword"));
        changePasswordPage.clickChangePasswordBtn();
        validateText(changePasswordPage.returnToastMessage(), "The passwords are not the same");
        sleep(40);
    }
    @Test(priority = 5, description = "Validate that the User cannot Change Password With an InCorrect Password Criteria.")
    public void TC21_ValidateUsersCannotToChangePasswordWithInvalidPasswordCriteria(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        changePasswordPage.clearNewPassword();
        changePasswordPage.clearConfirmNewPassword();
        changePasswordPage.sendNewPassword(testDataProp.getProperty("invalidPassWordCriteriaNewPassword"));
        changePasswordPage.sendConfirmNewPassword(testDataProp.getProperty("invalidPassWordCriteriaConfirmPassword"));
        changePasswordPage.clickChangePasswordBtn();
        validateText(changePasswordPage.returnPasswordChangeSuccessEle(), "Password is too short");
    }

    @Test(priority = 6, description = "Verify  that the User can Login  with New Password")
    public void TC20_ValidateUsersCanLoginWithChangedPassword(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        dashboardPage.clickLogOutButton();
        loginToDashboard(testDataProp.getProperty("newPassword"), testDataProp.getProperty("confirmPassword"));
        validateText(dashboardPage.returnWelcomeText(), "Hi");

    }


}
