package pages.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourAccountPage {

    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    private WebElement addressesButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/a[3]/span")
    private WebElement orderHistoryButton;
    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td")
    private WebElement numberOfColumns;

    public void goToAddAddressPage() {
        addressesButton.click();
    }

    public void goToOrderHistory() {
        orderHistoryButton.click();
    }

    public boolean checkIfOrderMatchesPriceAndStatus(String price, String orderId) {
        List<WebElement> rowElements = driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr"));
        int rowSize = rowElements.size();
        List<WebElement> columnElements = driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td"));
        int colSize = columnElements.size();

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < rowSize; j++) {
                if (driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr[" + i + "]/th")).getText().contains(orderId)) {
                    for (int p = 1; p < colSize; p++) {
                        if (driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i + "]/td[" + p + "]")).getText().contains(price)) {
                            for (int k = 1; k < colSize; k++) {
                                if (driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i + "]/td[" + k + "]")).getText().contains("Awaiting check payment")) {
                                    return true;
                                }
                            }
                        }
                    }
                }

            }

        }
        return false;
    }
}
