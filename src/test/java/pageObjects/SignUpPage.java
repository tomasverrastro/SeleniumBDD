package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.BaseTest;
import stepDefinitions.Hooks;

public class SignUpPage extends Hooks {

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    WebElement msgEnterInfo;

    @FindBy(xpath = "//input[@value='Mr']")
    WebElement radMaleGender;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "days")
    WebElement selectDays;

    @FindBy(id = "months")
    WebElement selectMonths;

    @FindBy(id = "years")
    WebElement selectYears;

    @FindBy(id = "newsletter")
    WebElement boxNewsLetter;

    @FindBy(id = "optin")
    WebElement boxOffers;

    @FindBy(id = "first_name")
    WebElement txtFirstName;

    @FindBy(id = "last_name")
    WebElement txtLastName;

    @FindBy(id = "company")
    WebElement txtCompany;

    @FindBy(id = "address1")
    WebElement txtAddress1;

    @FindBy(id = "address2")
    WebElement txtAddress2;

    @FindBy(id = "country")
    WebElement selectCountry;

    @FindBy(id = "state")
    WebElement txtState;

    @FindBy(id = "city")
    WebElement txtCity;

    @FindBy(id = "zipcode")
    WebElement txtZipCode;

    @FindBy(id = "mobile_number")
    WebElement txtMobileNumber;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement btnCreateAccount;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    WebElement msgAccountCreated;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement btnContinue;

    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean isMsgEnterInfoDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgEnterInfo));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void selectGender(){
        radMaleGender.click();
    }

    public void enterPassword(String pass){
        txtPassword.sendKeys(pass);
    }

    public void checkNewsLetter(){
        boxNewsLetter.click();
    }

    public void checkOffers(){
        boxOffers.click();
    }

    public void selectYear(String value){
        Select select = new Select(selectYears);
        select.selectByValue(value);
    }

    public void selectMonth(String value){
        Select select = new Select(selectMonths);
        select.selectByValue(value);
    }

    public void selectDay(String value){
        Select select = new Select(selectDays);
        select.selectByValue(value);
    }

    public void enterFirstName(String name){
        txtFirstName.sendKeys(name);
    }

    public void enterLastName(String name){
        txtLastName.sendKeys(name);
    }

    public void enterCompany(String company){
        txtCompany.sendKeys(company);
    }

    public void enterAddress1(String address){
        txtAddress1.sendKeys(address);
    }

    public void enterAddress2(String address){
        txtAddress2.sendKeys(address);
    }

    public void selectCountry(String value){
        Select select = new Select(selectCountry);
        select.selectByValue(value);
    }

    public void enterState(String state){
        txtState.sendKeys(state);
    }

    public void enterCity(String city){
        txtCity.sendKeys(city);
    }

    public void enterZipCode(String code){
        txtZipCode.sendKeys(code);
    }

    public void enterMobileNumber(String num){
        txtMobileNumber.sendKeys(num);
    }

    public void clickCreateAccount(){
        btnCreateAccount.click();
    }

    public Boolean isMsgAccountCreatedDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgAccountCreated));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }
    public void clickContinue(){
        btnContinue.click();
    }
}
