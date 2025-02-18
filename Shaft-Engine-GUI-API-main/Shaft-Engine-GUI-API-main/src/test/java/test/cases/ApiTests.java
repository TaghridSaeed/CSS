package test.cases;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTests {
    SHAFT.API api;
    String createBookingServiceName = "/booking";
    String authServiceName = "/auth";
    String deleteBookingServiceName = "/booking/";
    String bookingid;

    @Test
    public void ApisTest() {
        createBooking();
        assertOnBookingCreated("martina");
        DeleteBooking();
    }

    @BeforeClass
    public void setup() {
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
        login();
    }

    private void login() {
        String body = """
                {
                "username" : "admin",
                "password" : "password123"
                    }
                """;
        api.post(authServiceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(body).perform();
        String token = api.getResponseJSONValue("token");
        api.addHeader("Cookie", "token=" + token);
    }

    private void createBooking() {
        api.post(createBookingServiceName)
                .setContentType(ContentType.JSON)
                .setRequestBodyFromFile("src/test/resources/testDataFiles/RestfulBookerCreateBookingBody.json")
                .perform();
        bookingid = api.getResponseJSONValue("bookingid");


    }

    private void assertOnBookingCreated(String expectedFirstName) {
        api.assertThatResponse().extractedJsonValue("booking.firstname").isEqualTo(expectedFirstName);
        api.assertThatResponse().body().contains("bookingid");
    }

    private void DeleteBooking() {
        api.delete(deleteBookingServiceName + bookingid).setContentType(ContentType.JSON).perform();
    }
}
