package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

     /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
     */

    @Test
    public void get08(){
        //1. Set the base URL
        spec.pathParams("first","todos","second",2);

        //2. Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        //3.Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);

        System.out.println("expectedData = " + expectedData);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }

    @Test
    public void test(){
        //1.Set the base url
        spec.pathParams("first","todos","second",2);

        //Set the expected data
        Todo expectedTodo = new Todo(1,2,"quis ut nam facilis et officia qui",false);

        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //This is todo reference // this is returning todo object
        Todo actualTodo = response.as(Todo.class);


        assertEquals(expectedTodo.getId(),actualTodo.getId());
        assertEquals(expectedTodo.getTitle(),actualTodo.getTitle());
        assertEquals(expectedTodo.getUserId(),actualTodo.getUserId());
        assertEquals(expectedTodo.isCompleted(),actualTodo.isCompleted());

        System.out.println("expectedTodo = " + expectedTodo);
        System.out.println("actualTodo = " + actualTodo);


    }
}
