//package test.cases;
//
//import com.shaft.driver.SHAFT;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import org.testng.annotations.Test;
//import user.story.registeration.*;
//
//
//public class GuiTests {
//
//    SHAFT.GUI.WebDriver driver;
////SHAFT.TestData.JSON json;
//    @BeforeClass
//    public void setup() {
//        driver = new SHAFT.GUI.WebDriver();
//    }
//
//    @Test
//    public void TC1Register_User() {
//        new HomePage(driver)
//                .navigatetohome();
//        new MainMenu(driver).signupLink();
//        new NewUserSignup(driver)
//         .signup("martina", "martiiii@gmail.com");
//  //              .signup(json.getTestData("username"),json.getTestData("email"));
//        // Enter Account Information
//        new AccountInformation(driver)
//                .accountInfo("1234567890", "28", "11", "2001")
//                //  Address Information
//                .addressInformation("Martina", "Ibrahim", "Giza Systems", "Hadyek el zayton", "cairo", "Canada", "N/A", "cairo", "11725", "068689990");
//        new AccountCreated(driver)
//                .assertionOnCreateAccount("ACCOUNT CREATED!")
//                .continueButton();
//
//        new MainMenu(driver).delete_account();
//        new AccountDeleted(driver)
//                .assertionOnDEleteAccount("ACCOUNT DELETED!")
//                .continueButton();
//    }
//
//    @AfterClass
//    public void close_browser() {
//        driver.quit();
//    }
//
//}
