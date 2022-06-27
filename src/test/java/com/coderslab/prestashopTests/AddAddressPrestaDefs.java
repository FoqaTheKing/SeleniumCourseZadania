package com.coderslab.prestashopTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.prestashop.*;
import java.time.Duration;

public class AddAddressPrestaDefs {

    private WebDriver driver;
    private AddressPage addressPage;


    @Given("Open presta shop main page")
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
    @And("log into existing account with {word} and {word}")
    public void loginToExistingAccount(String email, String password){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.goToLoginPage();
        loginPage.userLogin(email,password);
    }
    @And("open Addresses page")
    public void openAddressPage(){
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToAddAddressPage();
    }
    @When("Add address using {word}, {}, {word}, {word}, {}, {word}")
    public void addAddress(String alias, String address, String city, String postcode, String country, String phoneNo){
        addressPage = new AddressPage(driver);
        addressPage.addAddress(alias,address,city,postcode,country,phoneNo);
    }
    @Then("Address should contain {}")
    public void checkIfAddressWasAddedSuccessfully(String address){
        Assert.assertTrue(addressPage.checkAddress().contains(address));
    }
    @And("Address should be deleted after")
    public void checkIfAddressWasDeleted(){
        Assert.assertTrue(addressPage.deleteAddress().contains("deleted"));
    }
    @And("Close browser")
    public void exit(){
        driver.quit();
    }
}
