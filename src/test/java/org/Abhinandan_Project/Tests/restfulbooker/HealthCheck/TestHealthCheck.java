package org.Abhinandan_Project.Tests.restfulbooker.HealthCheck;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.Abhinandan_Project.Base.BaseTest;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {

    @Test
    @Description("TC#3 - verify Health")
    public void testGETHealthCheck()
    {
        requestSpecification.basePath(API_Constants.PING_URL);

        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

        assertActions.verifyTrue(response.asString().contains("Created"));
    }
}
