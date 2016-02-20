package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    WebDriver driver;
    String BASE_MENU_XPATH = "//a[@data-original-title='%s']";

    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void navigateToMenu(String menuName){
        String menu_xpath = String.format(BASE_MENU_XPATH, menuName);
        driver.findElement(By.xpath(menu_xpath)).click();
    }

}
