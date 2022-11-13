package StepDefinitions.ExploreCucumberDataTables;

import StepDefinitions.ScenarioContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ExploreDataTables {

    private final Scenario scenario;

    private String seriesName;
    private String seriesOneTitles;
    private String seriesTwoTitles;

//    private List<List<Integer>> t;
//    private List<Integer> sum;
    private List<Map<String, Integer>> dataTableAsListOfMapsWithInteger;
    private List<Map<String, Integer>> sumOfIntegersFromMap;

    private List<String> dataTableAsList;
    List<List<String>> dataTableAsListOfList;

    //Dependency Injection Using cucumber-picocontainer
    public ExploreDataTables(ScenarioContext context) {
        this.scenario = context.scenario;
    }

    @When("There is a data table in shape of List")
    public void there_is_a_data_table_in_shape_of_list(io.cucumber.datatable.DataTable dataTable) {
        dataTableAsList = dataTable.asList();
        scenario.log("This is what the table looks like as List " + dataTableAsList.toString());
    }

    @Then("List<String> can be used in this way to process data")
    public void list_string_can_be_used_in_this_way_to_process_data() {
        for (String s : dataTableAsList) {
            scenario.log("Now checking each title from the table: " + s);
        }
    }

    @When("There is a data table in shape of List of List")
    public void there_is_a_data_table_in_shape_of_list_of_list(io.cucumber.datatable.DataTable dataTable) {

        dataTableAsListOfList = dataTable.asLists(String.class);
        scenario.log("This is what the table looks like as List " + dataTableAsListOfList.toString());
    }

    @Then("List<List<String>> can be used in this way to process data")
    public void list_list_string_can_be_used_in_this_way_to_process_data() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Add two numbers")
    public void add_two_numbers(io.cucumber.datatable.DataTable dataTable) {

//        t = dataTable.asLists(Integer.class);
//        System.out.println(t.get(0));
//        System.out.println(t.get(1));
//        System.out.println(t.size());

        dataTableAsListOfMapsWithInteger = dataTable.asMaps(String.class, Integer.class);
        scenario.log("This is what the table looks like as List of Maps " + dataTableAsListOfMapsWithInteger.toString());
        for (Map<String, Integer> columns : dataTableAsListOfMapsWithInteger) {
            scenario.log("Now displaying num1 values from row " + dataTableAsListOfMapsWithInteger.indexOf(columns) + " from the table: " + columns.get("num1"));
            scenario.log("Now displaying num2 values from row " + dataTableAsListOfMapsWithInteger.indexOf(columns) + " from the table: " + columns.get("num2"));
        }
    }

    @Then("Check result")
    public void checkResult(io.cucumber.datatable.DataTable dataTable) {

        sumOfIntegersFromMap = dataTable.asMaps(String.class, Integer.class);
        scenario.log("This is what the table looks like as List of Maps " + sumOfIntegersFromMap.toString());

        for (Map<String, Integer> resultMap : sumOfIntegersFromMap) {
            assertThat(resultMap.get("result"), equalTo(
                    dataTableAsListOfMapsWithInteger.get(sumOfIntegersFromMap.indexOf(resultMap)).get("num1")
                            + dataTableAsListOfMapsWithInteger.get(sumOfIntegersFromMap.indexOf(resultMap)).get("num2")));
        }

//        sum = d.asList(Integer.class);
//        for (int i= 0; i < t.size(); i++) {
//            int a = t.get(i).get(0) + t.get(i).get(1);
//            System.out.println(a);
//            System.out.println(sum.get(i));
//            assertThat(a, equalTo(sum.get(i)));
//        }

    }

}
