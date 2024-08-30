import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.path.json.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

public class PetSteps {

    private SharedData sharedData;
    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;

    public PetSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("^the API endpoint is set to \"([^"]*)\"$")
    public void the_API_endpoint_is_set_to(String endpoint) {
        requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://api.example.com" + endpoint)
            .setContentType("application/json")
            .build();
    }

    @Given("^there are pets with status '(.+)' in the system$")
    public void there_are_pets_with_status_in_the_system(String status) {
        // Implementation depends on the actual system
    }

    @When("^I send a GET request with parameter \"([^"]*)\"$")
    public void i_send_a_get_request_with_parameter(String parameter) {
        sharedData.response = given().spec(requestSpec)
            .param("status", parameter.split("=")[1])
            .when().get();
    }

    @Then("^the response status code should be (\d+)$")
    public void the_response_status_code_should_be(int statusCode) {
        responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(statusCode)
            .build();
        sharedData.response.then().spec(responseSpec);
    }

    @Then("^the response body contains a list of pets with status '(.+)'$")
    public void the_response_body_contains_a_list_of_pets_with_status(String status) {
        JsonPath jsonPathEvaluator = sharedData.response.jsonPath();
        List<Pet> pets = jsonPathEvaluator.getList("", Pet.class);
        for (Pet pet : pets) {
            Assert.assertEquals(status, pet.getStatus());
        }
    }

    @Given("^I have the following pet details$")
    public void i_have_the_following_pet_details(DataTable petDetails) {
        Pet pet = new Pet.PetBuilder()
            .setName(petDetails.asList(Pet.class).get(0).getName())
            .setStatus(petDetails.asList(Pet.class).get(0).getStatus())
            .build();
        sharedData.requestBody = pet;
    }

    @When("^I send a POST request with the pet details$")
    public void i_send_a_post_request_with_the_pet_details() {
        sharedData.response = given().spec(requestSpec)
            .body(sharedData.requestBody)
            .when().post();
    }

    @Then("^the response body contains the pet's details including a unique pet ID$")
    public void the_response_body_contains_the_pet_s_details_including_a_unique_pet_ID() {
        JsonPath jsonPathEvaluator = sharedData.response.jsonPath();
        Pet pet = jsonPathEvaluator.getObject("", Pet.class);
        Assert.assertEquals(sharedData.requestBody.getName(), pet.getName());
        Assert.assertEquals(sharedData.requestBody.getStatus(), pet.getStatus());
        Assert.assertNotNull(pet.getId());
    }

    @Then("^the response body contains message \"([^"]*)\"$")
    public void the_response_body_contains_message(String message) {
        JsonPath jsonPathEvaluator = sharedData.response.jsonPath();
        String actualMessage = jsonPathEvaluator.get("message");
        Assert.assertEquals(message, actualMessage);
    }
}

public class SharedData {
    public Response response;
    public Object requestBody;
}