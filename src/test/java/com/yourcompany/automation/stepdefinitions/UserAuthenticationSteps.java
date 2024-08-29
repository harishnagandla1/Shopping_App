import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Extend ApiTestBase to use predefined specifications
public class UserAuthenticationSteps extends ApiTestBase {

    private String responseBody;

    @Given("the API base URI is set for EP-25")
    public void the_api_base_uri_is_set_for_ep_25() {
        // Set the base URI for EP-25 related tests
        requestSpec.baseUri("http://api.ep25.com");
    }

    @When("a user performs a GET request to {string}")
    public void a_user_performs_a_get_request_to(String endpoint) {
        responseBody = given()
                           .spec(requestSpec)
                       .when()
                           .get(endpoint)
                       .then()
                           .extract()
                           .asString();
    }

    @Then("the response should contain the expected data for EP-25")
    public void the_response_should_contain_the_expected_data_for_ep_25() {
        // Add assertions to verify the response contains the expected data
        // Example:
        // assertThat(responseBody).contains("expectedData");
    }
}