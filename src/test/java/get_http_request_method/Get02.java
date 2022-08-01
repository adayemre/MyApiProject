package get_http_request_method;
import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02 extends HerokuAppBaseUrl {
    /*
            Given https://restful-booker.herokuapp.com/booking/1001
            When user sends a GET request to the url
            Then HTTP status code should be 404
            And   response body contains "Not Found"
            And status line should be HTTP/1.1 404 Not Found
            And body does not contain "techproed"
            And Server is "Cowboy"
             */
    @Test
    public void get02(){
        //1. set the base url
        spec.pathParams("first", "booking", "second", 1001);
        //2. Set the expected data
        //3. Send the Get request and Get the response
        Response response =  given().spec(spec).when().get("/{first}/{second}");
        //4. do the validation
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").contentType("text/plain; charset=utf-8");
//        System.out.println(response.headers());
        System.out.println(response.header("Server"));
        assertEquals( "Cowboy",response.header("Server") );
//
        Assert.assertTrue(response.header("Server").contains("Cowboy"));
    }
}