package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.Hooks;

public class ContactUsPage extends Hooks {

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement msgGetInTouch;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement msgSuccessfulSubmit;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txtName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement txtSubject;

    @FindBy(id = "//textarea[@id='message']")
    WebElement txtMessage;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement fileUpload;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//a[.//span[normalize-space()='Home']]")
    WebElement btnHome;

    public ContactUsPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean isGetInTouchMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgGetInTouch));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public Boolean isSuccessfulSubmitMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgSuccessfulSubmit));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void enterName(String name){
        txtName.sendKeys(name);
    }

    public void enterEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void enterSubject(String sub){
        txtSubject.sendKeys(sub);
    }

    public void enterMessage(String msg){
        txtMessage.sendKeys(msg);
    }

    public void uploadFile(){
        fileUpload.sendKeys("message.txt");
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void clickHome(){
        btnHome.click();
    }
}
