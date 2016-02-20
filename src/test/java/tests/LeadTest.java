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

    private WebDriver driver;
    private LoginActions loginActions;
    private HomeActions homeActions;
    private LeadsActions leadsActions;
    private SettingsActions settingsActions;
    private final String ORIGINAL_STATUS_NAME = "New";
    private final String NEW_STATUS_NAME = "Brand New";

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
        final String leadName = "Lead Name";
        final String leadLastName = "Test";

        loginActions.navigateToLeadsMenu();
        leadsActions.createNewLead(leadName, leadLastName);

        leadsActions.verifyLeadStatus(ORIGINAL_STATUS_NAME);

        leadsActions.navigateToSettings();

        settingsActions.changeLeadStatusName(ORIGINAL_STATUS_NAME, NEW_STATUS_NAME);
        settingsActions.navigateToLeadsMenu();
        leadsActions.openLead(leadName + " " + leadLastName);

        leadsActions.verifyLeadStatus(NEW_STATUS_NAME);
    }

    @After
    public void teardown(){
        leadsActions.navigateToSettings();
        settingsActions.changeLeadStatusName(NEW_STATUS_NAME, ORIGINAL_STATUS_NAME);
        driver.quit();
    }
}
