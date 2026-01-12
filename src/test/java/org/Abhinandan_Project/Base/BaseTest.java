package org.Abhinandan_Project.Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.Abhinandan_Project.Asserts.AssertActions;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.Abhinandan_Project.modules.groq.PayloadManaagerGROQ;
import org.Abhinandan_Project.modules.restfulbooker.PayloadManager;
import org.Abhinandan_Project.modules.vwo.PayloadManagerVWO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    //commonToAll testcases
    //BaseURL, Content type- json - common

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;

    public PayloadManager payloadManager;
    public PayloadManagerVWO payloadManagerVWO;
    public PayloadManaagerGROQ payloadManaagerGROQ;
    public JsonPath jsonPath;
    public AssertActions assertActions;



    @BeforeTest
    public void setup()
    {
        System.out.println("Starting of the Test!");
        payloadManager = new PayloadManager();
        payloadManagerVWO = new PayloadManagerVWO();
        payloadManaagerGROQ = new PayloadManaagerGROQ();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(API_Constants.Base_URL);
        requestSpecification.contentType(ContentType.JSON);
    }

    public String getToken()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(API_Constants.Base_URL)
                .basePath(API_Constants.AUTH_URL);

        //Setting the payload
        String payload = payloadManager.setAuthPayload();
        //get the token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
        String token = payloadManager.getTokenFromJSON(response.asString());
        return token;
    }
    @AfterTest
    public void tearDown()
    {

        System.out.println("Finished the Test!");
    }

}
