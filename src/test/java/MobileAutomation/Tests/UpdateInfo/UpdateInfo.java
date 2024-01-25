package MobileAutomation.Tests.UpdateInfo;

import BaseClasses.TestBase;
import MobileAutomation.Pages.DashboardPage;
import MobileAutomation.Pages.LandingPage;
import MobileAutomation.Pages.LoginPage;
import MobileAutomation.Pages.UpdateInfoPage;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class UpdateInfo  extends TestBase {
LandingPage landingPage;
LoginPage loginPage;
DashboardPage dashboardPage;
UpdateInfoPage updateInfoPage;
String testCategory ="Update Info";
    public void initializer(){
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        updateInfoPage = new UpdateInfoPage(driver);
    }

    @Test(priority = 1, description = "Confirm that the First Name and Last Name field is displayed.")
    public void TC22_ConfirmFirstNameAndLastName(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        initializer();
        landingPage.clickLoginBtn();
        loginPage.sendEmail(testDataProp.getProperty("username"));
        loginPage.sendPassword(testDataProp.getProperty("password"));
        loginPage.clickLoginBtn();
        dashboardPage.clickUpdateInfo();
        validateText(updateInfoPage.returnFirstNameText(), "First name");
        validateText(updateInfoPage.returnLastNameText(), "Last name");
    }

    @Test(priority = 2, description = "Validate that the User can Successfully Update their info.")
    public void TC23_ValidateUpdateSuccess(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        updateInfoPage.sendFirstName(testDataProp.getProperty("firstname"));
        updateInfoPage.sendLastName(testDataProp.getProperty("lastname"));
        updateInfoPage.clickUpdateInfoBtn();
        validateText(updateInfoPage.returnInfoUpdateSuccess(), "Information updated successfully.");
    }

    @Test(priority = 3, description = "Validate First Name in the Dashboard after a Successful Update")
    public void TC24_ValidateFirstNameInTheDashBoard(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        updateInfoPage.clickOkBtn();
        validateText(updateInfoPage.returnUpdatedFirstName(), testDataProp.getProperty("firstname"));


    }
    @Test(priority = 4, description = "Validate the First Name and Last Name field Shall not be less than 5 (five) Characters Each.")
    public void TC25_ValidateAllowedNameFieldCharacterLength(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        dashboardPage.clickUpdateInfo();
        updateInfoPage.sendFirstName(testDataProp.getProperty("incompleteFirstname"));
        updateInfoPage.sendLastName(testDataProp.getProperty("incompleteLastName"));
        updateInfoPage.clickUpdateInfoBtn();
        validateAttribute(updateInfoPage.returnInfoUpdateSuccess(), "displayed", false);

    }
    @Test(priority = 5, description = "Validate that the user Cannot Update Info  With  Empty  Values for the  Both  First Name and Last Name")
    public void TC26_ValidateUsersCannotUpdateInfoWithEmPtyValues(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        updateInfoPage.clickOkBtn();
        dashboardPage.clickUpdateInfo();
        updateInfoPage.clickUpdateInfoBtn();
        validateText(updateInfoPage.returnToastMessage(), "empty");
    }





}
