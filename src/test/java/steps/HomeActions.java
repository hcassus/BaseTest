package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class HomeActions extends BaseActions{

    HomePage page;

    public HomeActions(WebDriver driver){
        super(driver);
        page = new HomePage(driver);
    }

    public void goToBaseWebsite(){
        page.goToBaseWebsite();
    }

    public void navigateToLogin(){
        page.clickLoginLink();
    }

}
