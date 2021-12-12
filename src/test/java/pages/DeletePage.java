package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage extends BasePage{
    public DeletePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement deleteConfirmation;

    public void eraseSecondAddress(){
        deleteButton.click();
    }
    public String confirmAddressErasing(){
        return deleteConfirmation.getText();
    }

}
