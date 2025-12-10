package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;

    //constructor
    public StorePage(WebDriver driver) {
        super(driver);//passes this driver to the constructor of BasePage
    }


    public void addToCart(String productName) {

        By addToCartButton = By.cssSelector("[aria-label='Add “" + productName + "” to your cart']");
        System.out.println(addToCartButton);
        //By addToCartButton = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();

    }

}
