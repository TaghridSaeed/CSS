package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.MyAccountPage;

public class DeleteAccountTests {
    private SHAFT.GUI.WebDriver driver;
    private MyAccountPage myAccountPage;
    private AccountDetailsPage accountDetailsPage;
    private final String websiteURL = "https://yourwebsite.com/Login"; // Replace with actual URL

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);

        // Perform login steps here
        // Navigate to My Accounts Page
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.ClickOnViewOnAnyAccount();

        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @Test(description = "Delete Account Successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteAccount() {
        accountDetailsPage.clickOnDeleteAccountButton();

        // Validate success toaster message
        driver.assertThat()
                .element(accountDetailsPage.GetSuccessMessageWhenDelete())
                .text()
                .isEqualTo("Account deleted successfully") // Replace with actual message
                .perform();
    }

    @AfterMethod
    public void tearDown() { //dd
        driver.quit();
    }
}
