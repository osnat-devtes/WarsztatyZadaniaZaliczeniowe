package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


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
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
}
