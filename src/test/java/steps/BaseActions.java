package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseActions {

    BasePage page;

    public BaseActions(WebDriver driver){
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
