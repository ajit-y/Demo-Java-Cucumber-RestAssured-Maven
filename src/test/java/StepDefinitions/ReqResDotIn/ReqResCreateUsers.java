package StepDefinitions.ReqResDotIn;

import StepDefinitions.ReqResDotIn.RequestBodyObjects.User;
import StepDefinitions.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ReqResCreateUsers {

    /**
     * Variable Declarations
     */
    private List<Map<String, String>> userDataList;
    private final ScenarioContext context;
    private User user;

    /**
     * Context setup using dependency injection using cucumber-picocontainer
     */
    public ReqResCreateUsers(ScenarioContext context) {
        this.context = context;
    }

    @When("reqres.in website receives request with name and job details for creating a new user")
    public void reqres_in_website_receives_request_with_name_and_job_details_for_creating_a_new_user(io.cucumber.datatable.DataTable dataTable) {
        userDataList = dataTable.asMaps(String.class, String.class);
        context.initializeValidatableResponseList();

        for (Map<String, String> m : userDataList) {
            user = new User(m.get("name"), m.get("job"));

            context.setRequestSpecification(context.REQRES_BASE_URL);
            context.response = context.sendPostRequest(user, "/api/users");

            context.requestInformationLogging();
            context.responseInformationLogging();

            context.setValidatableResponse(context.response);
            context.validatableResponseListBuilder();
        }
    }

    @Then("reqres response contains user data for new user")
    public void reqres_response_contains_user_data_for_new_user() {

    }

}

