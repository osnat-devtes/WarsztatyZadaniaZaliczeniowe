package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddNewAddressPage extends BasePage{
    public AddNewAddressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement zipCodeInput;

    @FindBy(name = "id_country")
    private WebElement countryDropdown;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

    public void addNewAddress(String alias, String address, String city, String zipCode, String country, String phone){
        enterText(aliasInput, alias);
        enterText(addressInput, address);
        enterText(cityInput, city);
        enterText(zipCodeInput, zipCode);
        tickDropdownText(countryDropdown, country);
        enterText(phoneInput, phone);
        saveButton.click();
    }

}
