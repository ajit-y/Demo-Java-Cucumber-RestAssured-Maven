package StepDefinitions;

import io.cucumber.java.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BeforeAfter {
    private Scenario scenario;
    private final ScenarioContext context;

    public BeforeAfter(ScenarioContext context ) {
        this.context = context;
    }
    @BeforeAll
    public static void before_all() {
        System.out.println("Before All: This step executes only once before any scenario is run");
    }

    @AfterAll
    public static void after_all(){
        System.out.println("After All: This step executes only once after all scenarios are run");
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
