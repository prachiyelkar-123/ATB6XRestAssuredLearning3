package PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class LAB012 {

    RequestSpecification r =RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "e4d065300f36b0f";
    String bookingid = "1850";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void testPatchREQUESTNonBDD(){
        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingid;
        System.out.println(BASE_PATH_UPDATED);

        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\"\n" +
                "}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDATED);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Pramod"));


    }
}