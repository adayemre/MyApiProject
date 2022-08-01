package get_http_request_method;
import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Get09 extends HerokuAppBaseUrl {
    /*
      When
          I send GET Request to https://restful-booker.herokuapp.com/booking/1
      Then
          Response body should be like that;
          {
              "firstname": "Eric",
              "lastname": "Jones",
              "totalprice": 354,
              "depositpaid": true,
              "bookingdates": {
                  "checkin": "2018-08-01",
                  "checkout": "2020-10-10"
               }
          }
   */
    @Test
    public void get09(){
        //1. Set the base url
        spec.pathParams("first", "booking", "second", 1);

        //Set the expected data
        Map<String, Object> bookingdates = new HashMap();
        bookingdates.put("checkin","2018-08-01" );
        bookingdates.put("checkout", "2020-10-10");

        Map<String, Object> expectedData = new HashMap();
        expectedData.put("firstname", "Eric");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice", 354);
        expectedData.put("depositpaid",false);
        expectedData.put("bookingdates",bookingdates);
        //3. Send the get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //do the validation
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("expected data map: "+expectedData);
        System.out.println("actual data map: "+actualData);

        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
    }
}