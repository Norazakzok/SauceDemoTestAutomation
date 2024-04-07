package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class List {
    WebDriver driver;
    public List(WebDriver driver){
        this.driver=driver;
    }
    public WebElement OpenList(){
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement Logout(){
        return driver.findElement(By.id("logout_sidebar_link"));
    }
}

