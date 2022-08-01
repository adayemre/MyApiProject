package put_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderData.expectedData;

public class Put01 extends JsonPlaceHolderBaseUrl {

     /*
         When
            I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
            with the PUT Request body like {
                                            "userId": 21,
                                            "title": "Walk the dog",
                                            "completed": true
                                           }
         Then
           Status code is 200
           And response body is like   {
                                        "userId": 21,
                                        "title": "Walk the dog",
                                        "completed": true,
                                        "
                                       }
     */


    @Test
    public void put01(){

        //1. Set the base url
        spec.pathParams("first","todos","second",198);

        //Set the expacted data
        Map<String,Object> expectedData = expectedData();

        //2. way of setting the data // in the process
        Todo expectedTodo = new Todo(21,"Walk the dog",true);

        //Send the Put request and get the response
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedTodo).when().put("/{first}/{second}");

       //Validate the data
        response.then().statusCode(200);
        response.prettyPrint();

        //Validate the body
        response.then().body("userId",equalTo(expectedTodo.getUserId())).
                        body("title",equalTo(expectedTodo.getTitle())).
                        body("completed",equalTo(expectedTodo.isCompleted()));


        //2. way
        Map<String,Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedTodo.getUserId(),actualDataMap.get("userId"));
        assertEquals(expectedTodo.getTitle(),actualDataMap.get("title"));
        assertEquals(expectedTodo.isCompleted(),actualDataMap.get("completed"));

        //3. way
        Todo actualTodo = response.as(Todo.class);

        assertEquals(expectedTodo.getUserId(),actualTodo.getUserId());
        assertEquals(expectedTodo.getTitle(),actualTodo.getTitle());
        assertEquals(expectedTodo.isCompleted(),actualTodo.isCompleted());

        //4. way
        JsonPath json = response.jsonPath();

        assertEquals(expectedTodo.getUserId(),json.getInt("userId"));
        assertEquals(expectedTodo.getTitle(),json.getString("title"));
        assertEquals(expectedTodo.isCompleted(),json.getBoolean("completed"));




    }


}
