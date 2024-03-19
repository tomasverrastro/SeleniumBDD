package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.Hooks;

public class ProductsPage extends Hooks {

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement msgAllProducts;





    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    public Boolean isAllProductsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgAllProducts));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductListDisplayed(){
        int i;
        boolean status = false;
        for(i = 2; i<=35; i++) {
            WebElement product = driver.findElement(By.xpath("(//div[@class='col-sm-4'])[" + i + "]"));
            if (product.isDisplayed()) {
                status = true;
            } else {
                status = false;
                break;
            }
        }
       return  status; 
    }
}
