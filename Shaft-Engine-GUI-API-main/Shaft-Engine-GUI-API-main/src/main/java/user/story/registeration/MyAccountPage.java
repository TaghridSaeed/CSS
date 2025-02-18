package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyAccountPage {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By enrollAccountButton = By.id("CurrentConsumption");
    private By areYouAccountOwnerRadioButton = By.id("CurrentConsumption");
    private By electronicCodeField = By.id("CurrentConsumption");
    private By nicknameField = By.id("CurrentConsumption");
    private By addNewAccountButton = By.id("CurrentConsumption");
    private By viewOnAnyAccount = By.id("CurrentConsumption");
    private By successEnrollmentToaster = By.id("CurrentConsumption");

    // Constructor
    public MyAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Enroll Account Button")
    public MyAccountPage clickOnEnrollAccountButton() {
        driver.element().click(enrollAccountButton);
        return this;
    }

    @Step("Select 'Are You Account Owner' Option")
    public MyAccountPage chooseAreYouOwnerOrNot() {
        driver.element().click(areYouAccountOwnerRadioButton);
        return this;
    }

    @Step("Enter Electronic Code: {electronicCode}")
    public MyAccountPage enterElectronicCode(String electronicCode) {
        driver.element().type(electronicCodeField, electronicCode);
        return this;
    }

    @Step("Enter Nickname: {nickname}")
    public MyAccountPage enterNickname(String nickname) {
        driver.element().type(nicknameField, nickname);
        return this;
    }

    @Step("Click on Add New Account Button")
    public MyAccountPage clickOnAddAccountButton() {
        driver.element().click(addNewAccountButton);
        return this;
    }

    @Step("Click on View Any Account")
    public MyAccountPage clickOnViewOnAnyAccount() {
        driver.element().click(viewOnAnyAccount);
        return this;
    }

    @Step("Get Success Message after Enrollment")
    public String getSuccessToasterContent() {
        return driver.element().getText(successEnrollmentToaster);
    }
}
