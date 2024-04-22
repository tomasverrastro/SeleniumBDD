package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefinitions.Hooks;

import java.util.List;

public class ProductsPage extends Hooks {

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement msgAllProducts;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement lnkViewProduct;

    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement msgProductName;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement msgProductCategory;

    @FindBy(xpath = "//span[normalize-space()='Rs. 500']")
    WebElement msgProductPrice;

    @FindBy(xpath = "//p[contains(normalize-space(),'In Stock')]")
    WebElement msgProductAvailability;

    @FindBy(xpath = "//p[contains(normalize-space(),'New')]")
    WebElement msgProductCondition;

    @FindBy(xpath = "//p[contains(normalize-space(),'Polo')]")
    WebElement msgProductBrand;

    @FindBy(id = "search_product")
    WebElement txtSearchProduct;

    @FindBy(id = "submit_search")
    WebElement btnSubmitSearch;

    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement msgSearchedProducts;

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement listSearchedProducts;

    @FindBy(xpath = "(//div[@class='single-products'])[1]")
    WebElement elementFirstProduct;

    @FindBy(xpath = "(//div[@class='single-products'])[2]")
    WebElement elementSecondProduct;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[2]")
    WebElement btnAddToCartFirstProduct;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[4]")
    WebElement btnAddToCartSecondProduct;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement btnContinueShopping;

    @FindBy(xpath = "//p[@class='text-center']//a")
    WebElement btnViewCart;

    @FindBy(id = "quantity")
    WebElement txtQuantity;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//h2[normalize-space()='Brands']")
    WebElement msgBrands;

    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    WebElement btnPoloBrand;

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    WebElement btnMadameBrand;

    @FindBy(xpath = "//h2[normalize-space()='Brand - Polo Products']")
    WebElement msgPoloProducts;

    @FindBy(xpath = "//h2[normalize-space()='Brand - Madame Products']")
    WebElement msgMadameProducts;



    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isAllProductsMsgDisplayed(){
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

    public void clickViewProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkViewProduct));
        lnkViewProduct.click();
    }

    public boolean isProductNameMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductName));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductCategoryMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductCategory));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductPriceMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductPrice));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductConditionMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductCondition));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductBrandMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductBrand));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isProductAvailabilityMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgProductAvailability));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void enterProductName(String name){
        txtSearchProduct.sendKeys(name);
    }

    public void clickSearch(){
        btnSubmitSearch.click();
    }

    public boolean isSearchedProductsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgSearchedProducts));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isSearchedProductsListDisplayed(){
        List<WebElement> searchedProduct = listSearchedProducts.findElements(By.xpath("//div[@class='col-sm-4']"));

        for(WebElement element : searchedProduct){
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickAddToCartFirstProduct() throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementFirstProduct);
        actions.moveToElement(elementFirstProduct).perform();

        Thread.sleep(250);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartFirstProduct));
        btnAddToCartFirstProduct.click();
    }

    public void clickAddToCartSecondProduct() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(elementSecondProduct).perform();

        Thread.sleep(250);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartSecondProduct));
        btnAddToCartSecondProduct.click();
    }

    public void clickContinueShopping(){
        btnContinueShopping.click();
    }

    public void clickViewCart(){
        btnViewCart.click();
    }

    public void enterProductQuantity(String num){
        txtQuantity.clear();
        txtQuantity.sendKeys(num);
    }

    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public boolean isCorrectQuantityDisplayed(String num){
        boolean status;
        WebElement productQuantity = driver.findElement(By.xpath("//td[.//button[normalize-space()='" + num + "']]"));

        try {
            wait.until(ExpectedConditions.visibilityOf(productQuantity));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isBrandsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgBrands));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public void clickPoloBrand(){
        btnPoloBrand.click();
    }

    public void clickMadameBrand(){
        btnMadameBrand.click();
    }

    public boolean isPoloProductsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgPoloProducts));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }

    public boolean isMadameProductsMsgDisplayed(){
        boolean status;
        try {
            wait.until(ExpectedConditions.visibilityOf(msgMadameProducts));
            status = true;
        } catch (Exception e){
            status = false;
        }
        return status;
    }
}
