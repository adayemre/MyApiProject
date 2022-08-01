package patch_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
        When
            I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
            with the PUT Request body like {
                                            "title": "wash the car"
                                           }
       Then
           Status code is 200
           And response body is like  {
                                        "userId": 10,
                                        "title": "Wash the car",
                                        "completed": true,
                                        "id": 198
                                      }
     */

    @Test
    public void patch01(){

        //Set the base url
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("title","wash the car");

        //Send the Patch request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");

        //validate the data
        response.then().statusCode(200).body("title",equalTo(expectedData.get("title")));





    }




}
