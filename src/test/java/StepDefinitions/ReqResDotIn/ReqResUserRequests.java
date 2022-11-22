package StepDefinitions.ReqResDotIn;

import StepDefinitions.ScenarioContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.ValidatableResponse;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResUserRequests {

    /**
     * Variable Declarations
     */
    private final ScenarioContext context;
    private final Scenario scenario;
    private List<Map<String, Integer>> pageList;


    /**
     * Dependency Injection Using cucumber-picocontainer
     */
    public ReqResUserRequests(ScenarioContext context) {
        this.context = context;
        this.scenario = context.scenario;
    }

    /**
     * Step Definitions
     */

    @When("reqres.in website receives list users request for a page")
    public void reqres_in_website_receives_list_users_request_for_a_page(io.cucumber.datatable.DataTable dataTable) {
        pageList = dataTable.asMaps(String.class, Integer.class);

        for (Map<String, Integer> m : pageList) {
            context.requestSpecification = given().baseUri(context.BASE_URL);

            context.response = context.requestSpecification
                    .filter(new RequestLoggingFilter(context.printStream))
                    .queryParam("page", m.get("page number"))
                    .get("/api/users");

            //Log Request details to Cucumber report
            context.printStream.flush();
            scenario.log(context.baos.toString());
            context.baos.reset();

            //Log Response details to Cucumber report
            scenario.log(context.response.body().prettyPrint());

            //For all requests, Add responses in the list
            context.validatableResponse = context.response.then();
            context.validatableResponseList.add(context.validatableResponse);
        }
    }

    @Then("reqres returns status {int}")
    public void reqres_returns_status(Integer status) {
        for (ValidatableResponse vr : context.validatableResponseList) {
            vr.assertThat().statusCode(status);
        }
    }

    @Then("reqres returns list of users with user data")
    public void reqres_returns_list_of_users_with_user_data() {
        for (ValidatableResponse vr : context.validatableResponseList) {
            vr.assertThat().body("page", equalTo(pageList
                    .get(context.validatableResponseList.indexOf(vr))
                    .get("page number")));
        }
    }

}
