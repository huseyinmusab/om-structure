package awesomecucumber.domainobjects;

public class Product {
    private String name;

    //constructor
    public Product(String name) {
        this.name = name;
    }

    //getter - setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
