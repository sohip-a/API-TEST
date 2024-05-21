package UserManagement;


import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.path.json.JsonPath;


public class UserRegistration {
    private String baseUri = "https://reqres.in/api/";
    private String userRegisterPath = "users/";

    private String userRegistrationRequestBody;
    private Response response;


    public  UserRegistration(String email, String first_name, String last_name, String avatar){
        RestAssured.baseURI = baseUri;
        userRegistrationRequestBody =  "{ \" email \" : \""+email+"\", \"first_name\":\""+first_name+"\",\" last_name\":\""+last_name+"\",\"avatar\":\""+avatar+"\"}";
    }

    public void CreateUser(){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequestBody)
                .post(userRegisterPath);
    }
/*
    public void DeleteUser(int id){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"id\":"+id+"\"}")
                .delete("users/");
    }

 */
    public int getStatusCode(){
        return response.getStatusCode();
    }

    public Response getResponse() {
        return response;
    }

//    public String getResponseBodyUsingKey(String key){
//        JsonPath jsonPath = response.jsonPath();
//        return jsonPath.toString(key);
//    }




    // امسح دا
    public void updateUserEmail(String email){
       String userRegistrationRequestBody1 ="{\"email\": \""+email+"\"}";
//                "{ \" email \" : \""+email+"\", \"first_name\":\""+first_name+"\",\" last_name\":\""+last_name+"\",\"avatar\":\""+avatar+"\"}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequestBody1)
                .log().body()
                .patch("users/1");
    }

}
