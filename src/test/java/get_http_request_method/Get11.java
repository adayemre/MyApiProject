package get_http_request_method;
import base_urls.DummyApiBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.OuterData;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
public class Get11 extends DummyApiBaseUrl {
    /*
     When
       I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
      Status code should be 200
      Use Gson and ObjectMapper
      make sure you have 24 records for data
 */
    @Test
    public void get11()  throws IOException{
        //1. Set the base url
        spec.pathParams("first", "api","second","v1", "third", "employees");
        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        //response.prettyPrint();
        //We do deserialization using Object Mapper
        ObjectMapper obj = new ObjectMapper();
        OuterData outerData = obj.readValue(response.asString(),OuterData.class);
        System.out.println(outerData.getData().size());
        for (int i = 0; i <outerData.getData().size() ; i++) {
            System.out.println(outerData.getData().get(i).getEmployee_salary());
        }
        System.out.println(outerData.getMessage());
        System.out.println(outerData.getStatus());
        assertTrue(outerData.getData().size() == 24);
    }
    @Test
    public void get12(){
        //1. Set the base url
        spec.pathParams("first", "api","second","v1", "third", "employees");
        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        Gson gson = new Gson();
        OuterData outerData = gson.fromJson(response.asString(),OuterData.class );
        System.out.println(outerData.getData().size());
        //Do the validation
        assertTrue(outerData.getData().size() == 24);
    }
}