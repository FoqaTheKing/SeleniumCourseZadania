package pages.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement signInButton;
    @FindBy(xpath = "/html/body/main/header/div[2]/div/div[1]/div[1]/a")
    private WebElement homeButton;

    public void userLogin(String email, String password){
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }
    public void goToHomePage(){
        homeButton.click();
    }
}
