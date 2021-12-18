package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressSteps {
    public WebDriver driver;

    //If there is no addresses created the test should be run two times
    //the first time - for creating the first address, and it will not pass
    //and the second time - for the second address and then the test should pass
    @Given("an open browser with my store website")
    public void anOpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("^an email (.*) and a password (.*) areas are filled in$")
    public void signInWithEmailAndPassword(String email, String password) {
        LogInPage userLogIn = new LogInPage(driver);
        userLogIn.logIn(email,password);
    }

    @Then("checking if the user has already created at least one address and clicking address button")
    public void checkingCreatedAddress() {
        GoToAddressPage goToAddressPage = new GoToAddressPage(driver);
        goToAddressPage.clickCorrectButton();
    }

    @And("the link should contain {string}")
    public void textShouldContainLink(String expectedLink) {
        BasePage landingUrl = new BasePage(driver);
        GoToAddressPage goToAddressPage = new GoToAddressPage(driver);
        try
            {Assert.assertEquals(expectedLink, landingUrl.getLandingUrl());
            goToAddressPage.goToAddressesForm();
            }catch(ComparisonFailure e){
            System.out.println("Adding the first address");
        }
    }

    @When("^after clicking on Create new address the form is filled in with alias (.*),address (.*),city (.*),zip\\/postal (.*),country (.*),phone (.*)$")
    public void fillInTheAddressesForm(String alias, String address, String city, String zipCode, String country, String phone) {
        AddNewAddressPage addAddress = new AddNewAddressPage(driver);
        addAddress.addNewAddress(alias, address, city, zipCode, country, phone);
    }

    @Then("^the address container should contain alias (.*),address (.*),city (.*),zip\\/postal (.*),country (.*),phone (.*)$")
    public void CheckEnteredAddresses(String alias, String address, String city, String zipCode, String country, String phone) {
        AddressesPage addressesPage = new AddressesPage(driver);
        String firstAndLastName = "Nata Testerska";
        String address2Data = firstAndLastName+'\n'+address+'\n'+city+'\n'+zipCode+'\n'+country+'\n'+phone;
        driver.navigate().refresh();
        Assert.assertEquals(alias, addressesPage.getAddress2AliasDescription());
        Assert.assertEquals(address2Data, addressesPage.getAddress2Description());
    }

    @Then("erasing the second address and the string should contain {string}")
    public void eraseTheSecondAddress(String expectedEraseConfirmation) {
        DeletePage deletePage = new DeletePage(driver);
        deletePage.eraseSecondAddress();
        Assert.assertEquals(expectedEraseConfirmation, deletePage.confirmAddressErasing());
    }

    @And("close the browser")
    public void closeTheBrowser() {
        //driver.quit();
    }
}
