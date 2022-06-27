package com.coderslab.duckduckgo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefs {

    private WebDriver driver;

    @Given("open a browser with duckduckgo")
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
    }

    @When("a keyword {word} is entered in input field")
    public void enterKeyword(String keyword){
        WebElement element = driver.findElement(By.id("search_form_input_homepage"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("the first record should contain {word}")
    public void containsWord(String expectedWord){
        WebElement result = driver.findElement(By.id("r1-0"));
        Assert.assertTrue(result.getText().contains(expectedWord));
    }

    @And("close browser")
    public void closeBrowser(){
        driver.close();
    }

}
