package UserManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUser {
    private String baseUri = "https://reqres.in/api/";
    private String userPath = "users/";


    private String userPutRequestBody;
    private String userRegistrationRequestBody;
    public String userupdateRequestBody;

    private Response response;

    public UpdateUser() {
        RestAssured.baseURI = baseUri;
    }
    public Response getUserResponse(int id){
          response = RestAssured.given().
                when().
                get(baseUri+userPath+id).then().extract().response();
        return response;
    }

    //using patch methode
    public void updateUserFirstName(String firstname){
        userRegistrationRequestBody ="{\"email\": \""+firstname+"\"}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequestBody)
                .log().body()
                        .patch("users/1");
       System.out.println(getUserResponse(1).prettyPrint());
    }

    public Response getResponse() {
        return response;
    }
    public void updateUserData(int id, String nemail, String nfirst_name, String nlast_name, String navatar){
        RestAssured.baseURI = baseUri;
        userupdateRequestBody =  "{ \" email \" : \""+nemail+"\", \"first_name\":\""+nfirst_name+"\",\" last_name\":\""+nlast_name+"\",\"avatar\":\""+navatar+"\"}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userupdateRequestBody)
                .post(baseUri+userPath+id);
    }
}

