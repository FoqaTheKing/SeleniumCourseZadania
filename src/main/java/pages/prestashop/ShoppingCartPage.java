package pages.prestashop;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[2]/button")
    private WebElement confirmAddressButton;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button")
    private WebElement confirmShippingMethodButton;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/span/input")
    private WebElement payByCheck;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input")
    private WebElement termsAndServiceAgreement;
    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    private WebElement confirmOrderButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[1]/div/table/tbody/tr[3]/td[2]")
    private WebElement priceOfOrder;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[2]/ul/li[1]")
    private WebElement orderReference;
    @FindBy(xpath = "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[2]")
    private WebElement goToAccountButton;

    public void orderHummingbirdShirt(){
        proceedToCheckoutButton.click();
        confirmAddressButton.click();
        confirmShippingMethodButton.click();
        payByCheck.click();
        termsAndServiceAgreement.click();
        confirmOrderButton.click();
    }
    public void takeScreenshotOfOrderCornfirmation() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("report/screenshot/order_confirmation.png"));
    }
    public void goToYourAccount(){
        goToAccountButton.click();
    }
    public String getOrderPrice(){
        return priceOfOrder.getText();
    }
    public String getOrderReferenceNumber(){
        String h = orderReference.getText();
        String k = "";
        int l = h.length();
        for (int i = 9; i >= 1; i--) {
            k += h.charAt(l-i);
        }
        return k;
    }

}
