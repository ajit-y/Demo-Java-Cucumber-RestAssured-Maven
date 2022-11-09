package StepDefinitions.ReqResDotIn;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ReqResScenarioContext {
    protected Scenario scenario;
    protected final String BASE_URL = "https://reqres.in/";
    protected RequestSpecification _REQ_SPEC;
    protected Response _RESP;
    protected ValidatableResponse _V_RESP;
}
