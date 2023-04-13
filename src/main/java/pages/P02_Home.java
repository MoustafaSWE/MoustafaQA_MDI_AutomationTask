package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_Home {
    public WebDriver driver;

    public P02_Home (WebDriver driver){
        this.driver = driver;
    }

    private final By signInToolTip = By.cssSelector("div[id='nav-signin-tooltip'] span[class='nav-action-inner']");
    private final By allMenuField = By.className("hm-icon-label");
    private final By dealsField = By.xpath("//a[text()='عروض اليوم' and @class='hmenu-item']");


    public WebElement signInToolTipIcon () {
        return driver.findElement(signInToolTip);
    }

    public WebElement allMenu (){
        return driver.findElement(allMenuField);
    }

    public WebElement deals (){
        return driver.findElement(dealsField);
    }
}
