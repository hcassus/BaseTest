package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{

    private final String BASE_OPTION_XPATH = "//a[contains(@href,'/settings/') and text() = '%s']";
    private final String BASE_TAB_XPATH = "//a[@data-toggle and text() = '%s']";
    private final String BASE_EDIT_LEAD_STATUS_XPATH = "//button[contains(@class, 'edit') and ../../../label/h4/text() = '%s']";


    @FindBy(xpath = "//*[contains(@class, 'named-object-lead')]//input")
    WebElement statusNameField;

    @FindBy(xpath = "//*[contains(@class, 'named-object-lead')]//input/../../..//button")
    WebElement saveButton;

    public SettingsPage(WebDriver driver){
        super(driver);
    }

    public void navigateToOption(String optionName){
        clickByFormattableXpath(BASE_OPTION_XPATH, optionName);
    }

    public void navigateToTab(String tabName){
        clickByFormattableXpath(BASE_TAB_XPATH,tabName);
    }

    public void clickEditLeadStatusName(String leadStatusName){
        clickByFormattableXpath(BASE_EDIT_LEAD_STATUS_XPATH, leadStatusName);
    }

    public void fillInStatusName(String statusName){
        statusNameField.clear();
        statusNameField.sendKeys(statusName);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

}
