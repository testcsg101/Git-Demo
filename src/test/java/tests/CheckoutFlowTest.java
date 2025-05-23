package tests;

import org.testng.annotations.Test;
import tests.*;
import Pages.*;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductPage products = new ProductPage(driver);
        products.addToCart();
        products.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillCheckoutInfo("John", "Doe", "12345");
    }
}
