package com.coderslab.prestashopTests;

import io.cucumber.java.en.Given;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.prestashop.HomePage;
import pages.prestashop.LoginPage;
import pages.prestashop.ShoppingCartPage;
import pages.prestashop.YourAccountPage;

import java.io.IOException;
import java.time.Duration;

public class ChekoutTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
        loginPage.userLogin("adrian@adrian.adrian","adrian");
    }

    @Test
    public void test() throws IOException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        loginPage.goToHomePage();
        homePage.chooseHummingbirdShirt();
        Assert.assertTrue(homePage.checkIfDiscounted().contains("20%"));
        homePage.addShirtToCart("L","10");
        homePage.goToCheckout();
        shoppingCartPage.orderHummingbirdShirt();
        shoppingCartPage.takeScreenshotOfOrderCornfirmation();
        String price = shoppingCartPage.getOrderPrice();
        String orderId = shoppingCartPage.getOrderReferenceNumber();
        shoppingCartPage.goToYourAccount();
        yourAccountPage.goToOrderHistory();
        Assert.assertTrue(yourAccountPage.checkIfOrderMatchesPriceAndStatus(price,orderId));
    }

    @After
    public void destroy(){
        driver.quit();
    }

}
