package com.coderslab.hotel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.*;


import java.time.Duration;

public class HotelTest {
    private static WebDriver driver;


    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

    }
//    @Test
//    public void registerAccount(){
//        HotelHomePage HotelHomePage = new HotelHomePage(driver);
//        HotelLoginPage HotelLoginPage = new HotelLoginPage(driver);
//        CreateAccountPage CreateAccountPage = new CreateAccountPage(driver);
//
//        HotelHomePage.goToSignin();
//        HotelLoginPage.b4AccCreation("pepuga@papuga.com");
//
//        CreateAccountPage.register("Adrian","adrian","Adrian");
//
//        Assert.assertEquals("Your account has been created.",driver.findElement(By.xpath("//p[@class = 'alert alert-success']")).getText());
//
//    }

    @Test
    public void findHotelTest(){
        HotelHomePage hotelHomePage = new HotelHomePage(driver);
        HotelLoginPage hotelLoginPage = new HotelLoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        hotelHomePage.goToSignin();

        hotelLoginPage.signInTest("papuga@papuga.com","Adrian");

        myAccountPage.goToMainPage();

        hotelHomePage.addHotelToCartTest("germany","13-08-2022","18-08-2022");

        Assert.assertEquals("PAYMENT TYPES", checkoutPage.getTextFromPaymentMethod());
    }

    @Test
    public void finalizeOrderTest(){
        HotelHomePage hotelHomePage = new HotelHomePage(driver);
        HotelLoginPage hotelLoginPage = new HotelLoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        hotelHomePage.goToSignin();

        hotelLoginPage.signInTest("papuga@papuga.com","Adrian");

        myAccountPage.goToMainPage();

        hotelHomePage.addHotelToCartTest("Germany","13-08-2022","18-08-2022");

        checkoutPage.confirmOrder();

        Assert.assertEquals("ORDER CONFIRMATION", checkoutPage.getTextOrderConfirmation());
    }
    @After
    public void destroy(){
        driver.quit();
    }
}
