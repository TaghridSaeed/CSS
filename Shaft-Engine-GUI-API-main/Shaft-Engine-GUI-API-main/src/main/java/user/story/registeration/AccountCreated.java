package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreated {

    SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/";
    private By AccountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreated(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {

        driver.browser().navigateToURL(url);
    }


    public AccountCreated assertionOnCreateAccount(String ExcpectedText) {
        driver.assertThat().element(AccountCreatedText).text().isEqualTo(ExcpectedText);
        return this;
    }

    public void continueButton() {
        driver.element().click(ContinueButton);
    }


}
