package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage extends BasePage {

    private final String BASE_LEAD_DETAIL_XPATH = "//a[@class='lead-name' and text() = '%s']";

    @FindBy(id = "leads-new")
    WebElement newLeadButton;

    @FindBy(id = "lead-first-name")
    WebElement leadNameField;

    @FindBy(id = "lead-last-name")
    WebElement leadLastNameField;

    @FindBy(xpath = "//button[contains(@class,'save')]")
    WebElement saveButton;

    @FindBy(className = "lead-status")
    WebElement leadStatus;

    public LeadsPage(WebDriver driver){
        super(driver);
    }

    public void clickNewLeadButton(){
        newLeadButton.click();
    }

    public void fillInLeadName(String leadName){
        leadNameField.sendKeys(leadName);
    }

    public void fillInLeadLastName(String leadLastName){
        leadLastNameField.sendKeys(leadLastName);
    }

    public void clickSaveButton(){
        saveButton.click();

    }

    public void goToLeadDetails(String leadName){
        clickByFormattableXpath(BASE_LEAD_DETAIL_XPATH, leadName);
    }

    public String getLeadCurrentStatus(){
        return leadStatus.getText();
    }

}
