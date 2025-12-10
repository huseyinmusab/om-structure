package awesomecucumber.context;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {

    //1
    public String scenarioName;
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;

    //constructor
    public TestContext() {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());// setting cookies in our domain object

    }

    //if it is a guest user cookies object will be empty
    //we can send empty cookies but we can not send null cookies



}
