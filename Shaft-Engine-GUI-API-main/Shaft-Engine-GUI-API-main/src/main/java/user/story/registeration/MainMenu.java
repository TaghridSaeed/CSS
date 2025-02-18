package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainMenu {
    SHAFT.GUI.WebDriver driver;

    private By signUpAndsignInLink = By.xpath("//a[@href='/login']");
    private By DeleteAccountLink = By.xpath("//a[@href='/delete_account']");


    public MainMenu(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void signupLink() {
        driver.element().click(signUpAndsignInLink);

    }

    public void delete_account() {
        driver.element().click(DeleteAccountLink);

    }


}
