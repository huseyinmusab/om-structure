package awesomecucumber.stepdefs;

import awesomecucumber.apis.CardApi;
import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private final WebDriver driver;
    private final TestContext context; // to use api





    public StoreStepDefinitions(TestContext context){
        this.driver = context.driver;
        this.context = context;

    }



    @Given("I am on the Store page")
    public void i_am_on_the_store_page() {
        //1
        // driver = new ChromeDriver();
        // driver.manage().window().maximize();

        //2
        //driver = DriverFactory.getDriver();
        //System.out.println("DRIVER: "+driver);
        //driver.get("https://askomdch.com/");

        //3
        //driver = DriverFactory.getDriver();
        //StorePage storePage = new StorePage(driver);//object can be also created like this
        //new StorePage(driver).load("https://askomdch.com/");//creating a new object from StorePage and passing the driver into
        //StorPage extends to BasePage, any method is available in BasePage is also available for StorePage

        //3-1 ===> with pico container - driver object injection from TestContext
        // we dont need to use ==> driver = DriverFactory.getDriver(); anymore



        //4 -url for config
        //new StorePage(driver).load(ConfigLoader.getInstance().getBaseUrl() + "/store");

        //5-after putting into the BasePage
        //new StorePage(driver).load("/store");//put it in BasePage

        //6-with enum
        new StorePage(driver).load(EndPoint.STORE.url);


    }




    //    @When("I add a {string} to the cart")
//    public void i_add_a_to_the_cart(String productName) throws InterruptedException {
// //1
// //Thread.sleep(5000);
// //By addToCart = By.cssSelector("[aria-label='Add “" + productName + "” to your cart']");
// //By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
// //driver.findElement(addToCart).click();
// // //By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
// // //driver.findElement(By.cssSelector("a[aria-label=\"Add “Blue Shoes” to your cart\"]")).click();
// // Thread.sleep(3000);
// //  By viewCartLink = By.cssSelector("a[title=\"View cart\"]");
// //  driver.findElement(viewCartLink).click();
//
//        //2
//        new StorePage(driver).addToCart(productName);
//    }
    //2
//2 -adding product {product} Product product
//after CustomParameterType under customtype package and Product Class under domainobject
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
//1
//        Thread.sleep(5000);
//        //By addToCart = By.cssSelector("[aria-label='Add “" + productName + "” to your cart']");
//        By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
//        driver.findElement(addToCart).click();
//        //By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
//        //driver.findElement(By.cssSelector("a[aria-label=\"Add “Blue Shoes” to your cart\"]")).click();
//        Thread.sleep(3000);
//        By viewCartLink = By.cssSelector("a[title=\"View cart\"]");
//        driver.findElement(viewCartLink).click();

        //2
        new StorePage(driver).addToCart(product.getName());
    }


    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        //1
//        Thread.sleep(2000);
//        //By addToCart = By.cssSelector("[aria-label='Add “" + productName + "” to your cart']");
//        By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
//        driver.findElement(addToCart).click();
//        //By addToCart = By.cssSelector("[aria-label=\"Add “Blue Shoes” to your cart\"]");
//        //driver.findElement(By.cssSelector("a[aria-label=\"Add “Blue Shoes” to your cart\"]")).click();
//        //2
//        new StorePage(driver).addToCart("Blue Shoes");
//        Thread.sleep(2000);
//        By viewCartLink = By.cssSelector("a[title=\"View cart\"]");
//        driver.findElement(viewCartLink).click();

        //2
        //new StorePage(driver).addToCart("Blue Shoes");//for now hard coded

        //3 - By the api
        CardApi cardApi = new CardApi(context.cookies.getCookies());
        //1215 +> product_id for Blue Shoes
        cardApi.addToCard(1215, 1);
        context.cookies.setCookies(cardApi.getCookies());

        // we are doing this in case if there is another api call that mighty be needing this cookies
        //before we inject cookies to the browser, we need to make sure we are onm the our application
        //It does not matter which page we are on, it matters we are on application
        //otherwise we get an error
        //inject the cookies to browser
        context.cookies.injectCookiesToBrowser(context.driver);

    }

}
