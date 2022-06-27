package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy (id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy (id = "passwd")
    private WebElement passwordInput;
    @FindBy (xpath = "//p[@class='alert alert-success']")
    private WebElement successAlert;

    public void register(String fName, String lName, String pword){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(fName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(pword);

        driver.findElement(By.id("submitAccount")).click();
    }

    public String checkForSuccessAlert(){
        return successAlert.getText();
    }


}
