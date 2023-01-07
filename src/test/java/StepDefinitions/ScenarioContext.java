package StepDefinitions;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.Scenario;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;

public class ScenarioContext {
    /**
     * Variables for working with Cucumber Framework
     */
    public Scenario scenario;

    /**
     * Variables for working with Rest Assured Framework
     */
    private RequestSpecification requestSpecification;
    public Response response;
    private ValidatableResponse validatableResponse;
    private List<ValidatableResponse> validatableResponseList;
    public PrintStream printStream;
    public ByteArrayOutputStream baos;

    public WireMockServer wireMockServer;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(String baseUrl) {
        this.requestSpecification = given()
                .baseUri(baseUrl);
    }

    public void setValidatableResponse(Response response) {
        this.validatableResponse = response.then();
    }

    public ValidatableResponse getValidatableResponse() {
        return validatableResponse;
    }

    public void initializeValidatableResponseList() {
        this.validatableResponseList = new ArrayList<>();
    }

    public void validatableResponseListBuilder() {
        validatableResponseList.add(getValidatableResponse());
    }

    public List<ValidatableResponse> getValidatableResponseList() {
        return validatableResponseList;
    }

    public Response sendGetRequest(String queryParamName, Integer queryParamValue, String endPoint) {
        return getRequestSpecification()
                .filter(new RequestLoggingFilter(printStream))
                .queryParam(queryParamName, queryParamValue)
                .get(endPoint);
    }

    public Response sendGetRequest(String queryParamName, String queryParamValue, String endPoint) {
        return getRequestSpecification()
                .filter(new RequestLoggingFilter(printStream))
                .queryParam(queryParamName, queryParamValue)
                .get(endPoint);
    }

    public Response sendPostRequest(Object body, String endPoint) {
        return getRequestSpecification()
                .headers("Cache-Control", "no-cache", "Content-Type", "application/json")
                .body(body)
                .filter(new RequestLoggingFilter(printStream))
                .post(endPoint);
    }

    /**
     * Methods for request and response logging
     */
    public void requestInformationLogging() {
        printStream.flush();
        scenario.log(baos.toString());
        baos.reset();
    }

    public void responseInformationLogging() {
        //Log Response details to Cucumber report
        scenario.log("Response status code: " + response.statusCode());
        scenario.log("Response body: " + response.body().prettyPrint());
    }

    /**
     * Variables for working with tests for 'reqres.in' website
     */
    public final String REQRES_BASE_URL = "https://reqres.in/";

    /**
     * Variables for working with tests with Wiremock
     */
    public final String WIREMOCK_BASE_URL = "http://localhost:9095";
}
