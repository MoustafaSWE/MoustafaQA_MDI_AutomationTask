package testCases;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;


public class T01_AutomationTask extends BaseTest {

    private P01_Login login;
    private P02_Home home;
    private P03_Deals deals;
    private P04_Cart cart;
    private Scrollable scrollable;

    @Test(description = """
            Scenario 1 (Verify that user cannot log in with valid but not registered email)
                ● Go to https://www.amazon.eg/
                ● Verify user can’t login with valid but not registered email
            """)
    public void verifyThatUserCannotLoginWithValidNotRegisteredEmail() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Verify that user cannot log in with valid but not registered email");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

        home.signInToolTipIcon()
                .click();
        login.email()
                .sendKeys("peaceman970@gmail.com");
        login.loginButton()
                .click();
        Assert.assertTrue(login
                .errorMessage()
                .contains("لا يمكننا العثور على حساب بعنوان البريد الإلكتروني هذا."));
    }

    @Test(description = """
            Scenario 2 (Verify that Items are added to cart correctly)
                ● Go to https://www.amazon.eg/
                ● Click on All tab
                ● Go to Today’s Deals
                ● Click on 2nd category
                ● Click on 1st product in this category
                ● Click on 2nd item in this product
                ● Add it to cart with Qty = 2
                ● Do all the necessary actions to add the item to the cart
                ● Go to cart
                ● Verify correct items are added to the cart (name, price, qty and subtotal is correct)
            """)
    public void verifyThatItemAreAddedToCartCorrectly() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Verify that Items are added to cart correctly");
        test.log(Status.INFO, "starting");
        test.assignCategory("P1");

        home.allMenu()
                .click();
        home.deals()
                .click();
        deals.categoryList()
                .get(1)
                .click();
        deals.productList()
                .get(0)
                .click();
        String expectedItem = deals.itemList()
                .get(1)
                .getText();
        deals.itemList()
                .get(1)
                .click();
        deals.regularPriceRadioButton()
                .click();
        deals.selectQtyByValue("2");
        deals.addToCartForGuestButton()
                .click();
        home.cartIcon()
                .click();
        Assert.assertTrue(expectedItem
                .contains(cart
                .actualItemName()));
    }

    @Test(description = """
            Scenario 3: (Verify that you cannot see “Your Orders” and “Your Addresses” pages if you are not logged in. But you can see “Your Lists” intro screen)
                ● Go to https://www.amazon.eg/
                ● Click on “Hello, sign in Account & Lists” at the top right corner
                ● Select “Your orders”
                ● Make sure user can’t see orders when not signed in
                ● Select “Your Addresses”
                ● Make sure user can’t see orders when
            """)
    public void verifyThatUserCannotSeeYourOrderAndYourAddressPage() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Verify that you cannot see “Your Orders” and “Your Addresses” pages if you are not logged in. But you can see “Your Lists” intro screen");
        test.log(Status.INFO, "starting");
        test.assignCategory("P1");

        home.hoverOnHelloAndSignInIcon();
        home.yourOrder()
                .click();
        Assert.assertTrue(login
                .signInText()
                .contains("تسجيل الدخول"));
        scrollable.navigateBack();
        home.hoverOnHelloAndSignInIcon();
        home.yourAddress()
                .click();
        Assert.assertTrue(login
                .signInText()
                .contains("تسجيل الدخول"));
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.eg/");

        home = new P02_Home(driver);
        login = new P01_Login(driver);
        deals = new P03_Deals(driver);
        cart = new P04_Cart(driver);
        scrollable = new Scrollable(driver);
    }

    @AfterMethod
    public void end() {
        driver.quit();
    }

    @BeforeTest()
    public void startReport() {
        initializeReport();
    }

    @AfterTest()
    public void endReport() {
        extent.flush();
    }
}
