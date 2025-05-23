Feature: Login to the app and adding the item to cart and navigating to the product page

  Scenario Outline: Login, add item to cart, and proceed to checkout on Saucedemo
    Given User navigates to "https://www.saucedemo.com/"
    When User logs in with username <username> and password <password>
    Then User should be redirected to the products page

    

    When User adds the "Sauce Labs Backpack" to the cart
    And User opens the cart page
    Then "Sauce Labs Backpack" should be visible in the cart

    When User clicks on the checkout button
    And User fills in checkout information with first name <firstname>, last name <lastname>, and zip code <zipcode>
    And User clicks on the continue button
    Then User should be on the checkout overview page
    Examples:
      | username      | password      ||firstname||lastname||zipcode|
      | standard_user | standard_user ||John			||Doe			||12345	 |
  