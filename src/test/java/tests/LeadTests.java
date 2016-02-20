package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.HomeActions;
import steps.LoginActions;

public class LeadTests {

    WebDriver driver;
    WebDriverWait wait;
    LoginActions loginActions;
    HomeActions homeActions;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        loginActions = new LoginActions(driver);
        homeActions = new HomeActions(driver);

        homeActions.goToBaseWebsite();
        homeActions.navigateToLogin();
        loginActions.performValidLogin();
    }

    @Test
    public void editLeadNameTest(){
        loginActions.navigateToLeadsMenu();
        System.out.println("Passei");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
