package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginActions extends BaseActions{

    private LoginPage page;

    public LoginActions(WebDriver driver){
        super(driver);
        page = new LoginPage(driver);
    }

    public void performValidLogin(){
        String valid_email_env = System.getenv("VALID_EMAIL");
        String valid_password_env = System.getenv("VALID_PASSWORD");

        String valid_email = valid_email_env != null ? valid_email_env : "";
        String valid_password = valid_password_env != null ? valid_password_env : "";

        page.fillEmail(valid_email);
        page.fillPassword(valid_password);
        page.clickLoginButton();
    }
}
