import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScenarios {
    WebDriver driver;
    LoginPage login;
    HomePage home;
    Information info;
    List list;

    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        login = new LoginPage(driver);
        home = new HomePage(driver);
        info = new Information(driver);
        list = new List(driver);
        Thread.sleep(1000);
    }

    @Test
    public void happyScenario() throws InterruptedException {
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");

        // Perform login
        login.LoginSteps(driver, "standard_user", "secret_sauce");

        //Verify that user is on the home page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        // Add item to cart
        home.AddFirstElement().click();

        Thread.sleep(1000);

        // Go to cart
        home.GoToCart();

        //remove first element
        home.RemoveFirstElement().click();

        Thread.sleep(1000);


        //back to shopping
        home.Continue().click();

        Thread.sleep(1000);

        //sort from low to high
        home.SortSteps();

        Thread.sleep(1000);

        // Add items to cart
        home.AddToCartLow();

        // Go to cart
        home.GoToCart();

        Thread.sleep(1000);

        // Scroll down
        ScrollHelper.scrollToBottom(driver);

        Thread.sleep(1000);

        // Proceed to checkout
        home.CheckOut();

        // Add information
        info.AddInformation(driver, "Nora", "Zakzok", "6144651");

        Thread.sleep(1000);

        // Continue to next step
        info.Continue().click();

        Thread.sleep(1000);

        // Scroll down
        ScrollHelper.scrollToBottom(driver);

        // Wait for some time
        Thread.sleep(1000);

        // Finish order
        info.Finish().click();

        Thread.sleep(1000);

        //Verify 'Thank you for your order!' is visible
        WebElement newUserSignup = driver.findElement(By.cssSelector(".complete-header"));
        Assert.assertTrue(newUserSignup.isDisplayed(), "'Thank you for your order!' is not visible on the webpage");

        //Back to home
        home.BackToHome().click();

        // Open list
        list.OpenList().click();

        // Wait for some time
        Thread.sleep(1000);

        // User is logged out
        list.Logout().click();
    }

//    @Test(priority = 2)
    @Test
    public void badScenario() throws InterruptedException {
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");

        // Perform login
        login.LoginSteps(driver, "standd_user", "secretsauce");

        // Verify error message
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(login.css()).getText();
        Assert.assertTrue(actual.contains(expected));
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}