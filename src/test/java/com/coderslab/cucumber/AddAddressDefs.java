package com.coderslab.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.*;

import java.time.Duration;

public class AddAddressDefs {

    private WebDriver driver;
    private AddAddressPage addAddressPage;

    @Given("Open hotels main page")
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/");
    }
    @And("Sign in to existing account with {word}, {word}")
    public void signIn(String email, String password){
        HotelHomePage hotelHomePage = new HotelHomePage(driver);
        HotelLoginPage hotelLoginPage = new HotelLoginPage(driver);
        hotelHomePage.goToSignin();
        hotelLoginPage.signInTest(email,password);
    }
    @And("Go to add address page")
    public void goToAddresses(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAddAddressPage();
    }
    @When("Add address using: {word}, {word}, {word}, {word}")
    public void addAddressTest(String address, String postcode, String city, String phone){
        addAddressPage = new AddAddressPage(driver);
        addAddressPage.fillIn(address,postcode,phone,city);
    }
    @Then("Address should be added successfully")
    public void checkIfAddressHasBeenAdded(){
        Assert.assertTrue(addAddressPage.AddressIsAdded().contains("MY ADDRESS"));
    }
    @And("Close browser")
    public void closeBrowser(){
        driver.quit();
    }

}
