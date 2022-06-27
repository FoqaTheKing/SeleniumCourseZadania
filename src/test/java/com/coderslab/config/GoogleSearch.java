package com.coderslab.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class GoogleSearch {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://www.google.com");
//        driver.findElement(By.id("L2AGLb")).click();
//        WebElement element = driver.findElement(By.name("q"));
//        element.clear();
//        element.sendKeys("Coderslab");
//        element.submit();


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.get("https://hotel-testlab.coderslab.pl/en/");
//        WebElement element = driver.findElement(By.name("q"));
//        element.clear();
//        element.sendKeys("Robert Makłowicz");
//        element.submit();


        driver.get("https://www.google.com");
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.get("https://coderslab.pl/pl");
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.navigate().back();
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.navigate().back();
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.navigate().forward();
        try{
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            System.out.println("error");
        }
        driver.navigate().refresh();

    }
}
