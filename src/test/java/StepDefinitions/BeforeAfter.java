package StepDefinitions;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.java.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class BeforeAfter {
    private Scenario scenario;
    private final ScenarioContext context;

    public BeforeAfter(ScenarioContext context) {
        this.context = context;
    }

    @BeforeAll
    public static void before_all() {
        System.out.println("Before All: This step executes only once before any scenario is run");
    }

    @AfterAll
    public static void after_all() {
        System.out.println("After All: This step executes only once after all scenarios are run");
    }

    @Before("not @wiremock")
    public void beforeHook(Scenario scenario) {
        context.scenario = scenario;
        this.scenario = context.scenario;
        context.baos = new ByteArrayOutputStream();
        context.printStream = new PrintStream(context.baos);
    }

    @Before("@wiremock")
    public void beforeHookWithWiremock(Scenario scenario) {
        context.scenario = scenario;
        this.scenario = context.scenario;
        context.baos = new ByteArrayOutputStream();
        context.printStream = new PrintStream(context.baos);
        context.wireMockServer = new WireMockServer(options().port(9095));
        context.wireMockServer.start();
    }

    @After("not @wiremock")
    public void afterHook() {
        scenario.log("Scenario completed: " + !scenario.isFailed());
    }

    @After("@wiremock")
    public void afterHookWithWiremock() {
        context.wireMockServer.stop();
        scenario.log("Scenario completed: " + !scenario.isFailed());
    }

}
