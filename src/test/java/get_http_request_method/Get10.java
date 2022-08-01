package get_http_request_method;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
public class Get10 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/7
        When
            I send a GET request to the Url
        And
            Accept type is “application/json”
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        {
        "userId": 1,
            "id": 7,
            "title": "illo expedita consequatur quia in",
            completed false
    },
     */
    @Test
    public void get10(){
        //Set the base url
        spec.pathParams("first","todos", "second", 7);
        //2. Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 7);
        expectedData.put("title", "illo expedita consequatur quia in");
        expectedData.put("completed", false);

        //3. send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");


        //1. way of validation
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("userId", equalTo(1)).
                body("id", equalTo(7)).
                body("title", equalTo("illo expedita consequatur quia in")).
                body("completed", equalTo(false));

        //2. validation
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        //3. way of validation
        JsonPath json = response.jsonPath();

        assertEquals(1,json.getInt("userId") );
        assertEquals(7,json.getInt("id") );
        assertEquals("illo expedita consequatur quia in",json.getString("title") );
        assertEquals(false,json.getBoolean("completed") );
    }

    //Java converting to Json => serialization
    //Json converting to Java => deserialization
}