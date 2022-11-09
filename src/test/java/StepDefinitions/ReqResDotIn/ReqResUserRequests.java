package StepDefinitions.ReqResDotIn;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResUserRequests {
    ReqResScenarioContext context;
    Scenario scenario;

    //Dependency Injection Using cucumber-picocontainer
    public ReqResUserRequests(ReqResScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeHook(Scenario s) {
        this.scenario = s;
        context._REQ_SPEC = given().baseUri(context.BASE_URL);
    }

    @After
    public void afterTestRun() {
        scenario.log("Scenario completed: " + !scenario.isFailed());
    }


    @When("reqres.in website receives list users request for a page")
    public void reqres_in_website_receives_list_users_request_for_a_page() {
        context._RESP = context._REQ_SPEC.when().get("\n" +
                "/api/users?page=2");
        scenario.log(context._RESP.body().prettyPrint());
    }

/*
    @When("reqres.in website receives list users request for a page")
    public void reqres_in_website_receives_list_users_request_for_a_page(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.



    }
 */

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
