package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAddressPage {

    private WebDriver driver;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h1[@class='page-subheading']")
    private WebElement yourAddress;
    @FindBy (id = "address1")
    private WebElement addressInput;
    @FindBy (id = "postcode")
    private WebElement postcodeInput;
    @FindBy (id = "phone")
    private WebElement phoneInput;
    @FindBy (id = "submitAddress")
    private WebElement saveButton;
    @FindBy (id = "city")
    private WebElement cityInput;
    @FindBy (xpath = "//h3[@class='page-subheading']")
    private WebElement addedAddress;

    public void fillIn(String address, String postcode, String phone, String city){
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        saveButton.click();
    }
    public String AddressIsAdded(){
        return addedAddress.getText();
    }


}
