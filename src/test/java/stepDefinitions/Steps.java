package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }


    //Login and Register Steps

    @When("User clicks on signup login button")
    public void userClicksOnSignupLoginButton() {
        homePage.clickSignUp();
    }

    @Then("User should view New user sign up text")
    public void userShouldViewNewUserSignUpText() {
        loginPage = new LoginPage();
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
    }

    @Then("User should view Enter account information text")
    public void userShouldViewEnterAccountInformationText() {
        signUpPage = new SignUpPage();
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
        contactUsPage.enterMessage("Hello, this is a test.");
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
}
