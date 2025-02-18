package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class EnrollAccountTests {
    private SHAFT.GUI.WebDriver driver;
    private MyAccountPage myAccountPage;
    private final String websiteURL = "https://yourwebsite.com/Login"; // Replace with actual URL

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);

        // Perform login steps here //vv
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(description = "Enroll Account Successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void testEnrollAccount() {
        myAccountPage.clickONEnrollAccontButton();
        myAccountPage.chooseAreYouOwnerOrNot();
        myAccountPage.EnterElectronicCode("12345678910112");
        myAccountPage.EnterNickname("My Home Account");
        myAccountPage.clickOnAddAccountButton();

        // Validate success toaster message
        driver.assertThat()
                .element(myAccountPage.GetSuccessToasterContent())
                .text()
                .contains("Account enrolled successfully") // Replace with actual message
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
