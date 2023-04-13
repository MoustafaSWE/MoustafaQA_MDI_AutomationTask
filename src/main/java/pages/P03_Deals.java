package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_Deals {
    public WebDriver driver;

    public P03_Deals(WebDriver driver){
        this.driver = driver;
    }

    private final By categoryListFields = By.xpath("//ol[@class='a-carousel']/li");
    private final By productListFields = By.cssSelector("div[data-testid='grid-deals-container'] img");
    private final By itemListFields = By.cssSelector("div[id='octopus-dlp-asin-stream'] span[class='a-list-item']");
    private final By addToCartForGuestButtonField = By.id("add-to-cart-button");
    private final By regularPriceRadioButtonField = By.cssSelector("i[class='a-icon a-accordion-radio a-icon-radio-inactive']");
    private final By qtyField = By.id("quantity");

    public List<WebElement> categoryList (){
        return driver.findElements(categoryListFields);
    }

    public List<WebElement> productList (){
        return driver.findElements(productListFields);
    }

    public List<WebElement> itemList (){
        return driver.findElements(itemListFields);
    }

    public WebElement addToCartForGuestButton (){
        return driver.findElement(addToCartForGuestButtonField);
    }

    public WebElement regularPriceRadioButton () {
        return driver.findElement(regularPriceRadioButtonField);
    }

    public void selectQtyByValue (String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Select select = new Select(driver.findElement(qtyField));
        wait.until(ExpectedConditions.elementToBeClickable(qtyField));
        select.selectByValue(value);
    }
}
