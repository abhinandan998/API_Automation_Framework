package org.Abhinandan_Project.Tests.restfulbooker.crud.createToken;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.Abhinandan_Project.Base.BaseTest;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Abhinandan")
    @Description("")
    public void testTokenPOST()
    {
        requestSpecification.basePath(API_Constants.AUTH_URL);
        response = RestAssured.given(requestSpecification)
                .when()
                .body(payloadManager.setAuthPayload()).post();

        //Extraction(JSON string response to java object)
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);

        //validation of the request
        assertActions.verifyStringKeyNotNull(token);

    }
}
