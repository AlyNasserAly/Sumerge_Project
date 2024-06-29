package Methods;


import Elements.LoginElements;
import org.openqa.selenium.edge.EdgeDriver;

public class Login_Methods extends Base_Page {

    public Login_Methods(){
        super();
    }
    public EdgeDriver driver;


    public String checkUserName(EdgeDriver driver) {

        String username = String.valueOf(driver.findElement(LoginElements.UserName).getAttribute("id"));
        return username ;
    }

    public String checkPassword(EdgeDriver driver) {
       String password = String.valueOf(driver.findElement(LoginElements.Password).getAttribute("id"));
        return password;
    }

    public String checkLoginBtn(EdgeDriver driver) {

        String loginbutton = String.valueOf(driver.findElement(LoginElements.Login_Btn).getAttribute("id"));
        return loginbutton;
    }

    public void enterUserName(String UserName, EdgeDriver driver) {

        driver.findElement(LoginElements.UserName).sendKeys(UserName);
    }

    public void enterPassword(String Password, EdgeDriver driver) {
        driver.findElement(LoginElements.Password).sendKeys(Password);
    }

    public void clickLoginBtn(EdgeDriver driver) {

        driver.findElement(LoginElements.Login_Btn).click();
    }

    public String getErrorMsg(EdgeDriver driver) {

       String ErrorMsg = driver.findElement(LoginElements.Error_Msg).getText();
       return ErrorMsg;
    }
}
