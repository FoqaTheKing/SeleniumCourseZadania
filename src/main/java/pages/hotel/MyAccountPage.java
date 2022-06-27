package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//img[@class = 'logo img-responsive']")
    private WebElement mainPageLogo;
    @FindBy (xpath = "//a[@title='Addresses']")
    private WebElement addressesButton;
    @FindBy (xpath = "//a[@title='Add an address']")
    private WebElement addAddressButton;

    public void goToMainPage(){
        mainPageLogo.click();
    }
    public void goToAddAddressPage(){
        addressesButton.click();
        addAddressButton.click();
    }


}
