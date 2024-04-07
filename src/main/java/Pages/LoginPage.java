package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    public WebElement UserName(){
        return driver.findElement(By.id("user-name"));
    }

    public WebElement Password(){
        return driver.findElement(By.id("password"));
    }

    public By css(){
     return By.cssSelector(".error-message-container > h3:nth-child(1)");
    }

    public void LoginSteps(WebDriver driver,String UserName,String Password) throws InterruptedException {
        UserName().sendKeys(UserName);
        Password().sendKeys(Password);

        // Add a sleep for 1 seconds
        Thread.sleep(1000);

        Password().sendKeys(Keys.ENTER);
        // Add a sleep for 1 seconds
        Thread.sleep(1000);
    }
}
