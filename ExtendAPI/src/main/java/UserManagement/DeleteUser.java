package UserManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteUser {
    private String baseUri = "https://reqres.in/api/";
    private String userPath = "users/";

    private String userDeleteRequestBody;
    private Response response;
    int responseStatusCode;

    public DeleteUser( ) {
        RestAssured.baseURI = baseUri;

    }
    public void deleteUser(int id ){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .delete(baseUri+userPath+id);
    }

    public Response getResponse() {
        return response;
    }
    public int getResponseStatusCode(){
        return responseStatusCode = response.statusCode();
    }
}
