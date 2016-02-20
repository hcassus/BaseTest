package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String BASE_MENU_XPATH = "//a[@data-original-title='%s']";

    @FindBy(className = "user-avatar")
    WebElement userAvatar;

    @FindBy(xpath = "//li[@class='settings']//a[strong/text() = 'Settings']")
    WebElement settingsOption;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void clickUserAvatar(){
        userAvatar.click();
    }

    public void clickSettingsOption(){
        settingsOption.click();
    }

    public void navigateToMenu(String menuName){
        clickByFormattableXpath(BASE_MENU_XPATH, menuName);
    }

    protected void clickByFormattableXpath(String replaceableXpath, String replaceString){
        By elementLocator = By.xpath(String.format(replaceableXpath, replaceString));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        element.click();
    }
}
