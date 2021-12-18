package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected void enterText(WebElement element, String enteredText){
        element.click();
        element.clear();
        element.sendKeys(enteredText);
    }
    protected void tickDropdownText(WebElement element, String enteredDropdownText){
        element.click();
        Select drpElement = new Select(element);
        drpElement.selectByVisibleText(enteredDropdownText);
    }
    public String getLandingUrl(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }
}
