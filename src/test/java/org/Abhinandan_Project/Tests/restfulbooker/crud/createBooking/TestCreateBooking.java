package org.Abhinandan_Project.Tests.restfulbooker.crud.createBooking;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.Abhinandan_Project.Base.BaseTest;
import org.Abhinandan_Project.end_Points.API_Constants;
import org.Abhinandan_Project.pojos.restfulBooker.response.BookingResponse;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Abhinandan Basu")
    @Description("TC#1 - verify that the booking can be created")
    public void testCreateBookingPOST_positive()
    {
        //GIVEN
        //Setup will first and making the request
        requestSpecification.basePath(API_Constants.CREATE_UPDATE_BOOKING_URL);
        response  = RestAssured
                .given(requestSpecification)

                //WHEN
                .when()
                .body(payloadManager.createPayloadBookingAsString()).log().all().post();

        //EXTRACTION
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //THEN
        //validation and verification via the ASSERTJ TestNG
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Abhinandan");

    }

}
