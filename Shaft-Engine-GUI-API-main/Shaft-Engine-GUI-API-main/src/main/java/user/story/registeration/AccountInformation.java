package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformation {

    SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/signup";
    private By gender = By.id("id_gender2");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter = By.id("newsletter");
    private By SpecialOffer = By.id("optin");

    private By firstname = By.id("first_name");
    private By SecondName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobilenumber = By.id("mobile_number");
    private By CreateAccountButton = By.xpath("//button[@data-qa='create-account']");

    public AccountInformation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.browser().navigateToURL(url);
    }


    public AccountInformation accountInfo(String pass, String day, String month, String year) {
        driver.element().click(gender);
        driver.element().type(password, pass);
        driver.element().select(days, day);
        driver.element().select(months, month);
        driver.element().select(years, year);

        driver.element().click(newsletter);
        driver.element().click(SpecialOffer);
        return this;
    }


    public void addressInformation(String FirstName, String LastName, String Company, String Addressone, String Addresstwo, String Country, String State, String City, String Zipcode, String MobileNumber) {
        driver.element().type(firstname, FirstName);
        driver.element().type(SecondName, LastName);
        driver.element().type(company, Company);
        driver.element().type(address1, Addressone);
        driver.element().type(address2, Addresstwo);
        driver.element().select(country, Country);
        driver.element().type(state, State);
        driver.element().type(city, City);
        driver.element().type(zipcode, Zipcode);
        driver.element().type(mobilenumber, MobileNumber);

        driver.element().click(CreateAccountButton);

    }


}
