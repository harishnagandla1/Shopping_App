import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;

public class UserCreationSteps {

    private final SharedData sharedData;

    public UserCreationSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("^the API endpoint '(.*)' is ready to accept POST requests$")
    public void api_endpoint_ready(String endpoint) {
        sharedData.requestSpec.basePath(endpoint);
    }

    @When("^a POST request is sent to '(.*)' with the payload body:$")
    public void send_post_request(String endpoint, DataTable userData) {
        UserPayload user = userData.asList(UserPayload.Builder.class).stream()
            .map(Builder::build)
            .findFirst()
            .orElseThrow(IllegalStateException::new);

        sharedData.response = given().spec(sharedData.requestSpec)
            .contentType(ContentType.JSON)
            .body(user)
            .when().post(endpoint);
    }

    @Then("^the response should have a status code of (\d+)$")
    public void verify_status_code(int statusCode) {
        sharedData.response.then().statusCode(statusCode);
    }

    @Then("^the response should confirm user creation in JSON format$")
    public void confirm_user_creation() {
        Assert.assertTrue(sharedData.response.asString().contains("user created"));
    }
}