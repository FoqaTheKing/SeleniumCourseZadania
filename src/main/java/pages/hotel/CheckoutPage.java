package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "openLoginFormBlock")
    private WebElement openLoginForm;
    @FindBy (id = "login_email")
    private WebElement emailInput;
    @FindBy (id = "login_passwd")
    private WebElement passwordInput;
    @FindBy (id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy (name = "cgv")
    private WebElement termsOfService;
    @FindBy (xpath = "//a[@class='bankwire']")
    private WebElement bankWirePayment;
    @FindBy (xpath = "//button[@class='btn pull-right button button-medium']")
    private WebElement confirmOrder;
    @FindBy (xpath = "//h3[@class='page-subheading']")
    private WebElement paymentMethod;
    @FindBy (xpath = "//h1[@class='page-heading']")
    private WebElement orderConfirmation;

    public String getTextFromPaymentMethod(){
        return paymentMethod.getText();
    }

    public String getTextOrderConfirmation(){
        return orderConfirmation.getText();
    }

    public void login(String email, String password){
        openLoginForm.click();

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();
    }

    public void confirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        termsOfService.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='bankwire']")));
        bankWirePayment.click();
        confirmOrder.click();
    }



}
