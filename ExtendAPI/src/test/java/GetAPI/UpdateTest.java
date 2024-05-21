package GetAPI;

import UserManagement.UpdateUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UpdateTest extends BasicAPITest{

    private int id=1;
    private String nemail="Sohipas@gmail.com";
    private String nfirst_name="Sohaib";
    private String nlast_name="Ahmed";
    private String navatar="link.com";

    @Test
    public void update_Exist_user(){
        test = extent.createTest("update_Exist_user", "Test to update an existing user").assignCategory("API Tests");

        UpdateUser user = new UpdateUser();
        user.updateUserData(id,nemail,nfirst_name,nlast_name,navatar);

        assertThat(user.getResponse().statusCode(), equalTo(200));
        assertThat(user.getResponse().contentType(),equalTo("application/json; charset=utf-8"));
    }




}
