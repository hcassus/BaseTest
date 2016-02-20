package steps;

import org.openqa.selenium.WebDriver;
import pages.SettingsPage;

public class SettingsActions extends BaseActions{

    private SettingsPage page;

    public SettingsActions(WebDriver driver){
        super(driver);
        page = new SettingsPage(driver);
    }

    public void changeLeadStatusName(String originalName, String newName){
        page.navigateToOption("Leads");
        page.navigateToTab("Lead Statuses");
        editLeadStatus(originalName, newName);
    }

    public void editLeadStatus(String originalName, String newName){
        page.clickEditLeadStatusName(originalName);
        page.fillInStatusName(newName);
        page.clickSaveButton();
    }
}
