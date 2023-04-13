package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_Cart {
    public WebDriver driver;

    public P04_Cart (WebDriver driver){
        this.driver = driver;
    }

    By actualItemNameField = By.className("a-truncate-cut");

    public String actualItemName (){
        return driver.findElement(actualItemNameField).getText();
    }
}
