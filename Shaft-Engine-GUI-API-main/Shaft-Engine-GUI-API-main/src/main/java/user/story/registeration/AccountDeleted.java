package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeleted {
    SHAFT.GUI.WebDriver driver;
   // private String url = "https://automationexercise.com/delete_account";
    private By AccountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountDeleted(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public AccountDeleted assertionOnDEleteAccount(String expected) {
        driver.assertThat().element(AccountDeletedText).text().isEqualTo(expected);
        return this;
    }


    public void continueButton() {
        driver.element().click(ContinueButton);
    }

}
