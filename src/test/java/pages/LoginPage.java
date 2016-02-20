package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[i[@class = 'icon-lock']]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void fillEmail(String email){
        emailField.sendKeys(email);
    }

    public void fillPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
