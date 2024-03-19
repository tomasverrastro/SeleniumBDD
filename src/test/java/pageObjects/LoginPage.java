package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.BaseTest;
import stepDefinitions.Hooks;


public class LoginPage extends Hooks {

    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    WebElement msgUserSignUp;

    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement msgUserLogin;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement msgIncorrectCredentials;

    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement msgExistentEmail;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement txtLoginEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPasswordLogin;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txtSignUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement txtSignUpEmail;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement btnSignUp;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean isUserSignupMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgUserSignUp));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public Boolean isUserLoginMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgUserLogin));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public Boolean isIncorrectCredentialsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgIncorrectCredentials));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public Boolean isExistentEmailMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgExistentEmail));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void enterLoginEmail(String email){
        txtLoginEmail.sendKeys(email);
    }

    public void enterPassword(String pass){
        txtPasswordLogin.sendKeys(pass);
    }

    public void enterSignUpName(String name){
        txtSignUpName.sendKeys(name);
    }

    public void enterSignUpEmail(String email){
        txtSignUpEmail.sendKeys(email);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickSignUp(){
        btnSignUp.click();
    }
}
