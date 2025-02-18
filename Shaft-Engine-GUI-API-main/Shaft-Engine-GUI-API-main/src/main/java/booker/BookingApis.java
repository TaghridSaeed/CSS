package booker;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class BookingApis {
 private SHAFT.API api;

    public BookingApis(SHAFT.API api) {
        this.api = api;
    }

    //service name
    String bookingServiceName="/booking";
    String deleteBookingServiceName = "/booking/";
    String bookingid;

    //Actions
    public BookingApis createBoking(){
        api.post(bookingServiceName)
                .setContentType(ContentType.JSON)
                .setRequestBodyFromFile("src/test/resources/testDataFiles/RestfulBookerCreateBookingBody.json")
                .perform();
        bookingid = api.getResponseJSONValue("bookingid");
        return this;
    }
    public BookingApis assertOnBookingCreated(String expectedFirstName) {
        api.assertThatResponse().extractedJsonValue("booking.firstname").isEqualTo(expectedFirstName);
        api.assertThatResponse().body().contains("bookingid");
        return this;
    }
//    public Response getBookingIds(String firstName, String lastName) {
//        return api.get(bookingServiceName)
//                .setUrlArguments("firstname=" + firstName + "&lastname=" + lastName)
//                .perform();
//    }
public BookingApis getBookingId(String firstName, String lastName) {
    api.get(bookingServiceName)
            .setUrlArguments("firstname=" + firstName + "&lastname=" + lastName)
            .perform();
    bookingid = api.getResponseJSONValue("$[0].bookingid");
    return this;
}


    public BookingApis DeleteBooking() {
        api.delete(deleteBookingServiceName + bookingid).setContentType(ContentType.JSON).perform();
        return this;
    }
}
