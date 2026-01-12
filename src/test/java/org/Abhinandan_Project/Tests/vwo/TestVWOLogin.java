package org.Abhinandan_Project.Tests.vwo;

import io.restassured.RestAssured;
import org.Abhinandan_Project.Base.BaseTest;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.Abhinandan_Project.modules.vwo.PayloadManagerVWO;
import org.Abhinandan_Project.pojos.vwo.response.LoginResponse;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {

    @Test
    public void test_VMO_LOGIN()
    {
        requestSpecification.baseUri(API_Constants.VWO_BASE_URL);
        requestSpecification.basePath(API_Constants.VWO_LOGIN_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManagerVWO.setLoginData()).log().all()
                .post();

        //extraction
        LoginResponse loginResponse = payloadManagerVWO.getLoginData(response.asString());

        //validation and verification
        assertActions.verifyStatusCode(response, 200);

    }
}
