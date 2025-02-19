package user.story.registeration;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id='css-app']/css-auth-layout/div/div[1]/div/css-login/form/gs-button");

    // Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public LoginPage enterUserName(String username) {
        driver.element().type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.element().type(passwordInput, password);
        return this;
    }

    public void clickLogin() {
        driver.element().click(loginButton);
    }

    // Combined method for logging in
    public void login(String username, String password) {
        enterUserName(username).enterPassword(password).clickLogin();
    }
}
