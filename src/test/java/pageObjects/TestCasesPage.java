package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.Hooks;


public class TestCasesPage extends Hooks {

    @FindBy(xpath = "//b[normalize-space()='Test Cases']")
    WebElement msgTestCases;


    public TestCasesPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean isTestCasesMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgTestCases));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }
}
