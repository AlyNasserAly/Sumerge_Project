package TestCases;

import Elements.LoginElements;
import Methods.Base_Page;
import Methods.Login_Methods;
import TestData.LoginTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Test extends Base_Page {
//    private WebDriver driver;

    private EdgeDriver driver;
    private Login_Methods Login;
    private LoginTestData testData;
    private Base_Page BasePage;


    @BeforeMethod
    public void setup() throws InterruptedException {
        Login = new Login_Methods();
        BasePage = new Base_Page();
        driver = new EdgeDriver();
        testData = new LoginTestData();
        System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
        driver.navigate().to("https://www.saucedemo.com/");
//        driver.findElement(LoginElements.UserName).sendKeys(testData.Valid_UserName);
//        driver.findElement(LoginElements.Password).sendKeys(testData.Valid_Password);
//        driver.findElement(LoginElements.Login_Btn).click();

        Thread.sleep(2000);
    }

    @Test
    public void CheckLoginFields() {
        String UsernameField = Login.checkUserName(driver);
        String PasswordField = Login.checkPassword(driver);
        String LoginButton = Login.checkLoginBtn(driver);

        Assert.assertEquals(UsernameField, "user-name", "Username Id not matched");
        Assert.assertEquals(PasswordField, "password", "Password Id not matched");
        Assert.assertEquals(LoginButton, "login-button", "Login Button Id not matched");


    }


    @Test
    public void LoginWithValidCredentials() {

        Login.enterUserName(testData.Valid_UserName, driver);
        Login.enterPassword(testData.Valid_Password, driver);
        Login.clickLoginBtn(driver);
    }


    @Test
    public void LoginWithInValidCredentials() {

        Login.enterUserName(testData.Invalid_UserName, driver);
        Login.enterPassword(testData.Invalid_Password, driver);
        Login.clickLoginBtn(driver);
        String ErrorMsg = Login.getErrorMsg(driver);
        Assert.assertEquals(ErrorMsg,testData.ErrorMsg,"Error message is not matched");

    }

    @Test
    public void LoginWithEmptyUserName() {

        Login.enterUserName("", driver);
        Login.enterPassword(testData.Valid_Password, driver);
        Login.clickLoginBtn(driver);
        String ErrorMsg = Login.getErrorMsg(driver);
        Assert.assertEquals(ErrorMsg,testData.UserNameErrorMsg,"Error message is not matched");

    }

    @Test
    public void LoginWithEmptyPassword() {

        Login.enterUserName(testData.Valid_UserName, driver);
        Login.enterPassword("", driver);
        Login.clickLoginBtn(driver);
        String ErrorMsg = Login.getErrorMsg(driver);
        Assert.assertEquals(ErrorMsg,testData.PasswordErrorMsg,"Error message is not matched");

    }

    @AfterMethod
    public void quiteDriver() {
     driver.quit();
    }
}
