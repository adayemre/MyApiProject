package post_http_request_method;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Post02 extends JsonPlaceHolderBaseUrl {
    /*
        When
            I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
            with the request body {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false
                                   }
        Then
            Status code is 201
            And response body is like {
                                        "userId": 55,
                                        "title": "Tidy your room",
                                        "completed": false,
                                        "id": 201
                                      }
     */
    @Test
    public void post02(){
        //Set the base url
        spec.pathParam("first", "todos");
        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",55 );
        expectedData.put("title","Tidy your room" );
        expectedData.put("completed", false);
        //Send a Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        //Then Do the validation
        response.then().statusCode(201);
        expectedData.put("id", 201);
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals("data does not match",expectedData.get("id"), actualData.get("id"));
        System.out.println("expected data: "+expectedData);
        System.out.println("actual data: "+actualData);
    }
    @Test
    public void testPost(){
        //Set the base url
        spec.pathParam("first", "todos");
        //Set the expected data
        Todo expectedData = new Todo(55, "Tidy your room",false);
        //Send the Post request and Get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData  ).when().post("/{first}");
        //Do the validation
        response.then().statusCode(201);
        //we get the actual data into our pojo
        Todo actualData = response.as(Todo.class);
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.isCompleted(), actualData.isCompleted());
    }
}