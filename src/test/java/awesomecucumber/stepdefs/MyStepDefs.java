package awesomecucumber.stepdefs;


import awesomecucumber.constants.EndPoint;
import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import awesomecucumber.pages.CardPage;
import awesomecucumber.pages.CheckOutPage;
import awesomecucumber.pages.StorePage;

public class MyStepDefs {

    //1
    //private WebDriver driver;
    // variable is limited in this class scope

    //2
    //private static WebDriver driver;
    //when we add static, driver object initialized at  @Given("I am on the Store page")
    // and is not null for the second step defs-->@Given("I am a guest customer")
    //if i want to run BOTH features

    //but if i run only the second step, it makes a conflict because it is not initialized at second step
    // thats why we need ThreadLocal,that can be used from Java to maintain different copies of the driver
    //instance for each thread
    //static usage causes also problems for paralell executions

    //3
    //After i set the driver instance in Driver Factory Class with static keyword,no need to use here static anymore
    private final WebDriver driver;



    //constructor from TestContext under context package for pico container
    public MyStepDefs(TestContext context){
        System.out.println("STEP DEF: SCENARIO NAME: "+ context.scenarioName);
        driver = context.driver;//poco container will make sure this driver is specific to the scenario
        //so, it does not cause any conflict for parallel execution
    }







}