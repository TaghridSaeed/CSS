package booker;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class Apis {
    private SHAFT.API api;
    //basic url
    public  static String baseUrl =System.getProperty("baseUrl");

    public Apis(SHAFT.API api) {
        this.api = api;
    }
    //status code
    public final static int SUCCESS=200;
    public final static int SUCCESS_DELETE=201;
    // services name
    String authServiceName ="/auth";
    //Actions
    public Apis login() {
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
        return this;
    }
}
