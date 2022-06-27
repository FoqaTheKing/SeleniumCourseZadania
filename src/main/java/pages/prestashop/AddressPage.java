package pages.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a")
    private WebElement createNewAddressButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement postcodeInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[1]")
    private WebElement updateButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]")
    private WebElement deleteButton;
    @FindBy(name = "id_country")
    private WebElement dropDownCountry;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/aside/div/article")
    private WebElement successAlert;


    public void addAddress(String alias, String address, String city, String postcode, String country, String phoneNumber){
        createNewAddressButton.click();

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        Select dropdown = new Select(dropDownCountry);
        dropdown.selectByVisibleText(country);

        saveButton.click();
    }
    public String deleteAddress(){
        deleteButton.click();
        return successAlert.getText();    }
    public String checkAddress(){
        updateButton.click();
        String result = addressInput.getAttribute("value");
        driver.navigate().back();
        return result;

    }


}
