package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ScreenshotUtil;

public class ProductPage {
    WebDriver driver;

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
        ScreenshotUtil.takeScreenshot(driver, "addToCartBtn");
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
        ScreenshotUtil.takeScreenshot(driver, "goToCart");
    }
}
