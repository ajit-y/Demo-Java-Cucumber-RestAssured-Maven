package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        context.baos = new ByteArrayOutputStream();
        context.printStream = new PrintStream(context.baos);
    }

    @After
    public void afterHook() {
        scenario.log("Scenario completed: " + !scenario.isFailed());
    }

}
