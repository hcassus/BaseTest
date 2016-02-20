package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String BASE_MENU_XPATH = "//a[@data-original-title='%s']";

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void navigateToMenu(String menuName){
        String menu_xpath = String.format(BASE_MENU_XPATH, menuName);
        By menu_locator = By.xpath(menu_xpath);
        wait.until(ExpectedConditions.elementToBeClickable(menu_locator));
        driver.findElement(menu_locator).click();
    }

}
