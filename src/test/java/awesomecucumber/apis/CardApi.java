package awesomecucumber.apis;

import awesomecucumber.constants.EndPoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class CardApi {
    private Cookies cookies;

    public CardApi(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    public Response addToCard(int productId, int quantity){
        //set the header
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        //set the form parameters
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        //if the user is not logged in we send here empty cookies
        Response response = ApiRequest.post(EndPoint.ADD_TO_CART.url, headers, formParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to add product" + productId + " to the cart" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
