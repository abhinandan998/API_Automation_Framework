package org.Abhinandan_Project.Tests.groq;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.Abhinandan_Project.Base.BaseTest;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.Abhinandan_Project.pojos.groq.Response.ChatCompletionResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestGROQChatResponse extends BaseTest {


    @Test(groups = "reg", priority = 1)
    @Owner("Abhinandan")
    @Description("TC#1 - Verify GROW")
    public void test_GROQ_CHAT() {
        // Setup will first and making the request - Part - 1
        requestSpecification.baseUri(API_Constants.GROQ_BASE_URL);
        requestSpecification.basePath(API_Constants.GROQ_CHAT);
        requestSpecification.header("Authorization", "Bearer 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");


        response = RestAssured.given(requestSpecification)
                .when().body(payloadManaagerGROQ.setBuildRequest()).log().all()
                .post();

        //Extraction Part - 2
        ChatCompletionResponse chatCompletionResponse = payloadManaagerGROQ.parseResponse(response.asString());

        // Validation and verification via the AssertJ, TestNG Part - 3
        String resonse_chat = chatCompletionResponse.getChoices().get(0).getMessage().getContent();

        System.out.println(resonse_chat);
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(resonse_chat);
    }

}
