Feature: Login

  Background: Setup browser
    Given User launch chrome browser
    When User opens URL "https://automationexercise.com/"
    Then User should view home page

  Scenario: TC01 - Register user
    When User clicks on signup login button
    Then User should view New user sign up text
    When User enters name as "Flautita" and email address as "tomasdor@gmail.com"
    And User clicks on signup button
    Then User should view Enter account information text
    When User fills title, name, email, password, date of birth
    And User selects checkbox Sign up for our newsletter
    And User selects checkbox Receive special offers from our partners
    And User fills first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And User clicks on create account button
    Then User should view Account created text
    When User clicks on continue button
    Then User should view Logged in as username text
    When User clicks on delete account button
    Then User should view Account deleted text

  Scenario: TC02 - Login User with correct email and password
    When User clicks on signup login button
    Then User should view user login text
    When User enters login mail address as "tomasvd1.garoe@gmail.com"
    And User enters login password as "Testing123"
    And User clicks on login button
    Then User should view Logged in as username text

  Scenario: TC03 - Login User with incorrect email and password
    When User clicks on signup login button
    Then User should view user login text
    When User enters login mail address as "pepitomondanga@hotmail.com"
    And User enters login password as "cachafate"
    And User clicks on login button
    Then User should view incorrect credentials message

  Scenario: TC04 - Logout User
    When User clicks on signup login button
    Then User should view user login text
    When User enters login mail address as "tomasvd1.garoe@gmail.com"
    And User enters login password as "Testing123"
    And User clicks on login button
    Then User should view Logged in as username text
    When User clicks on logout button
    Then User should view user login text

  Scenario: TC05 - Register User with existing email
    When User clicks on signup login button
    Then User should view New user sign up text
    When User enters name as "Pochoclito" and email address as "tomasvd1.garoe@gmail.com"
    And User clicks on signup button
    Then User should view existent email message

  Scenario: TC06 - Contact Us Form
    When User clicks on contact us button
    Then User should view get in touch message
    When User enters name, email, subject and message
    And User uploads a file
    And User clicks on submit button
    And User clicks OK on alert
    Then User should view successful submit message
    When User clicks on home page
    Then User should view home page

  Scenario: TC07 - Verify Test Cases Page
    When User clicks on test cases button
    Then User should view test cases page


  Scenario: TC08 - Verify All Products and product detail page
    When User clicks on products button
    Then User should view all products text
    And User should view all products list
    When User clicks on view product
    Then User should view product name, category, price, availability, condition and brand

  Scenario: TC09 - Search product
    When User clicks on products button
    Then User should view all products text
    When User enters "dress" on search input
    And User clicks on search button
    Then User should view searched products message
    And User should view all products related to te search


  Scenario: TC010 - Verify Subscription in home page
    Then User should scroll down and view subscription text
    When User enters email address as "tomas@gmail.com" on input
    And User clicks on arrow button
    Then User should view successful subscription message

  Scenario: TC011 - Verify Subscription in Cart page
    When User clicks on cart button
    Then User should scroll down and view subscription text
    When User enters email address as "tomas@gmail.com" on input
    And User clicks on arrow button
    Then User should view successful subscription message

  Scenario: TC012 - Add Products in Cart
    When User clicks on products button
    And User hovers over first product and clicks add to cart
    And User clicks on continue shopping button
    And User hovers over second product and clicks add to cart
    And User clicks on view cart button
    Then User should view the added products on cart
    And User should view the prices, quantity and total price

  Scenario: TC013 - Verify Product quantity in Cart
    When User clicks on view product for any product on home page
    Then User should view product name, category, price, availability, condition and brand
    When User increases product quantity to "4"
    And User clicks on add to cart button
    And User clicks on view cart button
    Then User should view quantity as "4"

  Scenario: TC014 - Place Order: Register while Checkout
    And User hovers over first product and clicks add to cart
    And User clicks on continue shopping button
    And User hovers over second product and clicks add to cart
    And User clicks on view cart button
    Then User should view the added products on cart
    When User clicks on checkout button
    And User clicks on register login button
    And User enters name as "Pedrito1231232" and email address as "m1l23ke@gmail.com"
    And User clicks on signup button
    Then User should view Enter account information text
    When User fills title, name, email, password, date of birth
    And User selects checkbox Sign up for our newsletter
    And User selects checkbox Receive special offers from our partners
    And User fills first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And User clicks on create account button
    Then User should view Account created text
    When User clicks on continue button
    Then User should view Logged in as username text
    When User clicks on cart button
    And User clicks proceed to checkout button
    Then User should view delivery address text
    When User enters an order comment
    And User clicks on place order
    And User enters card name as "Fabian Rodrigo"
    And User enters card number as "872374238772"
    And User enters CVC as "721"
    And User enters expiration month as "12"
    And User enters expiration year as "2028"
    And User clicks on confirm order
    Then User should view successful order message
    When User clicks on delete account button
    Then User should view Account deleted text

  Scenario: TC015: Place Order: Register before Checkout
    When User clicks on signup login button
    Then User should view New user sign up text
    When User enters name as "Rastafary92" and email address as "m1l23ke@gmail.com"
    And User clicks on signup button
    Then User should view Enter account information text
    When User fills title, name, email, password, date of birth
    And User selects checkbox Sign up for our newsletter
    And User selects checkbox Receive special offers from our partners
    And User fills first name, last name, company, address, address2, country, state, city, zipcode, mobile number
    And User clicks on create account button
    Then User should view Account created text
    When User clicks on continue button
    Then User should view Logged in as username text
    When User hovers over first product and clicks add to cart
    And User clicks on continue shopping button
    And User hovers over second product and clicks add to cart
    And User clicks on view cart button
    Then User should view the added products on cart
    When User clicks proceed to checkout button
    Then User should view delivery address text
    When User enters an order comment
    And User clicks on place order
    And User enters card name as "Fuchi fuchis"
    And User enters card number as "321312312"
    And User enters CVC as "121"
    And User enters expiration month as "10"
    And User enters expiration year as "2038"
    And User clicks on confirm order
    Then User should view successful order message
    When User clicks on delete account button
    Then User should view Account deleted text

  Scenario: TC016 - Place Order: Login before Checkout
    When User clicks on signup login button
    Then User should view user login text
    When User enters login mail address as "tomasvd1.garoe@gmail.com"
    And User enters login password as "Testing123"
    And User clicks on login button
    Then User should view Logged in as username text
    When User hovers over first product and clicks add to cart
    And User clicks on continue shopping button
    And User hovers over second product and clicks add to cart
    And User clicks on view cart button
    Then User should view the added products on cart
    When User clicks proceed to checkout button
    Then User should view delivery address text
    When User enters an order comment
    And User clicks on place order
    And User enters card name as "Fuchi fuchis"
    And User enters card number as "321312312"
    And User enters CVC as "121"
    And User enters expiration month as "10"
    And User enters expiration year as "2038"
    And User clicks on confirm order
    Then User should view successful order message
    When User clicks on delete account button
    Then User should view Account deleted text

  Scenario: TC017 - Remove Products From Cart
    When User hovers over first product and clicks add to cart
    And User clicks on continue shopping button
    And User hovers over second product and clicks add to cart
    And User clicks on view cart button
    Then User should view the added products on cart
    When User clicks on remove second product button
    Then User should not view second product name

  Scenario: TC018 - View Category products
    And User should view category text
    When User clicks on women category
    And User clicks on dress category
    Then User should view dress category text
    When User clicks on men category
    And User clicks on jeans category
    Then User should view jeans category text

  Scenario: TC019 - View & Cart Brand Products
    When User clicks on products button
    Then User should view brands text
    When User clicks on polo brand name
    Then User should view brand polo products text
    When User clicks on madame brand name
    Then User should view brand madame products text

  Scenario: TC020 - Test Case 20: Search Products and Verify Cart After Login
    When User clicks on products button
    Then User should view all products text
    When User enters "dress" on search input
    Then User should view searched products message





















