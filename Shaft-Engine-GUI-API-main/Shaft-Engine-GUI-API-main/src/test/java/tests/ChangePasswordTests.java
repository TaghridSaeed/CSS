package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ChangePasswordPage_Customer;

public class ChangePasswordTests {
    private SHAFT.GUI.WebDriver driver;
    private ChangePasswordPage_Customer changePasswordPage;
    private final String websiteURL = "https://yourwebsite.com/Login"; // Replace with actual URL

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);

        // Perform login steps before accessing change password page
        // Add login logic here if needed

        changePasswordPage = new ChangePasswordPage_Customer(driver);
    }

    @Test(description = "Change Password Successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void testChangePassword() {
        changePasswordPage
                .enterCurrentPassword("OldPassword123")
                .enterNewPassword("NewPassword123")
                .confirmPassword("NewPassword123")
                .clickOnSaveChangesButton();

        // Verify redirection to login page after successful password change
        driver.assertThat().browser().url().isEqualTo("https://yourwebsite.com/login").perform();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();//dd
    }
}
