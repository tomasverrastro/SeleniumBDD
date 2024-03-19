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
    When User enters login mail address as "tomasvd.garoe@gmail.com"
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
    When User enters login mail address as "tomasvd.garoe@gmail.com"
    And User enters login password as "Testing123"
    And User clicks on login button
    Then User should view Logged in as username text
    When User clicks on logout button
    Then User should view user login text

  Scenario: TC05 - Register User with existing email
    When User clicks on signup login button
    Then User should view New user sign up text
    When User enters name as "Pochoclito" and email address as "tomasvd.garoe@gmail.com"
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








