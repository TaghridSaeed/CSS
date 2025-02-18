package user.story.registeration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupandLoginPage {
    private By firstNameInput = By.id("fname");
    private By secondNameInput = By.id("sname");
    private By thirdNameInput = By.id("tname");
    private By familyNameInput = By.id("family-name");
    private By mobileNumberInput = By.id("mobile-number");
    private By nationalityDropdown = By.xpath("//*[@id='gs_id_3_label']");
    private By nationalIdInput = By.xpath("//input[@placeholder='Enter national ID']");
    private By emailInput = By.xpath("//input[@placeholder='Enter email']");
    private By passwordInput = By.xpath("//*[@id='password']");
    private By confirmPasswordInput = By.xpath("//*[@id='ConfirmPassword']");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create new account')]");
    private SHAFT.GUI.WebDriver driver;
    private By mobilenum = By.xpath("//*[@id='mobile-number']/span/input");

    public SignupandLoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    @Step("Set Name And Email Address In Sign Up Form")
    public SignupandLoginPage setNameAndEmailAddressInSignUpForm(String firstName,
                                                                 String secName,String thirdName,
                                                                 String famName,String mobilenumber,String nationalId,String email,String password,String confirmPassword){
        driver.element().type(firstNameInput,firstName);
        driver.element().type(secondNameInput,secName);
        driver.element().type(thirdNameInput,thirdName);
        driver.element().type(familyNameInput,famName);
        driver.element().type(mobilenum,mobilenumber);
//        driver.element().type(nationalityDropdown,nationalityDrop);
        driver.element().type(nationalIdInput,nationalId);
        driver.element().type(emailInput,email);
        driver.element().type(passwordInput,password);
        driver.element().type(confirmPasswordInput,confirmPassword);
        return this;
    }

    @Step("Click On Sign Up Button")
    public SignupandLoginPage clickOnSignUpButton(){
        driver.element().click(createAccountButton);
        return this;
    }





}
