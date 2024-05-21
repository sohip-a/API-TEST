package GetAPI;
import UserManagement.UpdateUser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAPITest {
    protected static RequestSpecification requestSpec;
    protected static RequestSpecification requestSpec2;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentTest test;

    @BeforeClass
    public static void createRequestSpecification() {
        sparkReporter=new ExtentSparkReporter("extent.html");
        extent =new ExtentReports();
        extent.attachReporter(sparkReporter);

         requestSpec = new RequestSpecBuilder().
                setBaseUri("https://reqres.in/api/").
                build();

    }
    @AfterClass
    public static void tearDown() {
        // Flush the ExtentReports to generate the report
        if (extent != null) {
            extent.flush();
        }
    }











}
