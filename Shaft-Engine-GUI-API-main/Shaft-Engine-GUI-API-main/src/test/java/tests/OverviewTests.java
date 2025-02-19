package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user.story.registeration.OverviewPage;

public class OverviewTests {
    private SHAFT.GUI.WebDriver driver;
    String webiteURl = "http://192.168.10.71:4200/overview";

    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(webiteURl);
    }

    @Test(description = "Successfully set a target")
    @Severity(SeverityLevel.CRITICAL)
    public void testSetTarget() {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.clickSetTargetButton();
        overviewPage.enterTargetValue("500");
        overviewPage.clickSubmitButton();
        overviewPage.verifyTargetIsSet("500");
    }

    @Test(description = "Successfully update target")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateTarget() {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.clickEditTargetButton();
        overviewPage.enterTargetValue("750");
        overviewPage.clickSubmitButton();
        overviewPage.verifyTargetIsUpdated("750");
    }

    @Test(description = "Successfully clear target")
    @Severity(SeverityLevel.CRITICAL)
    public void testClearTarget() {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.clickEditTargetButton();
        overviewPage.clickClearTargetButton();
        overviewPage.verifyTargetIsCleared();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
