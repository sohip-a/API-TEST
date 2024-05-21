package UserManagement;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {
    private String baseUri = "https://reqres.in/api/";

    private String GET_ALL_USERS = "users/";
    private String PAGE_CODE = "?page=";
    private String userDeleteRequestBody;
    private Response response;
    int responseStatusCode;


    public GetUser(){

        RestAssured.baseURI = baseUri;

    }

    public void Get_Users_by_Page_number(int PAGE_ID) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(baseUri+GET_ALL_USERS+PAGE_CODE+PAGE_ID);

        response.then().log().all();

//        response= given().
//                spec(requestSpec)
//                .log().all().
//                when().
//                get(GET_ALL_USERS).
//                then().
//                log().all().
//                assertThat().
//                statusCode(200);
    }
    public Response getResponse() {
        return response;
    }
    public int getResponseStatusCode(){
        return responseStatusCode = response.statusCode();
    }

/*



    // test getting specific user data by id
    @Test
    public void logUserDataByID(){
        given().
                spec(requestSpec).
                when().
                get("users/382").
                then().
                log().body().
                and().assertThat().body("data.id",equalTo(1)).
                and().assertThat().body("data.first_name",equalTo("George"));

        //  and.assertThat().body("first_name",equalTo("George"));
    }

*/
}
