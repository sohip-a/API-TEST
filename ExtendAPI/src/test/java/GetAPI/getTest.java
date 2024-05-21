package GetAPI;

import UserManagement.GetUser;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class getTest extends BasicAPITest {
    private String GET_ALL_USERS = "users/";
    private int PAGE_NUMbER=1 ;


    //test getting users from page 2
    //assert the page number
    //assert the content type
    @Test
    public void getUsers_Tests() {
        test = extent.createTest("getUsers_Tests", "Test to GET users by page number").assignCategory("API Tests");
        GetUser users = new GetUser();
        users.Get_Users_by_Page_number(PAGE_NUMbER);
        assertThat(users.getResponse().statusCode(), equalTo(200));
        assertThat(users.getResponse().contentType(),equalTo("application/json; charset=utf-8"));
        assertThat(users.getResponse().jsonPath().getString("page"),equalTo(""+PAGE_NUMbER+""));


    }

/////////////////////////////////////////////
    // test getting specific user data by id
    @Test
    public void logUserDataByID(){
        test = extent.createTest("logUserDataByID", "Test to GET a user by ID and log the data").assignCategory("API Tests");
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
    // Test users reponse body using DataProvider
    @DataProvider(name ="IDAndEmailAndFirstAndLastNamePage1")
    public static Object[][] IDAndEmailAndFirstAndLastNamePage1() {
        return new Object[][] {
                { 1, "george.bluth@reqres.in", "George","Bluth" },
                { 2, "janet.weaver@reqres.in", "Janet","Weaver" },
                { 3, "emma.wong@reqres.in", "Emma","Wong"},
                { 4, "eve.holt@reqres.in", "Eve","Holt"},
                { 5, "charles.morris@reqres.in", "Charles","Morris"},
                { 6, "tracey.ramos@reqres.in", "Tracey","Ramos"}
        };
    }
    @Test (dataProvider="IDAndEmailAndFirstAndLastNamePage1")

    public void ResponseCheckID_Email_FirstName_Lastname(int id, String email, String firstName, String lastName ) {
        // Create a test node in the report
        test = extent.createTest("DataProvider to assert id,email,fname and Lname for every user in page1  : " )
                .assignCategory("API Tests");
        given().
                spec(requestSpec).
                when().
                get("users/"+id).
                then().log().body().
                and().assertThat().body("data.id", equalTo(id)).
                and().assertThat().body("data.email",equalTo(email)).
                and().assertThat().body("data.first_name",equalTo(firstName)).
                and().assertThat().body("data.last_name",equalTo(lastName)).
                and().assertThat().statusCode(200);
    }

}
