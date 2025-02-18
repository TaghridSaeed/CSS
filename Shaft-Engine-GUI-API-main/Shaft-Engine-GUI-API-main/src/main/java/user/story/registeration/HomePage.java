package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage {
    SHAFT.GUI.WebDriver driver;
    public String homeurl = "https://automationexercise.com/";

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public HomePage navigatetohome() {
        driver.browser().navigateToURL(homeurl);

        return this;
    }


}
