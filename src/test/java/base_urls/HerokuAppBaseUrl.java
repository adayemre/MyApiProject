package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppBaseUrl {

    //this will be null for now untill I set it
    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}