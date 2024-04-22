package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;

import static stepDefinitions.Hooks.driver;
import static stepDefinitions.Hooks.wait;

public class Steps extends BaseTest {

    //Setup Steps
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        homePage = new HomePage();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @Then("User should view home page")
    public void user_should_view_home_page() {
        //Close AdGuard extension tab
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        Assert.assertTrue(homePage.isHomePageDisplayed());

        productsPage = new ProductsPage();
        }


    //Login and Register Steps

    @When("User clicks on signup login button")
    public void userClicksOnSignupLoginButton() {
        homePage.clickSignUp();
        loginPage = new LoginPage();
    }

    @Then("User should view New user sign up text")
    public void userShouldViewNewUserSignUpText() {
        Assert.assertTrue(loginPage.isUserSignupMsgDisplayed());
    }

    @When("User enters name as {string} and email address as {string}")
    public void userEntersNameAsAndEmailAddressAs(String name, String email) {
        loginPage.enterSignUpName(name);
        loginPage.enterSignUpEmail(email);
    }

    @When("User clicks on signup button")
    public void user_clicks_on_signup_button() {
        loginPage.clickSignUp();
        signUpPage = new SignUpPage();
    }

    @Then("User should view Enter account information text")
    public void userShouldViewEnterAccountInformationText() {
        Assert.assertTrue(signUpPage.isMsgEnterInfoDisplayed());
    }

    @When("User fills title, name, email, password, date of birth")
    public void user_fills_title_name_email_password_date_of_birth() {
        signUpPage.selectGender();
        signUpPage.enterPassword("Mondongo123");
        signUpPage.selectDay("4");
        signUpPage.selectMonth("3");
        signUpPage.selectYear("1993");
    }

    @And("User selects checkbox Sign up for our newsletter")
    public void userSelectsCheckboxSignUpForOurNewsletter() {
        signUpPage.checkNewsLetter();
    }

    @And("User selects checkbox Receive special offers from our partners")
    public void userSelectsCheckboxReceiveSpecialOffersFromOurPartners() {
        signUpPage.checkOffers();
    }

