package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelHomePage {
    private WebDriver driver;

    public HotelHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@class='user_login navigation-link']")
    private WebElement signinButton;
    @FindBy (id = "hotel_location")
    private WebElement hotelLocation;
    @FindBy (xpath = "//button[@class = 'form-control header-rmsearch-input ']")
    private WebElement selectHotelButton;
    @FindBy (name = "check_in_time")
    private WebElement checkInDate;
    @FindBy (name = "check_out_time")
    private WebElement checkOutDate;
    @FindBy (id = "search_room_submit")
    private WebElement searchButton;
    @FindBy (xpath = "//a[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckoutButton;


    public void goToSignin(){
        signinButton.click();
    }

    private void addRoomToCart() {
        List<WebElement> rooms = driver.findElements(By.xpath("//span[contains(text(),'Book Now')]"));
        rooms.get(0).click();
    }
    public void addHotelToCartTest(String location, String inDate, String outDate){
        hotelLocation.click();
        hotelLocation.clear();
        hotelLocation.sendKeys(location);

        checkInDate.click();
        checkInDate.clear();
        checkInDate.sendKeys(inDate);

        checkOutDate.click();
        checkOutDate.clear();
        checkOutDate.sendKeys(outDate);

        selectHotelButton.click();
        driver.findElement(By.xpath("//li[@class='hotel_name']")).click();

        searchButton.click();
        addRoomToCart();

        proceedToCheckoutButton.click();

    }


}
