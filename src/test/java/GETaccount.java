import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GETaccount {

    @Test
    public void getAccount(){
        //find base URI
        RestAssured.baseURI="https://api.glskcommunity.org";
        //vypis body do konzoly
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured
                .given()
                .get("/account")
                .then()
//                .statusCode(HttpStatus.SC_OK,)
                .statusCode(Matchers.isOneOf(200,204));
//                .body("id", Matchers.notNullValue(),"name", Matchers.anything());
    }
}
