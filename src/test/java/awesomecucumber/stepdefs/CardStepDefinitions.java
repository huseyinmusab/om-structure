package awesomecucumber.stepdefs;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CardPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CardStepDefinitions {
    //private final WebDriver driver;//==> after using driver in PageFactoryManager Class , no need to use anymore
    private final CardPage cardPage;

    public CardStepDefinitions(TestContext context){
        //driver = context.driver; //==> after using driver in PageFactoryManager Class , no need to use anymore,
                                   //you can alos do it for other classes
        cardPage = PageFactoryManager.getCardPage(context.driver);
    }

    //1
//    @Then("I should see {int} {string} in the cart")
//    public void i_should_see_in_the_cart(Integer quantity, String productName) {
//
//        //1
//        //By productNameField = By.cssSelector("[data-title=\"Product\"]");
//        //String actualProductName = driver.findElement(productNameField).getText();
//        //System.out.println("actualProductName :"+actualProductName);
//
//        //By productQuantityField = By.cssSelector("input[type=\"number\"]");
//        //String actualQuantity = driver.findElement(productQuantityField).getAttribute("value");
//        //System.out.println("actualQuantity: "+actualQuantity);
//
//
//        //int actualQuantityAsInteger = 0;
//        //if (actualQuantity != null) {
//        //    actualQuantityAsInteger = Integer.parseInt(actualQuantity);
//        //}
//        //System.out.println(actualQuantityAsInteger);
//        //Assert.assertEquals(productName, actualProductName);
//        //Assert.assertEquals(quantity, actualQuantityAsInteger);
//
//        //2
//        CardPage cardPage = new CardPage(driver);
//        Assert.assertEquals(productName,cardPage.getProductName() );
//        Assert.assertEquals(quantity, cardPage.getProductQuantity());
//
//
//    }
    //2 -adding product {product} Product product
    //after CustomParameterType under customtype package and Product Class under domainobject
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {

        //1
        //By productNameField = By.cssSelector("[data-title=\"Product\"]");
        //String actualProductName = driver.findElement(productNameField).getText();
        //System.out.println("actualProductName :"+actualProductName);

        //By productQuantityField = By.cssSelector("input[type=\"number\"]");
        //String actualQuantity = driver.findElement(productQuantityField).getAttribute("value");
        //System.out.println("actualQuantity: "+actualQuantity);


        //int actualQuantityAsInteger = 0;
        //if (actualQuantity != null) {
        //    actualQuantityAsInteger = Integer.parseInt(actualQuantity);
        //}
        //System.out.println(actualQuantityAsInteger);
        //Assert.assertEquals(productName, actualProductName);
        //Assert.assertEquals(quantity, actualQuantityAsInteger);

        //2
        //CardPage cardPage = new CardPage(driver);
        //Assert.assertEquals(product.getName(), cardPage.getProductName());
        //Assert.assertEquals(quantity, cardPage.getProductQuantity());

        //3 - by not creating object here, cardPage object is created in PageFactoryManager
        Assert.assertEquals(product.getName(), cardPage.getProductName());
        Assert.assertEquals(quantity, cardPage.getProductQuantity());



    }

    //@Given("I am on the Checkout page")
    //public void i_am_on_the_checkout_page() {
        //1
        //By proceedCheckOutButton = By.className("checkout-button");
        //driver.findElement(proceedCheckOutButton).click();
        //2
        //new CardPage(driver).checkout();

        //3 - by not creating object here, cardPage object is created in PageFactoryManager
        //cardPage.checkout();

        //4 -  after api integration ne need to use this and put this into the CheckoutPageStepDefinitions
        //cardPage.checkout();

    //}






}
