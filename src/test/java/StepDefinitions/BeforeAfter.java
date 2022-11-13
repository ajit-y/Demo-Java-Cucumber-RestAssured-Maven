package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeAfter {

    private Scenario scenario;
    private final ScenarioContext context;

    public BeforeAfter(ScenarioContext context ) {
        this.context = context;
    }

    @Before
    public void beforeHook(Scenario scenario) {
        context.scenario = scenario;
        this.scenario = context.scenario;
    }

    @After
    public void afterHook() {
        scenario.log("Scenario completed: " + !scenario.isFailed());
    }

}
