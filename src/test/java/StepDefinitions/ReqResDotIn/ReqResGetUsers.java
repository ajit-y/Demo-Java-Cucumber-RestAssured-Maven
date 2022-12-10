package StepDefinitions.ReqResDotIn;

import StepDefinitions.ScenarioContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class ReqResGetUsers {

    /**
     * Variable Declarations
     */
    private final ScenarioContext context;
    private final Scenario scenario;
    private List<Map<String, Integer>> pageList;


    /**
     * Context setup using dependency injection using cucumber-picocontainer
     */
    public ReqResGetUsers(ScenarioContext context) {
        this.context = context;
        this.scenario = context.scenario;
    }

    /**
     * Step Definitions
     */

    @When("reqres.in website receives list users request for a page")
    public void reqres_in_website_receives_list_users_request_for_a_page(io.cucumber.datatable.DataTable dataTable) {
        pageList = dataTable.asMaps(String.class, Integer.class);
        context.initializeValidatableResponseList();

        for (Map<String, Integer> m : pageList) {
            context.setRequestSpecification(context.REQRES_BASE_URL);
            context.response = context.sendGetRequest("page", m.get("page number"), "/api/users");

            context.requestInformationLogging();
            context.responseInformationLogging();

            context.setValidatableResponse(context.response);
            context.validatableResponseListBuilder();
        }
    }


    @Then("reqres returns status {int} for each request")
    public void reqres_returns_status(Integer status) {
        for (ValidatableResponse vr : context.getValidatableResponseList()) {
            scenario.log("Checked status code for request number " + (context.getValidatableResponseList().indexOf(vr) + 1));
            vr.assertThat().statusCode(status);
        }
    }

    @Then("reqres returns list of users with user data")
    public void reqres_returns_list_of_users_with_user_data() {
        for (ValidatableResponse vr : context.getValidatableResponseList()) {
            scenario.log("Checked response data for request number " + (context.getValidatableResponseList().indexOf(vr) + 1));
            vr.assertThat().body("page", equalTo(pageList
                    .get(context.getValidatableResponseList().indexOf(vr))
                    .get("page number")));
        }
    }

    @When("reqres.in website receives list users request on page {int}")
    public void reqres_in_website_receives_list_users_request_on_page(Integer pageNum) {
        context.setRequestSpecification(context.REQRES_BASE_URL);
        context.response = context.sendGetRequest("page", pageNum, "/api/users");

        context.requestInformationLogging();
        context.responseInformationLogging();

        context.setValidatableResponse(context.response);
    }

    @Then("reqres returns response with status {int}")
    public void reqres_returns_response_with_status(Integer status) {
        context.getValidatableResponse().assertThat().statusCode(status);
    }

    @Then("reqres returns list of users with user data on page {int}")
    public void reqres_returns_list_of_users_with_user_data_on_page(Integer pageNum) {
        context.getValidatableResponse().assertThat().body("page", equalTo(pageNum));
    }

}

