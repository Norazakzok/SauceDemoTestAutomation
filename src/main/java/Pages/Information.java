package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Information {
    WebDriver driver;

    public Information(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement FirstName() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement LastName() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement ZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public void AddInformation(WebDriver driver, String Fname, String Lname, String ZCode) throws InterruptedException {
        FirstName().sendKeys(Fname);
        Thread.sleep(1000);
        LastName().sendKeys(Lname);
        Thread.sleep(1000);
        ZipCode().sendKeys(ZCode);
        Thread.sleep(1000);
    }

    public WebElement Continue() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement Finish() {
        return driver.findElement(By.id("finish"));
    }
}
