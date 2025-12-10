package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardPage extends BasePage{

    @FindBy(css = "td[class='product-name'] a") private WebElement productNameFld;
    @FindBy(css = "input[type=\"number\"]") private WebElement productQuantityFld;
    @FindBy(css = ".checkout-button") private WebElement proceedToCheckoutBtn;


    //constructor
    public CardPage(WebDriver driver) {
        super(driver); //it helps us to call constructor in parent class (BasePage)
                       // => by this we can reach to methods and variables from parent class
    }




    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }


    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityFld)).getAttribute("value"));
    }


    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }





}
