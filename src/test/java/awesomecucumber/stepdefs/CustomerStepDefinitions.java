package awesomecucumber.stepdefs;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {

    private final WebDriver driver;
    private final TestContext context;

    //1
//    private  String billingFirstName;
//    private  String billingLastName;
//    private  String billingAddressOne;
//    private  String billingCity;
//    private  String billingStateName;
//    private  String billingZip;
//    private  String billingEmail;
    //moved this variables to the BillingDetails Class under the domainobject package
    //so , we go to BillingDetails and reaching them by using billingDetails variable
    //2
    //private final BillingDetails billingDetails;

    public CustomerStepDefinitions(TestContext context){
        this.context = context;
        driver = context.driver;

    }


    //1
//    @And("My billing details are")
//    public void myBillingDetailsAre(List<Map<String, String>>billingDetails) {
//        billingFirstName = billingDetails.get(0).get("firstname");
//        billingLastName = billingDetails.get(0).get("lastname");
//        billingAddressOne = billingDetails.get(0).get("address_line1");
//        billingCity = billingDetails.get(0).get("city");
//        billingStateName = billingDetails.get(0).get("state");
//        billingZip = billingDetails.get(0).get("zip");
//        billingEmail = billingDetails.get(0).get(("email"));
//
//    }
    //2 - after creating BillingDetails class under domainobject package and billingDetails variable
    @And("My billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        //this.billingDetails= billingDetails;
        //by this billingDetails object is set
        //2
        context.billingDetails = billingDetails;

    }



    @Given("I am a guest customer")
    public void i_am_a_guest_customer() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver = DriverFactory.getDriver();
//        driver.get("https://askomdch.com/");
        //2
        //driver = DriverFactory.getDriver();
        //new StorePage(driver).load("https://askomdch.com/");

        //2-2 ===> with pico container - driver object injection from TestContext
        // we dont need to use ==> driver = DriverFactory.getDriver(); anymore

        //3
        //new StorePage(driver).load(ConfigLoader.getInstance().getBaseUrl());//put it in BasePage
        //4-after putting into the BasePage
        //new StorePage(driver).load("/store");//put it in BasePage

        //5-with a constant value (enum or constant)
        new StorePage(driver).load(MyConstants.STORE);


    }



}
