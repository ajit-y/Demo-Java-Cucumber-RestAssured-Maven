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

    /**
     * Variable Declarations
     */
    private final Scenario scenario;
    private List<List<Integer>> listOfIntegersForAddition;
    private List<Map<String, Integer>> dataTableAsListOfMapsWithInteger;
    private List<String> dataTableAsList;
    private List<List<String>> dataTableAsListOfLists;
    private List<Map<String, String>> dataTableAsListOfMaps;
    private Map<String, String> dataTableAsMaps;
    private Map<String, List> dataTableAsMapOfLists;

    /**
     * Dependency Injection Using cucumber-picocontainer
     */
    public ExploreDataTables(ScenarioContext context) {
        this.scenario = context.scenario;
    }

    /**
     * Step Definitions
     */

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

        dataTableAsListOfLists = dataTable.asLists(String.class);
        scenario.log("This is what the table looks like as List of Lists " + dataTableAsListOfLists.toString());
    }

    @Then("List<List<String>> can be used in this way to process data")
    public void list_list_string_can_be_used_in_this_way_to_process_data() {
        for (List<String> l : dataTableAsListOfLists) {
            scenario.log("Now listing each title for series: " + l.get(0));
            for (String s : l.subList(1, l.size() - 1)) {
                scenario.log(s);
            }
        }
    }

    @When("There is a data table in shape of List of Maps")
    public void there_is_a_data_table_in_shape_of_list_of_maps(io.cucumber.datatable.DataTable dataTable) {
        dataTableAsListOfMaps = dataTable.asMaps(String.class, String.class);
        scenario.log("This is what the table looks like as List of Maps " + dataTableAsListOfMaps.toString());
    }

    @Then("List<Map<String, String>> can be used in this way to process data")
    public void list_map_string_string_can_be_used_in_this_way_to_process_data() {
        scenario.log("Now listing titles for series: ");
        for (Map<String, String> m : dataTableAsListOfMaps) {
            scenario.log("series: " + m.get("Series Name") + " - " + "Title: " + m.get("Book Title"));
        }
    }

    @When("There is a data table in shape of Map")
    public void there_is_a_data_table_in_shape_of_map(io.cucumber.datatable.DataTable dataTable) {
        dataTableAsMaps = dataTable.asMap(String.class, String.class);
        scenario.log("This is what the table looks like as Maps " + dataTableAsMaps.toString());

    }

    @Then("Map<String, String> can be used in this way to process data")
    public void map_string_string_can_be_used_in_this_way_to_process_data() {
        for (String k : dataTableAsMaps.keySet()) {
            scenario.log(k + " : " + dataTableAsMaps.get(k));
        }
    }

    @When("There is a data table in shape of Maps")
    public void there_is_a_data_table_in_shape_of_maps(io.cucumber.datatable.DataTable dataTable) {
        dataTableAsMapOfLists = dataTable.asMap(String.class, List.class);
        scenario.log(dataTableAsMapOfLists.toString());
    }

    @Then("Map<String, List<String>> can be used in this way to process data")
    public void map_string_list_string_can_be_used_in_this_way_to_process_data() {
        for (String k : dataTableAsMapOfLists.keySet()) {
            scenario.log(k + " : " + dataTableAsMapOfLists.get(k));
            scenario.log("Name of each book: ");
            for (int i = 0; i < dataTableAsMapOfLists.get(k).size(); i++) {
                scenario.log(dataTableAsMapOfLists.get(k).get(i).toString());
            }
        }
    }

    @When("Add two numbers using Lists")
    public void add_two_numbers_using_lists(io.cucumber.datatable.DataTable dataTable) {
        listOfIntegersForAddition = dataTable.asLists(Integer.class);
        scenario.log("First sum: " + listOfIntegersForAddition.get(0).get(0).toString() + " + " + listOfIntegersForAddition.get(0).get(1).toString());
        scenario.log("Second sum: " + listOfIntegersForAddition.get(1).get(0).toString() + " + " + listOfIntegersForAddition.get(1).get(1).toString());
    }

    @Then("Check result using Lists")
    public void check_result_using_lists(io.cucumber.datatable.DataTable dataTable) {
        List<Integer> listOfSums = dataTable.asList(Integer.class);

        for (int i = 0; i < listOfIntegersForAddition.size(); i++) {
            int actualSumResult = listOfIntegersForAddition.get(i).get(0) + listOfIntegersForAddition.get(i).get(1);
            scenario.log("Expected result for sum " + (i + 1) + " : " + listOfSums.get(i).toString());
            scenario.log("Actual result for sum " + (i + 1) + " : " + actualSumResult);
            assertThat(actualSumResult, equalTo(listOfSums.get(i)));
        }
    }

    @When("Add two numbers using Maps")
    public void add_two_numbers_using_maps(io.cucumber.datatable.DataTable dataTable) {
        dataTableAsListOfMapsWithInteger = dataTable.asMaps(String.class, Integer.class);
        scenario.log("This is what the table looks like as List of Maps " + dataTableAsListOfMapsWithInteger.toString());
        for (Map<String, Integer> columns : dataTableAsListOfMapsWithInteger) {
            scenario.log("Now displaying num1 values from row " + dataTableAsListOfMapsWithInteger.indexOf(columns) + " from the table: " + columns.get("num1"));
            scenario.log("Now displaying num2 values from row " + dataTableAsListOfMapsWithInteger.indexOf(columns) + " from the table: " + columns.get("num2"));
        }
    }

    @Then("Check result using Maps")
    public void check_result_using_maps(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, Integer>> sumOfIntegersFromMap = dataTable.asMaps(String.class, Integer.class);
        scenario.log("This is what the table looks like as List of Maps " + sumOfIntegersFromMap.toString());

        for (Map<String, Integer> resultMap : sumOfIntegersFromMap) {
            assertThat(resultMap.get("result"), equalTo(dataTableAsListOfMapsWithInteger.get(sumOfIntegersFromMap.indexOf(resultMap)).get("num1") + dataTableAsListOfMapsWithInteger.get(sumOfIntegersFromMap.indexOf(resultMap)).get("num2")));
        }
    }

}
