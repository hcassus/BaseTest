package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LeadsPage;

public class LeadsActions extends BaseActions {

    private String leadName;
    private LeadsPage page;

    public LeadsActions(WebDriver driver) {
        super(driver);
        page = new LeadsPage(driver);
    }

    public void createNewLead(String leadName, String leadLastName) {
        this.leadName = leadName;
        page.clickNewLeadButton();
        page.fillInLeadName(leadName);
        page.fillInLeadLastName(leadLastName);
        page.clickSaveButton();
    }

    public void verifyLeadStatus(String status) {
        Assert.assertEquals(status, getLeadStatus(leadName));
    }

    private String getLeadStatus(String leadName) {
        return page.getLeadCurrentStatus();
    }

    public void openLead(String name) {
        page.goToLeadDetails(name);
    }

}
