package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[1]/h4")
    private WebElement address2Alias;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[1]/address")
    private WebElement address2Block;

    public String getAddress2AliasDescription(){
        return address2Alias.getText();
    }
    public String getAddress2Description(){
        return address2Block.getText();
    }
}
