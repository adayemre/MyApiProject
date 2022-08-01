package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {

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
                                     username : admin
                                     password : 1234
    */


    @Test
    public void post03(){

        //Set the base url
        spec.pathParam("first","todos");

        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();

        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);

        //send the Post request and get the response
        //When we use auth, we can use different type of auths in API. we use basic auth which requires username and password
    Response response = given().spec(spec).auth().basic("admin","1234").
                contentType(ContentType.JSON).
                body(expectedData).
                when().post("/{first}");

    //Validation
        response.then().statusCode(201);


        //1. way of validation
        Map<String,Object> actualData = response.as(HashMap.class);

        System.out.println("expectedData = " + expectedData);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        //2. way using JsonPaht
        JsonPath json = response.jsonPath();
        assertEquals(expectedData.get("userId"),json.getInt("userId"));
        assertEquals(expectedData.get("title"),json.getString("title"));
        assertEquals(expectedData.get("completed"),json.getBoolean("completed"));

        //3. way of validation
        response.then().body("userId",equalTo(expectedData.get("userId"))).
                        body("title",equalTo(expectedData.get("completed"))).
                        body("completed",equalTo(expectedData.get("completed")));


        //4. way of validation

        Todo todo = response.as(Todo.class);

        assertEquals(expectedData.get("userId"),todo.getUserId());
        assertEquals(expectedData.get("title"),todo.getTitle());
        assertEquals(expectedData.get("completed"),todo.isCompleted());



    }



}
