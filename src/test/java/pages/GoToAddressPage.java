package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoToAddressPage extends BasePage{
    public GoToAddressPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id='addresses-link']")
    List <WebElement> addressesButton;

    @FindBy(xpath = "//*[@id='address-link']")
    List <WebElement> addressButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a/span")
    private WebElement createNewAddressButton;

    public void goToAddressesForm(){
        createNewAddressButton.click();
    }
    public void clickCorrectButton(){
        if(addressesButton.size()>0){
            addressesButton.get(0).click();
        }else if(addressButton.size()>0){
            addressButton.get(0).click();
        }
    }
}
