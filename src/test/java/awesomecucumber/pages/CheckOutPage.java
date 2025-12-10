package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage{
    @FindBy(id = "billing_first_name") private WebElement billingFirstnameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingZipFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;//return this statement means it will return the same class , which means CheckOutPage Class
    }

    public CheckOutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckOutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckOutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage selectBillingState(String billingStateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();

        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();

/*        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(billingStateName);*/
        return this;
    }

    public CheckOutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckOutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }



    //1
//    public CheckOutPage setBillingDetails(String billingFirstName, String billingLastName,
//                                          String billingAddressOne,String billingCity,
//                                          String billingStateName,String billingZip,
//                                          String billingEmail) {
//
//        return enterBillingFirstName(billingFirstName)
//                .enterBillingLastName(billingLastName)
//                .enterBillingAddressLineOne(billingAddressOne)
//                .enterBillingCity(billingCity)
//                .selectBillingState(billingStateName)
//                .enterBillingZip(billingZip)
//                .enterBillingEmail(billingEmail);
//    }
    //2 - using billingDetails from BillingDetails class
    public CheckOutPage setBillingDetails(BillingDetails billingDetails) {

        return enterBillingFirstName(billingDetails.getBillingFirstName())
                .enterBillingLastName(billingDetails.getBillingLastName())
                .enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
                .enterBillingCity(billingDetails.getBillingCity())
                .selectBillingState(billingDetails.getBillingStateName())
                .enterBillingZip(billingDetails.getBillingZip())
                .enterBillingEmail(billingDetails.getBillingEmail());
    }







    public CheckOutPage placeOrder(){
        //waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }




    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }






}
