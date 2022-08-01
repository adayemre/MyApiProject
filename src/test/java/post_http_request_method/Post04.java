package post_http_request_method;
import base_urls.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Registrant;
import static io.restassured.RestAssured.given;
import static utility.WriteToTxt.generateData;
public class Post04 extends MedunnaBaseUrl {
    //https://medunna.com/api/register
    @Test
    public void testPost(){
        //Set the base url
        spec.pathParams("first", "api", "second", "register");
        Faker faker = new Faker();
        Registrant registrant = new Registrant();
        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setEmail(faker.internet().emailAddress());
        registrant.setLangKey("en");
        registrant.setLogin(registrant.getFirstName()+registrant.getLastName());
        registrant.setPassword(faker.internet().password(8,20,true, true));
        registrant.setSsn(faker.idNumber().ssnValid());
        //Send the Post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
        response.then().statusCode(201);
        response.prettyPrint();
        String fileName = "./src/test/java/test_data/medunna_registrant_info.txt";
        generateData(registrant,fileName);
    }
}