package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user.story.registeration.SignupandLoginPage;

public class RestfulBookerTests {
    String websiteURL ="http://192.168.10.71:4200/auth/register";
    SHAFT.TestData.JSON TestData;
    private SHAFT.GUI.WebDriver driver;

    @Test(description = "Register New User")
    @Severity(SeverityLevel.CRITICAL)
    public void RegisterUser(){
        new SignupandLoginPage(driver)
                .setNameAndEmailAddressInSignUpForm(TestData.getTestData("RegisterUserTest.userFirstName"),
                        TestData.getTestData("RegisterUserTest.secName"),
                        TestData.getTestData("RegisterUserTest.thirdName"),
                        TestData.getTestData("RegisterUserTest.famName"),
                        TestData.getTestData("RegisterUserTest.mobilenum"),
                        TestData.getTestData("RegisterUserTest.nationalId"),
                        TestData.getTestData("RegisterUserTest.email"),
                        TestData.getTestData("RegisterUserTest.password"),
                        TestData.getTestData("RegisterUserTest.confirmPassword"))
                .clickOnSignUpButton();

    }

    @BeforeMethod
    public void SetUP(){
        driver=new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);
        TestData= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/RestfulBookerCreateBookingBody.json");
    }
    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
