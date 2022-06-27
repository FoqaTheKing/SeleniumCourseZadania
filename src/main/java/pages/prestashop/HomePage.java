package pages.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/section/div/article[1]/div/a")
    private WebElement hummingBirdShirt;
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div")
    private WebElement discountCheck;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[1]/select")
    private WebElement sizeOfClothing;
    @FindBy(id = "quantity_wanted")
    private WebElement quantity;
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartButton;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheoutButton;

    public void goToLoginPage(){
        signInButton.click();
    }
    public void chooseHummingbirdShirt(){
        hummingBirdShirt.click();
    }
    public String checkIfDiscounted(){
        return discountCheck.getText();
    }

    public void addShirtToCart(String size, String qty){
        Select shirtSize = new Select(sizeOfClothing);
        shirtSize.selectByVisibleText(size);

        quantity.click();
        quantity.clear();
        quantity.sendKeys(qty);

        addToCartButton.click();
    }
    public void goToCheckout(){
        proceedToCheoutButton.click();
    }

}
