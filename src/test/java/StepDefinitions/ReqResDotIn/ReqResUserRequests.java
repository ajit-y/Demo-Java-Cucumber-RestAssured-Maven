package StepDefinitions.ReqResDotIn;

import StepDefinitions.ScenarioContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResUserRequests {

    /**
     * Variable Declarations
     */
    private final ScenarioContext context;
    private final Scenario scenario;

    /**
     * Dependency Injection Using cucumber-picocontainer
     */
    public ReqResUserRequests(ScenarioContext context) {
        this.context = context;
        this.scenario = context.scenario;
        context._REQ_SPEC = given().baseUri(context.BASE_URL);
    }

    /**
     * Step Definitions
     */

    @When("reqres.in website receives list users request for a page")
    public void reqres_in_website_receives_list_users_request_for_a_page() {
        context._RESP = context._REQ_SPEC.when().get("\n" +
                "/api/users?page=2");
        scenario.log(context._RESP.body().prettyPrint());
    }

    @Then("reqres returns status {int}")
    public void reqres_returns_status(Integer status) {
        context._V_RESP = context._RESP.then();
        context._V_RESP.assertThat().statusCode(status);
    }

    @Then("reqres returns list of users with user data")
    public void reqres_returns_list_of_users_with_user_data() {
        context._V_RESP.assertThat().body("page", equalTo(2));
    }

}
