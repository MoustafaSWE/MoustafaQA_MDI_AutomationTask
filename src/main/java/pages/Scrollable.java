package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scrollable {
    public WebDriver driver;
    public JavascriptExecutor js;

    public Scrollable (WebDriver driver){
        this.driver=driver;
    }


    private By priceField = By.name("mainPrice");

    public void scrollDownToItemVariations (){
        js = (JavascriptExecutor) driver;
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(priceField));
        js.executeScript("arguments[0].scrollIntoView();",element );
    }

    public void navigateBack (){
        driver.navigate().back();
    }
}
