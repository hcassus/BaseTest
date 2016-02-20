package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.HomeActions;
import steps.LoginActions;

public class LeadTest {

    WebDriver driver;
    LoginActions loginActions;
    HomeActions homeActions;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
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
