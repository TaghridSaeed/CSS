package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangePasswordPage_Customer {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By currentPasswordInputField = By.id("CurrentConsumption");
    private By newPasswordInputField = By.id("CurrentConsumption");
    private By confirmPasswordInputField = By.id("CurrentConsumption");
    private By saveChangesButton = By.id("CurrentConsumption");
    private By successToaster = By.id("CurrentConsumption");
    private By viewOnAnyAccount = By.id("CurrentConsumption");

    // Constructor
    public ChangePasswordPage_Customer(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Current Password: {currentPassword}")
    public ChangePasswordPage_Customer enterCurrentPassword(String currentPassword) {
        driver.element().type(currentPasswordInputField, currentPassword);
        return this;
    }

    @Step("Enter New Password: {newPassword}") //ddd
    public ChangePasswordPage_Customer enterNewPassword(String newPassword) {
        driver.element().type(newPasswordInputField, newPassword);
        return this;
    }

    @Step("Confirm New Password: {confirmPassword}")
    public ChangePasswordPage_Customer confirmPassword(String confirmPassword) {
        driver.element().type(confirmPasswordInputField, confirmPassword);
        return this;
    }

    @Step("Click on Save Changes Button")
    public ChangePasswordPage_Customer clickOnSaveChangesButton() {
        driver.element().click(saveChangesButton);
        return this;
    }

    @Step("Get Success Message after Password Change")
    public String getSuccessMessage() {
        return driver.element().getText(successToaster);
    }


}
