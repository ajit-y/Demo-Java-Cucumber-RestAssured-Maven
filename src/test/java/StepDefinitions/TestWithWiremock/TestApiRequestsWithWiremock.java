package StepDefinitions.TestWithWiremock;

import StepDefinitions.ScenarioContext;
import StepDefinitions.TestWithWiremock.RequestBodyObjects.WmRequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TestApiRequestsWithWiremock {

    private final ScenarioContext context;

    private WmRequestBody wmRequestBody;

    public TestApiRequestsWithWiremock(ScenarioContext context) {
        this.context = context;
    }

    @Given("Scenario for handling POST request is setup in Wiremock")
    public void scenarioForHandlingPOSTRequestIsSetupInWiremock() {
        configureFor("localhost", context.wireMockServer.port());
        stubFor(post(urlEqualTo("/wirepost"))
                .withHeader("content-type", equalTo("application/json"))
                .willReturn(aResponse().withStatus(200)));
    }

    @When("the API endpoint receives a POST request")
    public void the_api_endpoint_receives_a_post_request() {
        wmRequestBody = new WmRequestBody(true, List.of("POST", "PUT", "GET", "DELETE"));

        context.setRequestSpecification(context.WIREMOCK_BASE_URL);
        context.response = context.sendPostRequest(wmRequestBody, "/wirepost");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }

    @Then("the API endpoint returns status {int}")
    public void the_api_endpoint_returns_status(Integer statusCode) {
        context.getValidatableResponse().assertThat().statusCode(statusCode);
    }


}
