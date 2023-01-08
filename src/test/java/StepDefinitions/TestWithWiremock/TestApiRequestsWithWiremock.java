package StepDefinitions.TestWithWiremock;

import StepDefinitions.ScenarioContext;
import StepDefinitions.TestWithWiremock.RequestBodyObjects.WmRequestBody;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class TestApiRequestsWithWiremock {

    private final ScenarioContext context;

    private WmRequestBody wmRequestBody;

    public TestApiRequestsWithWiremock(ScenarioContext context) {
        this.context = context;
    }

    @Given("Scenario for handling POST request is setup in Wiremock")
    public void scenarioForHandlingPOSTRequestIsSetupInWiremock() {
        WireMock.configureFor("localhost", context.wireMockServer.port());
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/wirepost"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .willReturn(WireMock.aResponse().withStatus(200)));
    }

    @When("the API endpoint receives a POST request")
    public void the_api_endpoint_receives_a_post_request() {
        wmRequestBody = new WmRequestBody(true, List.of("POST", "PUT", "GET", "DELETE"));

        context.setRequestSpecification(context.WIREMOCK_BASE_URL + context.wireMockServer.port());
        context.response = context.sendPostRequest(wmRequestBody, "/wirepost");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }

    @Then("the API endpoint returns status {int}")
    public void the_api_endpoint_returns_status(Integer statusCode) {
        context.getValidatableResponse().assertThat().statusCode(statusCode);
    }


    @Given("Scenario for handling GET request is setup in Wiremock")
    public void scenarioForHandlingGETRequestIsSetupInWiremock() {
        WireMock.configureFor("localhost", context.wireMockServer.port());
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/wireget"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\":\"success\"}")
                        .withStatus(200)));
    }

    @When("the API endpoint receives a GET request")
    public void theAPIEndpointReceivesAGETRequest() {
        context.setRequestSpecification(context.WIREMOCK_BASE_URL + context.wireMockServer.port());
        context.response = context.sendGetRequest("/wireget");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }

    @And("the response body contains text {string}")
    public void theResponseBodyContainsTextSuccess(String text) {
        context.getValidatableResponse().assertThat().body("status", equalTo(text));
    }

    @Given("Scenario for handling DELETE request is setup in Wiremock")
    public void scenarioForHandlingDELETERequestIsSetupInWiremock() {
        WireMock.configureFor("localhost", context.wireMockServer.port());
        WireMock.stubFor(WireMock.delete(WireMock.urlEqualTo("/wiredelete"))
                .willReturn(WireMock.aResponse()
                        .withStatusMessage("Delete Successful")
                        .withStatus(200)));
    }

    @When("the API endpoint receives a DELETE request")
    public void theAPIEndpointReceivesADELETERequest() {
        context.setRequestSpecification(context.WIREMOCK_BASE_URL + context.wireMockServer.port());
        context.response = context.sendDeleteRequest("/wiredelete");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }

    @And("the response message contains text {string}")
    public void theResponseMessageContainsText(String responseMessage) {
        context.getValidatableResponse().assertThat().statusLine(containsString(responseMessage));
    }

    @Given("Scenario for handling PUT request is setup in Wiremock")
    public void scenarioForHandlingPUTRequestIsSetupInWiremock() {
        WireMock.configureFor("localhost", context.wireMockServer.port());
        WireMock.stubFor(WireMock.put(WireMock.urlEqualTo("/wireput"))
                .withHeader("content-type", WireMock.equalTo("application/json"))
                .willReturn(WireMock.aResponse()
                        .withHeader("content-type", "application/json")
                        .withBody("{\"status\":\"Update Successful\"}")
                        .withStatus(200)));
    }

    @When("the API endpoint receives a PUT request")
    public void theAPIEndpointReceivesAPUTRequest() {
        wmRequestBody = new WmRequestBody(true, List.of("POST", "PUT", "GET", "DELETE"));

        context.setRequestSpecification(context.WIREMOCK_BASE_URL + context.wireMockServer.port());
        context.response = context.sendPutRequest(wmRequestBody, "/wireput");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }
}
