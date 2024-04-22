package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.Hooks;

public class CartPage extends Hooks {

    @FindBy(id = "product-1")
    WebElement elementProduct1;

    @FindBy(id = "product-2")
    WebElement elementProduct2;

    @FindBy(xpath = "//td[@class='cart_price']//p[contains(text(),'Rs. 500')]")
    WebElement msgPrice1;

    @FindBy(xpath = "//td[@class='cart_price']//p[contains(text(),'Rs. 400')]")
    WebElement msgPrice2;

    @FindBy(xpath = "//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']")
    WebElement msgQuantity1;

    @FindBy(xpath = "//tr[@id='product-2']//button[@class='disabled'][normalize-space()='1']")
    WebElement msgQuantity2;

    @FindBy(xpath = "//p[@class='cart_total_price'][normalize-space()='Rs. 500']")
    WebElement msgTotalPrice1;

    @FindBy(xpath = "//p[@class='cart_total_price'][normalize-space()='Rs. 400']")
    WebElement msgTotalPrice2;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    WebElement btnRegister;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement btnProceedCheckout;

    @FindBy(xpath = "//h3[normalize-space()='Your delivery address']")
    WebElement msgDeliveryAddress;

    @FindBy(name = "message")
    WebElement txtComment;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement btnPlaceOrder;

    @FindBy(name = "name_on_card")
    WebElement txtCardName;

    @FindBy(name = "card_number")
    WebElement txtCardNumber;

    @FindBy(xpath = "//input[@placeholder='ex. 311']")
    WebElement txtCVC;

    @FindBy(xpath = "//input[@placeholder='MM']")
    WebElement txtExpirationMonth;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    WebElement txtExpirationYear;

    @FindBy(id = "submit")
    WebElement btnConfirmOrder;

    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    WebElement msgSuccessfulOrder;

    @FindBy(xpath = "//tr[@id='product-2']//a[@class='cart_quantity_delete']")
    WebElement btnClearProduct2;

    @FindBy(xpath = "//a[normalize-space()='Men Tshirt']")
    WebElement msgSecondProductName;









    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isElementProduct1Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(elementProduct1));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isElementProduct2Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(elementProduct2));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgPrice1Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgPrice1));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgPrice2Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgPrice2));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgQuantity1Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgQuantity1));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgQuantity2Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgQuantity2));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgTotalPrice1Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgTotalPrice1));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMsgTotalPrice2Displayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgTotalPrice2));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickCheckout(){
        btnCheckout.click();
    }

    public void clickRegister(){
        btnRegister.click();
    }

    public void clickProceedCheckout(){
        btnProceedCheckout.click();
    }

    public boolean isDeliveryAddressMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgDeliveryAddress));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void enterComment(String msg){
        txtComment.sendKeys(msg);
    }

    public void clickPlaceOrder(){
        btnPlaceOrder.click();
    }

    public void enterCardName(String name){
        txtCardName.sendKeys(name);
    }

    public void enterCardNumber(String num){
        txtCardNumber.sendKeys(num);
    }

    public void enterCVC(String CVC){
        txtCVC.sendKeys(CVC);
    }

    public void enterExpirationMonth(String month){
        txtExpirationMonth.sendKeys(month);
    }

    public void enterExpirationYear(String year){
        txtExpirationYear.sendKeys(year);
    }

    public void clickConfirmOrder(){
        btnConfirmOrder.click();
    }

    public boolean isSuccessfulOrderMsgDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(msgSuccessfulOrder));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void clickClearProduct2(){
        btnClearProduct2.click();
    }

    public boolean isSecondProductNameNotDisplayed() throws InterruptedException {
        boolean status;
        Thread.sleep(500);
        try {
            wait.until(ExpectedConditions.invisibilityOf(msgSecondProductName));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }
}
