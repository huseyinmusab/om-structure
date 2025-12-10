package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TestContext context;
    //constructor for pico container
    //pico container scans this class,will check this constructor
    //and it will know that it needs to create one instance of this class
    //we dont need to create instance, pico container does it for us
    public MyHooks(TestContext context){
        this.context = context;
    }

    //1 - without thread local
    //@Before
    //public void before(){
    //     //driver = DriverFactory.initializeDriver();//no need a new instance because driver is static instance in DriverFactory
    //     //directly using the class to get initializeDriver()
    //     //2
    //    driver = DriverFactory.initializeDriver("chrome");
    //}
    //2-with thread local
    //@Before
    //public void before(Scenario scenario){
    //    System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
    //            "SCENARIO NAME: " + scenario.getName());
    //   driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    //}
    //thread.currentThread().threadId()==> in java 19
    //3 - with pico container
    @Before
    public void before(Scenario scenario){
        //setting the scenarioName object from testContext Class to here
        context.scenarioName = scenario.getName();
        System.out.println("DI: SCENARIO NAME: " + context.scenarioName);

        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }









    //1- without thread
    //@After
    //public void after(){
    //    driver.quit();
    //}
    // 2 - with thread
    @After
    public void after(Scenario scenario){
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
    //thread.currentThread().threadId()==> in java 19



}
