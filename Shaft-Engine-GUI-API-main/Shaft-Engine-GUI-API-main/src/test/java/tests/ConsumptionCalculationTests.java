package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ConsumptionCalculationPage;

public class ConsumptionCalculationTests {
    private SHAFT.TestData.JSON testData;
    private SHAFT.GUI.WebDriver driver;

    @Test(description = "Calculate Consumption for Residential Category")
    @Severity(SeverityLevel.CRITICAL)
    public void calculateConsumption() {
        new ConsumptionCalculationPage(driver)
                .enterCurrentConsumption(testData.getTestData("ConsumptionTest.currentConsumption"))
                .clickCalculateButton();

        // Validate URL redirection
        String expectedURL = testData.getTestData("ConsumptionTest.expectedURL");
        driver.verifyThat().browser().url().isEqualTo(expectedURL).perform();
    }

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(websiteURL);
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/ConsumptionTestData.json");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
