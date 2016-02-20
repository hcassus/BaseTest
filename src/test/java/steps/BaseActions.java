package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseActions {

    private BasePage page;

    protected BaseActions(WebDriver driver){
        page = new BasePage(driver);
    }

    public void navigateToLeadsMenu(){
        page.navigateToMenu("Leads");
    }

    public void navigateToSettings(){
        page.clickUserAvatar();
        page.clickSettingsOption();
    }
}
