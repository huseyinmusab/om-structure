package awesomecucumber.stepdefs;

import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.CardPage;
import awesomecucumber.pages.CheckOutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutStepDefinitions {

    private final WebDriver driver;
    private final TestContext context;


    public CheckOutStepDefinitions(TestContext context){
        this.context = context;
        driver = context.driver;;
        //checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }





    @When("I provide billing details")
    public void i_provide_billing_details() throws InterruptedException {
//List<Map<String, String>>billingDetails not anymore as a parameter after i create "My billing details are"
//1-seperated method
//        By firstNameField = By.id("billing_first_name");
//        By lastNameField = By.id("billing_last_name");
//        By addressField = By.id("billing_address_1");
//        By cityField = By.id("billing_city");
//        By stateDropDown = By.id("billing_state");
//        By postcodeField = By.id("billing_postcode");
//        By emailField = By.id("billing_email");
//        //billingDetails==> List, has key-value
//        //get(0)==> gets the first row, List has only one row here
//        //get("firstname")==> gets the key, so its value is demo
//        driver.findElement(firstNameField).clear();
//        driver.findElement(firstNameField).sendKeys(billingDetails.get(0).get("firstname"));
//        driver.findElement(lastNameField).clear();
//        driver.findElement(lastNameField).sendKeys(billingDetails.get(0).get("lastname"));
//        driver.findElement(addressField).clear();
//        driver.findElement(addressField).sendKeys(billingDetails.get(0).get("address_line1"));
//        driver.findElement(cityField).clear();
//        driver.findElement(cityField).sendKeys(billingDetails.get(0).get("city"));
//        //dropdown
//        Select select = new Select(driver.findElement(stateDropDown));
//        select.selectByVisibleText(billingDetails.get(0).get("state"));
//        Thread.sleep(2000);
//        driver.findElement(postcodeField).clear();
//        driver.findElement(postcodeField).sendKeys(billingDetails.get(0).get("zip"));
//        driver.findElement(emailField).clear();
//        driver.findElement(emailField).sendKeys(billingDetails.get(0).get("email"));
//        Thread.sleep(3000);
        //2
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        //checkOutPage.enterBillingFirstName(billingDetails.get(0).get("firstname"));
        //2.way-common method
//        checkOutPage.setBillingDetails(billingDetails.get(0).get("firstname"),
//                billingDetails.get(0).get("lastname"),
//                billingDetails.get(0).get("address_line1"),
//                billingDetails.get(0).get("city"),
//                billingDetails.get(0).get("state"),
//                billingDetails.get(0).get("zip"),
//                billingDetails.get(0).get("email"));
//    }
        //3
        //after after i create "My billing details are"
//            checkOutPage.setBillingDetails(billingFirstName,
//                billingLastName,
//                billingAddressOne,
//                billingCity,
//                billingStateName,
//                billingZip,
//                billingEmail);

        //4
        //after creating billingDetails in this class and setting billingDetails in @And("My billing details are")
        //checkOutPage.setBillingDetails(billingDetails);

        //5- with pico container
        checkOutPage.setBillingDetails(context.billingDetails);
    }


    @When("I place an order")
    public void i_place_an_order() throws InterruptedException {
//1
//        By placeOrderButton = By.id("place_order");
//        driver.findElement(placeOrderButton).click();
//        Thread.sleep(3000);
        //2
        Thread.sleep(3000);
        new CheckOutPage(driver).placeOrder();

    }


    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {

        //1
        //By noticeText = By.cssSelector(".woocommerce-notice");
        //String actualNoticeText = driver.findElement(noticeText).getText();
        //System.out.println("noticeText: "+noticeText);
        String expectedNoticeText = "Thank you. Your order has been received.";

        //2
        //Assert.assertEquals(actualNoticeText,expectedNoticeText,"not correct");
        Assert.assertEquals(new CheckOutPage(driver).getNotice(), expectedNoticeText,"not correct");

    }



    @Given("I am on the Checkout page")
    public void i_am_on_the_checkout_page() {

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.load(EndPoint.CHECKOUT.url);

    }






}
