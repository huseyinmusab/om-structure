package awesomecucumber.customtype;

import awesomecucumber.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*") //means matching everything
    public Product product(String name){
        //return new Product(name);
          return new Product(name.replace("\"", ""));//removing "" here
    }
}
