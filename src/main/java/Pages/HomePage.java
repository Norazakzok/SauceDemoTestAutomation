package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement Sort(){return driver.findElement(By.cssSelector(".product_sort_container"));}

    public WebElement Low(){return driver.findElement(By.cssSelector(".product_sort_container > option:nth-child(3)"));}

    public WebElement AddFirstElement(){
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public WebElement RemoveFirstElement(){
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement AddSecElement(){
        return driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    }
    public WebElement AddThirdElement(){ return driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));    }
    public WebElement AddForthElement(){ return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));    }

    public WebElement Continue(){return driver.findElement(By.id("continue-shopping"));}
    public WebElement BackToHome(){return driver.findElement(By.id("back-to-products"));}




    public void GoToCart() throws InterruptedException {
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        cart.click();
        Thread.sleep(1000);
    }
    public void CheckOut(){
        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

    }

    public void SortSteps() throws InterruptedException {
        Sort().click();
        Thread.sleep(1000);
        Low().click();
    }
    public void AddToCartLow() throws InterruptedException {
        AddSecElement().click();
        Thread.sleep(1000);
        AddThirdElement().click();
        Thread.sleep(1000);
        AddForthElement().click();
        Thread.sleep(1000);
    }


}
