package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
//1- without thread local
//    private static WebDriver driver;
//    //when it is not used static, driver instance is set to null
//    //in hooks and step defs we need to create deriver instance(object) again and again for every usage
//    //to avoid this, use static keyword and static method in this class
//    //to check: delete static keyword from here and check the driver instances where they are used in framework
//
//    // when we dont use static keyword here getDriver() method turns non-static, then we need to create a new instance
//
//    //1
//    //public static WebDriver initializeDriver(){
//    //
//    //    driver = new ChromeDriver();
//    //    driver.manage().window().maximize();
//    //    return driver;
//    //}
//
//    //not a specific reason to create another method like this
//    //public static WebDriver getDriver(){
//    //    return driver;
//    //}
//
//    //2
//    public static WebDriver initializeDriver(String browser){
//        switch (browser) {
//            case "chrome" -> {
//                driver = new ChromeDriver();
//            }
//            case "firefox" -> {
//                driver = new FirefoxDriver();
//            }
//            case "safari" -> {
//                driver = new SafariDriver();
//            }
//            case "edge" ->{
//                driver = new EdgeDriver();
//            }
//
//            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
//        }
//        driver.manage().window().maximize();
//        return driver;
//    }
//    public static WebDriver getDriver(){
//        return driver;
//    }


    //2- with thread local
    //private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //public static WebDriver initializeDriver(String browser){
    //    WebDriver driver;
    //    switch (browser) {
    //       case "chrome" -> {
    //            driver = new ChromeDriver();
    //        }
    //        case "firefox" -> {
    //            driver = new FirefoxDriver();
    //        }
    //       case "safari" -> {
    //            driver = new SafariDriver();
    //        }
    //        case "edge" ->{
    //            driver = new EdgeDriver();
    //        }
    //        default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
    //   }
    //    driver.manage().window().maximize();
    //    DriverFactory.driver.set(driver);
    //    return driver;
    //}
    //ublic static WebDriver getDriver(){
    //    return driver.get();
    //}

    //pico container and dependency injection:
    /*
    advantages of using the dependency injection container.
    The first one is it helps us avoid using static keyword,
    And we can eliminate the threadlocal as well.
    The second advantage is our step definition class will not be tightly coupled.
    Basically right now, since we have only one step definition class, if we want to share this state
    between these steps, we can create instance variables over here and we can use those to share the state
    But with this, then we will not be able to split this step.Basically right now,
    since we have only one step definition class, if we want to share this state
    between these steps, we can create instance variables over here and we can use those to share the state
    between the steps.But with this, then we will not be able to split this step definition class.
    Right now this class is very small.We are only automated two scenarios.
    Once we automate 20 scenarios, 50 scenarios, this class is going to become bulky and we will have
    to split it into smaller classes.Then in that case we may move the steps from this same scenario into different classes.
    So in that situation, we may want to share the state between these steps which are located into different classes.
    So in that case, we need the dependency injection container.Without that, we will have to resort to
    using static keyword and then threadlocal and all sorts of tricky things.
    With the dependency injection container, it becomes very easy.We don't have to manage anything.
    So that's about the concept of dependency injection container and the cucumbers pickle container.
     */

    //3- with pico container - driver object injection
    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }



}
