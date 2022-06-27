package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelLoginPage {
    private WebDriver driver;

    public HotelLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "SubmitCreate")
    private WebElement createAccountButton;
    @FindBy (name = "email_create")
    private WebElement newEmailInput;
    @FindBy  (id = "email")
    private WebElement emailInput;
    @FindBy (id = "passwd")
    private WebElement passwordInput;
    @FindBy (id = "SubmitLogin")
    private WebElement signInButton;

    public void goToMainRegistrationPage(String email){
        newEmailInput.click();
        newEmailInput.clear();
        newEmailInput.sendKeys(email);
        createAccountButton.click();
    }

    public void signInTest(String email, String password){
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }

}
