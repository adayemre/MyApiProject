package post_http_request_method;
import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends HerokuAppBaseUrl {
    /*
       When
           I send POST Request to the Url https://restful-booker.herokuapp.com/booking
           with the request body {
                                   "firstname": "Murat",
                                   "lastname": "Altyyev",
                                   "totalprice": 11111,
                                   "depositpaid": true,
                                   "bookingdates": {
                                       "checkin": "2021-09-09",
                                       "checkout": "2021-09-21"
                                    }
                                 }
       Then
           Status code is 200
           And response body should be like {
                                               "bookingid": 11,
                                               "booking": {
                                                   "firstname": "Murat",
                                                   "lastname": "Altyyev",
                                                   "totalprice": 11111,
                                                   "depositpaid": true,
                                                   "bookingdates": {
                                                       "checkin": "2021-09-09",
                                                       "checkout": "2021-09-21"
                                                   }
                                               }
                                            }
    */
    @Test
    public void post01(){
        //Set the base url
        spec.pathParam("first", "booking");

        //Set the expected data

        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2021-09-09");
        bookingdates.put("checkout","2021-09-21");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Murat");
        expectedData.put("lastname", "Altyyev");
        expectedData.put("totalprice", 11111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates );

        //Send the Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do the validation
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("firtsname"),actualData.get("firstname"));


    }
}
