package GetAPI;

import UserManagement.DeleteUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BasicAPITest{
    private int  USER_ID=1;
    @Test
    public void Delete_user(){
        test = extent.createTest("Delete_user", "Test to DELETE a user by ID").assignCategory("API Tests");
        DeleteUser deleteUser= new DeleteUser();
        deleteUser.deleteUser(USER_ID);
        Assert.assertEquals(deleteUser.getResponseStatusCode(),204,"correct deleting status code");
    }
}
