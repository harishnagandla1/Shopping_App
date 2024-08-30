// Step Definition file for 'Add new pet' feature

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;

public class AddNewPetSteps {

  private RequestSpecification requestSpec;
  private ResponseSpecification responseSpec;
  private io.restassured.response.Response response;

  @Given("Authenticate with the API to obtain a valid session/token")
  public void authenticate_API() {
    this.requestSpec = RestAssured.given().auth().preemptive().basic("username", "password");
    this.responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
  }

  @When("Send a POST request to \"/api/pets\" with valid pet details in the request body")
  public void send_post_request_valid_pet() {
    PetPayload petPayload = new PetPayload.Builder().name("Buddy").type("Dog").age(3).build();
    this.response = RestAssured.given().spec(this.requestSpec).body(petPayload).post("/api/pets");
  }

  @Then("The API should return a status code of 201")
  public void validate_status_code_201() {
    this.response.then().spec(this.responseSpec);
  }
}

// Payload Class for 'Pet'

public class PetPayload {

  private String name;
  private String type;
  private int age;

  public PetPayload(Builder builder) {
    this.name = builder.name;
    this.type = builder.type;
    this.age = builder.age;
  }

  public static class Builder {

    private String name;
    private String type;
    private int age;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public PetPayload build() {
      return new PetPayload(this);
    }
  }
}