package StepDefinitions.TestWithWiremock.RequestBodyObjects;

import java.util.List;

public class WmRequestBody {
    private Boolean testingWithWiremock;
    private List<String> requestTypesTested = null;

    /**
     * No args constructor for use in serialization
     */
    public WmRequestBody() {
    }

    public WmRequestBody(Boolean testingWithWiremock, List<String> requestTypesTested) {
        this.testingWithWiremock = testingWithWiremock;
        this.requestTypesTested = requestTypesTested;
    }

    public Boolean getTestingWithWiremock() {
        return testingWithWiremock;
    }

    public void setTestingWithWiremock(Boolean testingWithWiremock) {
        this.testingWithWiremock = testingWithWiremock;
    }

    public List<String> getRequestTypesTested() {
        return requestTypesTested;
    }

    public void setRequestTypesTested(List<String> requestTypesTested) {
        this.requestTypesTested = requestTypesTested;
    }
}
