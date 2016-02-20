package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(linkText = "Log In")
    private WebElement loginLink;

    private final String BASE_WEBSITE = "http://getbase.com";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goToBaseWebsite(){
        goToUrl(BASE_WEBSITE);
    }

    public void clickLoginLink(){
        loginLink.click();
    }
}
