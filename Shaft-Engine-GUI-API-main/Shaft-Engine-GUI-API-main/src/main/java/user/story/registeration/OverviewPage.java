package user.story.registeration;
import user.story.registeration.OverviewPage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class OverviewPage {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By setTargetButton = By.xpath("//css-my-target/css-set-target/div/span[3]");
    private By targetInputField = By.xpath("//*[@id='consumptionTarget']/span/input");
    private By submitButton = By.xpath("//*[@id='set-target-form']/div/div/div[2]/div[1]/button[2]");
    private By editTargetButton = By.xpath("//*[@id='css-app']/css-portal-layout/div/div/css-dashboard/div[2]/css-my-target/div/div/div/span[2]/span");
    private By clearTargetButton = By.xpath("//*[@id='set-target-form']/div/div/form/div[2]/span");
    private By targetValueDisplay = By.xpath("//css-my-target/div/span"); // Adjust if needed

    // Constructor
    public OverviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickSetTargetButton() {
        driver.element().click(setTargetButton);
    }

    public void enterTargetValue(String targetValue) {
        driver.element().type(targetInputField, targetValue);
    }

    public void clickSubmitButton() {
        driver.element().click(submitButton);
    }

    public void clickEditTargetButton() {
        driver.element().click(editTargetButton);
    }

    public void clickClearTargetButton() {
        driver.element().click(clearTargetButton);
    }

    // Validations
    public void verifyTargetIsSet(String expectedValue) {
        driver.assertThat().element(targetValueDisplay).text().isEqualTo(expectedValue).perform();
    }

    public void verifyTargetIsUpdated(String expectedValue) {
        driver.assertThat().element(targetValueDisplay).text().isEqualTo(expectedValue).perform();
    }

    public void verifyTargetIsCleared() {
        driver.assertThat().element(targetValueDisplay).text().isEqualTo("").perform();
    }
}
