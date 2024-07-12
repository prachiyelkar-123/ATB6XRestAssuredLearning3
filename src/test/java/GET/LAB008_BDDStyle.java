package GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class LAB008_BDDStyle {
    @Test
    public void getRequestBDDStyle() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/400084")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);
    }
}