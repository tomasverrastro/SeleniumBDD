package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.BaseTest;
import stepDefinitions.Hooks;

public class HomePage extends Hooks {

    @FindBy(xpath = "//img[@src='/static/images/home/girl2.jpg']")
    WebElement imgGirl;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement lnkProducts;

    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement lnkCart;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement lnkSignUp;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement lnkTestCases;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement lnkContactUs;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement btnDeleteAccount;

    @FindBy(partialLinkText = "Logged in")
    WebElement msgLoggedInAs;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    WebElement msgAccountDeleted;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement lnkLogout;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(imgGirl));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickProducts(){
        lnkProducts.click();
    }

    public void clickCart(){
        lnkCart.click();
    }

    public void clickSignUp(){
        lnkSignUp.click();
    }

    public void clickTestCases(){
        lnkTestCases.click();
    }

    public void clickContactUs(){
        lnkContactUs.click();
    }

    public void clickDeleteAccount(){
        btnDeleteAccount.click();
    }

    public Boolean isLoggedInAsDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgLoggedInAs));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public Boolean isAccountDeleted(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgAccountDeleted));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickLogout(){
        btnDeleteAccount.click();
    }
}
