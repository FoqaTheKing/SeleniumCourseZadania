package com.coderslab.cucumber;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.hotel.HotelLoginPage;
import pages.hotel.CreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.*;

import java.time.Duration;

public class CreateAccountDefs {

    private WebDriver driver;
    private CreateAccountPage createAccountPage;

    @Given("Open hotel main page")
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/");
    }

    @When("Create account using {word}, {word}, {word}, {word}")
    public void accountCreationTest(String email, String firstName, String lastName, String password){
        HotelLoginPage hotelLoginPage = new HotelLoginPage(driver);
        HotelHomePage hotelHomePage = new HotelHomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
        hotelHomePage.goToSignin();
        hotelLoginPage.goToMainRegistrationPage(email);
        createAccountPage.register(firstName,lastName,password);
    }
    @Then("account should be created")
    public void checkIfAccountIsCreated(){
        Assert.assertTrue(createAccountPage.checkForSuccessAlert().contains("Your account has been created"));
    }
    @And("close browser")
    public void closeBrowser(){
        driver.close();
    }



}
