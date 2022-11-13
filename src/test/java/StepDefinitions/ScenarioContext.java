package StepDefinitions;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ScenarioContext {
    /**
     * Variables for working with Cucumber Framework
     */
    public Scenario scenario;
    /**
     * Variables for working with Rest Assured Framework
     */
    public RequestSpecification _REQ_SPEC;
    public Response _RESP;
    public ValidatableResponse _V_RESP;
    /**
     * Variables for working with tests for 'reqres.in' website
     */
    public final String BASE_URL = "https://reqres.in/";

}
