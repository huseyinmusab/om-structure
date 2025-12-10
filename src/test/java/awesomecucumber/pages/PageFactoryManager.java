package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {


    //to not creating object over and over in step definitions

    private static StorePage storePage;
    private static CardPage cardPage;
    private static CheckOutPage checkOutPage;

    public static StorePage getStorePage(WebDriver driver){
        return storePage == null ? new StorePage(driver) : storePage;//ternary
    }

    public static CardPage getCardPage(WebDriver driver){
        return cardPage == null ? new CardPage(driver) : cardPage;//ternary
    }

    public static CheckOutPage getCheckoutPage(WebDriver driver){
        return checkOutPage == null ? new CheckOutPage(driver) : checkOutPage;//ternary
    }
}
