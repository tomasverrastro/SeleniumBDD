package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement msgSubscription;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement lnkLogout;

    @FindBy(id = "susbscribe_email")
    WebElement txtEmailSubscribe;

    @FindBy(id = "subscribe")
    WebElement btnSubscribe;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement alertSuccessfullySubscribed;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement lnkViewProduct1;

    @FindBy(xpath = "//h2[normalize-space()='Category']")
    WebElement msgCategory;

    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement btnWomenCategory;

    @FindBy(xpath = "//a[normalize-space()='Men']")
    WebElement btnMenCategory;

    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    WebElement btnDressCategory;

    @FindBy(xpath = "//a[normalize-space()='Jeans']")
    WebElement btnJeansCategory;

    @FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
    WebElement msgDressCategory;

    @FindBy(xpath = "//h2[normalize-space()='Men - Jeans Products']")
    WebElement msgJeansCategory;



    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(imgGirl));
            return true;
        } catch (Exception e){
            return false;
        }
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

    public boolean isLoggedInAsDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgLoggedInAs));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isAccountDeleted(){
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
        lnkLogout.click();
    }

    public boolean isSubscriptionMsgDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", msgSubscription);

        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgSubscription));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void enterEmailSubscribe(String email){
        txtEmailSubscribe.sendKeys(email);
    }

    public void clickSubscribe(){
        btnSubscribe.click();
    }

    public boolean isSubscribedAlertDisplayed() {
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(alertSuccessfullySubscribed));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickViewProduct1(){
        lnkViewProduct1.click();
    }

    public boolean isCategoryMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgCategory));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickWomenCategory(){
        btnWomenCategory.click();
    }

    public void clickMenCategory(){
        btnMenCategory.click();
    }

    public void clickDressCategory(){
        btnDressCategory.click();
    }

    public void clickJeansCategory(){
        btnJeansCategory.click();
    }

    public boolean isDressCategoryMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgDressCategory));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isJeansCategoryMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgJeansCategory));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }
}
