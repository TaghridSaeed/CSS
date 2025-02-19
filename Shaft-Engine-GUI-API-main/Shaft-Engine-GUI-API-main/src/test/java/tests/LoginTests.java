package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user.story.registeration.LoginPage;
public class LoginTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private final String websiteURL = "http://192.168.10.71:4200/auth/login";

    @Test(description = "Login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCredentials() {
        new LoginPage(driver)
                .enterUserName(testData.getTestData("LoginTest.username"))
                .enterPassword(testData.getTestData("LoginTest.password"))
                .clickLogin();
    }

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginTestData.json");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