    @When("User fills first name, last name, company, address, address2, country, state, city, zipcode, mobile number")
    public void user_fills_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        signUpPage.enterFirstName("Tomas");
        signUpPage.enterLastName("Florencio");
        signUpPage.enterCompany("Eldar");
        signUpPage.enterAddress1("Pinamar 123");
        signUpPage.enterAddress2("Robles 2");
        signUpPage.selectCountry("Australia");
        signUpPage.enterState("Cuchuflito");
        signUpPage.enterCity("Sidney");
        signUpPage.enterZipCode("41232");
        signUpPage.enterMobileNumber("227453642");
    }

    @When("User clicks on create account button")
    public void user_clicks_on_create_account_button() {
        signUpPage.clickCreateAccount();
    }

    @Then("User should view Account created text")
    public void userShouldViewAccountCreatedText() {
       Assert.assertTrue(signUpPage.isMsgAccountCreatedDisplayed());
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        signUpPage.clickContinue();
    }

    @Then("User should view Logged in as username text")
    public void userShouldViewLoggedInAsUsernameText() {
        Assert.assertTrue(homePage.isLoggedInAsDisplayed());
    }

    @When("User clicks on delete account button")
    public void user_clicks_on_delete_account_button() {
        homePage.clickDeleteAccount();
    }

    @Then("User should view Account deleted text")
    public void userShouldViewAccountDeletedText() {

        Assert.assertTrue(homePage.isAccountDeleted());
    }

    @Then("User should view user login text")
    public void userShouldViewUserLoginText() {
        Assert.assertTrue(loginPage.isUserLoginMsgDisplayed());
    }

    @When("User enters login mail address as {string}")
    public void userEntersLoginMailAddressAs(String email) {
        loginPage.enterLoginEmail(email);
    }

    @And("User enters login password as {string}")
    public void userEntersLoginPasswordAs(String pass) {
        loginPage.enterPassword(pass);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("User should view incorrect credentials message")
    public void userShouldViewIncorrectCredentialsMessage() {
        Assert.assertTrue(loginPage.isIncorrectCredentialsMsgDisplayed());
    }

    @When("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        homePage.clickLogout();
    }

    @Then("User should view existent email message")
    public void userShouldViewExistentEmailMessage() {
        Assert.assertTrue(loginPage.isExistentEmailMsgDisplayed());
    }

    //Contact Us Steps
    @When("User clicks on contact us button")
    public void userClicksOnContactUsButton() {
        homePage.clickContactUs();
        contactUsPage = new ContactUsPage();
    }


    @Then("User should view get in touch message")
    public void userShouldViewGetInTouchMessage() {
        Assert.assertTrue(contactUsPage.isGetInTouchMsgDisplayed());
    }

    @When("User enters name, email, subject and message")
    public void userEntersNameEmailSubjectAndMessage() {
        contactUsPage.enterName("Tomas");
        contactUsPage.enterEmail("tomasvd.garoe@gmail.com");
        contactUsPage.enterSubject("Greetings");
        contactUsPage.enterMessage("Hello friend");
    }

    @And("User uploads a file")
    public void userUploadsAFile() {
        contactUsPage.uploadFile();
    }

    @And("User clicks on submit button")
    public void userClicksOnSubmitButton() {
        contactUsPage.clickSubmit();
    }

    @And("User clicks OK on alert")
    public void userClicksOKOnAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @Then("User should view successful submit message")
    public void userShouldViewSuccessfulSubmitMessage() {
        Assert.assertTrue(contactUsPage.isSuccessfulSubmitMsgDisplayed());
    }

    @When("User clicks on home page")
    public void userClicksOnHomePage() {
        contactUsPage.clickHome();
    }


    //Test Cases Steps
    @When("User clicks on test cases button")
    public void userClicksOnTestCasesButton() {
        homePage.clickTestCases();
        testCasesPage = new TestCasesPage();
    }

    @Then("User should view test cases page")
    public void userShouldViewTestCasesPage() {
        Assert.assertTrue(testCasesPage.isTestCasesMsgDisplayed());
    }


    //Products Steps
    @When("User clicks on products button")
    public void userClicksOnProductsButton() {
        homePage.clickProducts();
    }

    @Then("User should view all products text")
    public void userShouldViewAllProductsText() {
        Assert.assertTrue(productsPage.isAllProductsMsgDisplayed());
    }

    @And("User should view all products list")
    public void userShouldViewAllProductsList() {
        Assert.assertTrue(productsPage.isProductListDisplayed());
    }

    @When("User clicks on view product")
    public void userClicksOnViewProduct() {
        productsPage.clickViewProduct();
    }

    @Then("User should view product name, category, price, availability, condition and brand")
    public void userShouldViewProductNameCategoryPriceAvailabilityConditionAndBrand() {
        Assert.assertTrue(productsPage.isProductNameMsgDisplayed());
        Assert.assertTrue(productsPage.isProductCategoryMsgDisplayed());
        Assert.assertTrue(productsPage.isProductPriceMsgDisplayed());
        Assert.assertTrue(productsPage.isProductAvailabilityMsgDisplayed());
        Assert.assertTrue(productsPage.isProductConditionMsgDisplayed());
        Assert.assertTrue(productsPage.isProductBrandMsgDisplayed());
    }

    @When("User enters {string} on search input")
    public void userEntersOnSearchInput(String product) {
        productsPage.enterProductName(product);
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        productsPage.clickSearch();
    }

    @Then("User should view searched products message")
    public void userShouldViewSearchedProductsMessage() {
        Assert.assertTrue(productsPage.isSearchedProductsMsgDisplayed());
    }

    @And("User should view all products related to te search")
    public void userShouldViewAllProductsRelatedToTeSearch() {
        Assert.assertTrue(productsPage.isSearchedProductsListDisplayed());
    }


    //Subscription steps
    @Then("User should scroll down and view subscription text")
    public void userShouldScrollDownAndViewSubscriptionText() {
        Assert.assertTrue(homePage.isSubscriptionMsgDisplayed());
    }

    @When("User enters email address as {string} on input")
    public void userEntersEmailAddressAsOnInput(String email) {
        homePage.enterEmailSubscribe(email);
    }

    @And("User clicks on arrow button")
    public void userClicksOnArrowButton() {
        homePage.clickSubscribe();
    }

    @Then("User should view successful subscription message")
    public void userShouldViewSuccessfulSubscriptionMessage() {
        Assert.assertTrue(homePage.isSubscribedAlertDisplayed());
    }


    //Cart Steps
    @When("User clicks on cart button")
    public void userClicksOnCartButton() {
        homePage.clickCart();
        cartPage = new CartPage();
    }

    @And("User hovers over first product and clicks add to cart")
    public void userHoversOverFirstProductAndClicksAddToCart() throws InterruptedException {
        productsPage.clickAddToCartFirstProduct();
    }

    @And("User clicks on continue shopping button")
    public void userClicksOnContinueShoppingButton() {
        productsPage.clickContinueShopping();
    }

    @And("User hovers over second product and clicks add to cart")
    public void userHoversOverSecondProductAndClicksAddToCart() throws InterruptedException {
        productsPage.clickAddToCartSecondProduct();
    }

    @And("User clicks on view cart button")
    public void userClicksOnViewCartButton() {
        productsPage.clickViewCart();
        cartPage = new CartPage();
    }

    @Then("User should view the added products on cart")
    public void userShouldViewTheAddedProductsOnCart() {
        Assert.assertTrue(cartPage.isElementProduct1Displayed());
        Assert.assertTrue(cartPage.isElementProduct2Displayed());
    }

    @And("User should view the prices, quantity and total price")
    public void userShouldViewThePricesQuantityAndTotalPrice() {
        Assert.assertTrue(cartPage.isMsgPrice1Displayed());
        Assert.assertTrue(cartPage.isMsgPrice2Displayed());
        Assert.assertTrue(cartPage.isMsgQuantity1Displayed());
        Assert.assertTrue(cartPage.isMsgQuantity2Displayed());
        Assert.assertTrue(cartPage.isMsgTotalPrice1Displayed());
        Assert.assertTrue(cartPage.isMsgTotalPrice2Displayed());
    }

    @When("User clicks on view product for any product on home page")
    public void userClicksOnViewProductForAnyProductOnHomePage() {
        homePage.clickViewProduct1();
    }

    @When("User increases product quantity to {string}")
    public void userIncreasesProductQuantityTo(String num) {
        productsPage.enterProductQuantity(num);
    }

    @And("User clicks on add to cart button")
    public void userClicksOnAddToCartButton() {
        productsPage.clickAddToCart();
    }

    @Then("User should view quantity as {string}")
    public void userShouldViewQuantityAs(String num) {
        Assert.assertTrue(productsPage.isCorrectQuantityDisplayed(num));
    }

    @When("User clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        cartPage.clickCheckout();
    }


    @And("User clicks on register login button")
    public void userClicksOnRegisterLoginButton() {
        cartPage.clickRegister();
        loginPage = new LoginPage();
    }

    @And("User clicks proceed to checkout button")
    public void userClicksProceedToCheckoutButton() {
        cartPage.clickProceedCheckout();
    }

    @Then("User should view delivery address text")
    public void userShouldViewDeliveryAddressText() {
        Assert.assertTrue(cartPage.isDeliveryAddressMsgDisplayed());
    }


    @When("User enters an order comment")
    public void userEntersAnOrderComment() {
        cartPage.enterComment("This is a nice comment");
    }


    @And("User clicks on place order")
    public void userClicksOnPlaceOrder() {
        cartPage.clickPlaceOrder();
    }


    @And("User enters card name as {string}")
    public void userEntersCardNameAs(String name) {
        cartPage.enterCardName(name);
    }

    @And("User enters card number as {string}")
    public void userEntersCardNumberAs(String num) {
        cartPage.enterCardNumber(num);
    }

    @And("User enters CVC as {string}")
    public void userEntersCVCAs(String cvc) {
        cartPage.enterCVC(cvc);
    }

    @And("User enters expiration month as {string}")
    public void userEntersExpirationMonthAs(String month) {
        cartPage.enterExpirationMonth(month);
    }

    @And("User enters expiration year as {string}")
    public void userEntersExpirationYearAs(String year) {
        cartPage.enterExpirationYear(year);
    }

    @And("User clicks on confirm order")
    public void userClicksOnConfirmOrder() {
        cartPage.clickConfirmOrder();
    }

    @Then("User should view successful order message")
    public void userShouldViewSuccessfulOrderMessage() {
        Assert.assertTrue(cartPage.isSuccessfulOrderMsgDisplayed());
    }

    @When("User clicks on remove second product button")
    public void userClicksOnRemoveSecondProductButton() {
        cartPage.clickClearProduct2();
    }

    @Then("User should not view second product name")
    public void userShouldNotViewSecondProductName() throws InterruptedException {
        Assert.assertTrue(cartPage.isSecondProductNameNotDisplayed());
    }

    //Category Test Cases
    @And("User should view category text")
    public void userShouldViewCategoryText() {
        Assert.assertTrue(homePage.isCategoryMsgDisplayed());
    }

    @When("User clicks on women category")
    public void userClicksOnWomenCategory() {
        homePage.clickWomenCategory();
    }

    @And("User clicks on dress category")
    public void userClicksOnDressCategory() {
        homePage.clickDressCategory();
    }

    @Then("User should view dress category text")
    public void userShouldViewDressCategoryText() {
        Assert.assertTrue(homePage.isDressCategoryMsgDisplayed());
    }

    @When("User clicks on men category")
    public void userClicksOnMenCategory() {
        homePage.clickMenCategory();
    }

    @And("User clicks on jeans category")
    public void userClicksOnJeansCategory() {
        homePage.clickJeansCategory();
    }

    @Then("User should view jeans category text")
    public void userShouldViewJeansCategoryText() {
        Assert.assertTrue(homePage.isJeansCategoryMsgDisplayed());
    }

    //Brand Test Cases
    @Then("User should view brands text")
    public void userShouldViewBrandsText() {
        Assert.assertTrue(productsPage.isBrandsMsgDisplayed());
    }

    @When("User clicks on polo brand name")
    public void userClicksOnPoloBrandName() {
        productsPage.clickPoloBrand();
    }

    @Then("User should view brand polo products text")
    public void userShouldViewBrandPoloProductsText() {
        Assert.assertTrue(productsPage.isPoloProductsMsgDisplayed());
    }

    @When("User clicks on madame brand name")
    public void userClicksOnMadameBrandName() {
        productsPage.clickMadameBrand();
    }

    @Then("User should view brand madame products text")
    public void userShouldViewBrandMadameProductsText() {
        Assert.assertTrue(productsPage.isMadameProductsMsgDisplayed());
    }
}
