package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P03_Deals {
    public WebDriver driver;

    public P03_Deals(WebDriver driver){
        this.driver = driver;
    }

    private final By categoryListFields = By.xpath("//ol[@class='a-carousel']/li");
    private final By productListFields = By.cssSelector("div[data-testid='grid-deals-container'] img");
    private final By itemListFields = By.cssSelector("div[id='octopus-dlp-asin-stream'] img");
    private final By addToCartForGuestButtonField = By.name("submit.add-to-registry.wishlist.unrecognized");

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
}
