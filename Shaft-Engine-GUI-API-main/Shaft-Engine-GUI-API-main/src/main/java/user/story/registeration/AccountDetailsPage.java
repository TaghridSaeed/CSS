package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountDetailsPage {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By editAccountButton = By.id("CurrentConsumption");
    private By deleteAccountButton = By.id("CurrentConsumption");
    private By successDeleteToaster = By.id("CurrentConsumption");
    private By successEditToaster = By.id("CurrentConsumption");
    private By nicknameField = By.id("CurrentConsumption");

    // Constructor
    public AccountDetailsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Nickname: {nickname}")
    public AccountDetailsPage enterNickname(String nickname) {
        driver.element().type(nicknameField, nickname);
        return this;
    }

    @Step("Click on Edit Account Button")
    public AccountDetailsPage clickOnEditAccountButton() {
        driver.element().click(editAccountButton);
        return this;
    }

    @Step("Click on Delete Account Button")
    public AccountDetailsPage clickOnDeleteAccountButton() {
        driver.element().click(deleteAccountButton);
        return this;
    }

    @Step("Get Success Message After Deleting Account")
    public String getSuccessMessageWhenDelete() {
        return driver.element().getText(successDeleteToaster);
    }

    @Step("Get Success Message After Editing Account")
    public String getSuccessMessageWhenEdit() {
        return driver.element().getText(successEditToaster);
    }
}
