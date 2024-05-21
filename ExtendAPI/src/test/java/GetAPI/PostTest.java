package GetAPI;

import UserManagement.UserRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PostTest extends BasicAPITest{

    @Test
    public void creat_New_User (){
        test = extent.createTest("creat_New_User", "Test to create a new user").assignCategory("API Tests");
        String avatar = "askd.com";
        String email = "sohipas@gamil.com";
        String first_name="Sohaib";
        String last_name="Ahmed";

        UserRegistration newUser = new UserRegistration(email, first_name, last_name, avatar);
        newUser.CreateUser();
        newUser.getResponse().getBody().prettyPrint();
        Assert.assertEquals(newUser.getStatusCode(),201);

        //        Assert.assertEquals(userRegistration.getResponseBodyUsingKey("username"),username);

    }
}
