package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {

     /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response format should be “application/json”
        And
            “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
        And
            “completed” is false
        And
            “userId” is 2
     */

    @Test
    public void get03(){
        //1. Set the base url
        spec.pathParams("first", "todos", "second", 23);
        //2. set the expected data
        //3. send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do the validation
        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));
       //         .body("completed",equalTo(false))
       //         .body("userId",equalTo(2));
    }

}
