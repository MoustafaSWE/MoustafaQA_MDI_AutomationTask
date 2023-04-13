package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_Login {
    public WebDriver driver;

    public P01_Login (WebDriver driver){
        this.driver = driver;
    }

    private final By emailField = By.name("email");
    private final By loginButtonField = By.cssSelector("input[id='continue']");
    private final By errorMessageField = By.cssSelector("span[class='a-list-item']");

    public WebElement email (){
        return driver.findElement(emailField);
    }

    public WebElement loginButton (){
        return driver.findElement(loginButtonField);
    }

    public String errorMessage (){
        return driver.findElement(errorMessageField).getText();
    }
}
