package registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConsumptionCalculationPage {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By currentConsumptionInput = By.id("CurrentConsumption");
    private By calculateButton = By.xpath("//button[contains(text(),'Calculation')]");

    // Constructor
    public ConsumptionCalculationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Current Consumption: {currentConsumption}")
    public ConsumptionCalculationPage enterCurrentConsumption(String currentConsumption) {
        driver.element().type(currentConsumptionInput, currentConsumption);
        return this;
    }

    @Step("Click on Calculate Button")
    public ConsumptionCalculationPage clickCalculateButton() {
        driver.element().click(calculateButton);
        return this;
    }
}
