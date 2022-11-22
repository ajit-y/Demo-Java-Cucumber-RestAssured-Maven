package StepDefinitions;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ScenarioContext {
    /**
     * Variables for working with Cucumber Framework
     */
    public Scenario scenario;
    /**
     * Variables for working with Rest Assured Framework
     */
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public List<ValidatableResponse> validatableResponseList;

    public PrintStream printStream;
    public ByteArrayOutputStream baos;

    /**
     * Variables for working with tests for 'reqres.in' website
     */
    public final String BASE_URL = "https://reqres.in/";

}
