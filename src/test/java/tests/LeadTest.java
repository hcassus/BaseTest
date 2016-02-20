package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.HomeActions;
import steps.LeadsActions;
import steps.LoginActions;
import steps.SettingsActions;

public class LeadTest {

    WebDriver driver;
    LoginActions loginActions;
    HomeActions homeActions;
    LeadsActions leadsActions;
    SettingsActions settingsActions;
    String originalStatusName = "New";
    String newStatusName = "Brand New";

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        loginActions = new LoginActions(driver);
        homeActions = new HomeActions(driver);
        leadsActions = new LeadsActions(driver);
        settingsActions = new SettingsActions(driver);

        homeActions.goToBaseWebsite();
        homeActions.navigateToLogin();
        loginActions.performValidLogin();
    }

    @Test
    public void editLeadNameTest(){
        String leadName = "Lead Name";
        String leadLastName = "Test";

        loginActions.navigateToLeadsMenu();
        leadsActions.createNewLead(leadName, leadLastName);



        leadsActions.verifyLeadStatus(originalStatusName);
        leadsActions.navigateToSettings();
        settingsActions.changeLeadStatusName(originalStatusName,newStatusName);
        settingsActions.navigateToLeadsMenu();
        leadsActions.openLead(leadName + " " + leadLastName);
        leadsActions.verifyLeadStatus(newStatusName);
    }

    @After
    public void teardown(){
        leadsActions.navigateToSettings();
        settingsActions.changeLeadStatusName(newStatusName, originalStatusName);
        driver.quit();
    }
}
