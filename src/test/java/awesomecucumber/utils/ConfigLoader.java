package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    //1- without env values
    //private constructor => only this class instantiate itself, no other outside of this class can not instantiate this class
    //instantiate= orneklendirme, somutlastirma
    //singleton pattern
    //private ConfigLoader(){
    //        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    //}

    //2- with env values
    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            default -> throw new IllegalStateException("INVALID ENV: " + env);
        }
        //**** how to run in terminal with different env in by maven commands ****
        //mvn clean test -Denv=STAGE
        //mvn clean test -Denv=PROD
    }






    //checks configLoader variable is null or not, if it is null, creates
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }


    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }

    /*
        It means:
    First, you are calling the static method getInstance() to either create or retrieve the already existing single instance of ConfigLoader.
    Second, you're immediately calling the getBaseUrl() method on that instance to fetch the baseUrl value.
    Why ConfigLoader.getInstance().getBaseUrl() Works This Way:
    Singleton Design: Since ConfigLoader follows the Singleton pattern,
    you are guaranteed that only one instance of the ConfigLoader class exists in your application.
    The getInstance() method ensures that you don't need to create a new ConfigLoader object each time you need to access it.
    Method Chaining: This approach allows you to call getBaseUrl() on the instance of ConfigLoader directly
    after getting the instance via getInstance().
    This is possible because getInstance() returns an instance of ConfigLoader,
    which allows you to call any non-static method of that class (like getBaseUrl()) on it.

    How It Fits Into Your Code:
    ConfigLoader.getInstance(): ensures that you're only ever working with a single instance of ConfigLoader.
    It's a global access point to that single instance.
    .getBaseUrl(): retrieves a specific property (baseUrl) from the configuration file.

    Why This Is Beneficial:
    Efficiency: You are not repeatedly creating a new instance of ConfigLoader, saving memory and improving performance.
    Consistency: You ensure that the same configuration (with the same loaded properties) is used across your entire application or test suite.
    Code Simplicity: This approach avoids redundant code. You're using a single method (getInstance()) to ensure you're always working with the same configuration object.


     */

}
