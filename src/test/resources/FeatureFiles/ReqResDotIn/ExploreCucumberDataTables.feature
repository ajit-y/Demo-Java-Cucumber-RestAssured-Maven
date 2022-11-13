@datatables
Feature: Explore Cucumber Data Tables shapes

  Scenario: Data Table in shape of List<String>
    When There is a data table in shape of List
      | Ferno  |
      | Sepron |
      | Arcta  |
      | Tagus  |
      | Nanook |
      | Epos   |
    Then List<String> can be used in this way to process data

  Scenario: Data Table in shape List<List<String>>
    When There is a data table in shape of List of List
      | Beast Quest Series 1 Titles | Ferno | Sepron | Arcta  | Tagus  | Nanook   | Epos     |
      | Beast Quest Series 2 Titles | Zepha | Claw   | Soltra | Vipero | Arachnid | Trillion |
    Then List<List<String>> can be used in this way to process data

  Scenario: Data Table in shape List<Map<String, String>>
    When There is a data table in shape of List of Map
      | Beast Quest Series 1 Titles | Beast Quest Series 2 Titles |
      | Ferno                       | Zepha                       |
      | Sepron                      | Claw                        |
      | Arcta                       | Soltra                      |
      | Tagus                       | Vipero                      |
      | Nanook                      | Arachnid                    |
      | Epos                        | Trillion                    |
    Then List<Map<String, String>> can be used in this way to process data

  Scenario: Data Table in shape Map<String, String>
    When There is a data table in shape of Map
      | Beast Quest Series 1 Titles | Beast Quest Series 2 Titles |
      | Ferno                       | Zepha                       |
      | Sepron                      | Claw                        |
      | Arcta                       | Soltra                      |
      | Tagus                       | Vipero                      |
      | Nanook                      | Arachnid                    |
      | Epos                        | Trillion                    |
    Then Map<String, String> can be used in this way to process data

  Scenario: Data Table in shape Map<String, List<String>>
    When There is a data table in shape of Map with List
      | Beast Quest Series 1 Titles | Beast Quest Series 2 Titles |
      | Ferno                       | Zepha                       |
      | Sepron                      | Claw                        |
      | Arcta                       | Soltra                      |
      | Tagus                       | Vipero                      |
      | Nanook                      | Arachnid                    |
      | Epos                        | Trillion                    |
    Then Map<String, List<String>> can be used in this way to process data

  Scenario: Data Table in shape Map<String, Map<String, String>>
    When There is a data table in shape of Map with Map
      | Beast Quest Series 1 Titles | Beast Quest Series 2 Titles |
      | Ferno                       | Zepha                       |
      | Sepron                      | Claw                        |
      | Arcta                       | Soltra                      |
      | Tagus                       | Vipero                      |
      | Nanook                      | Arachnid                    |
      | Epos                        | Trillion                    |
    Then Map<String, Map<String, String>> can be used in this way to process data

  @test
  Scenario: Data Table containing Integers
    When Add two numbers
      | num1 | num2 |
      | 1    | 2    |
      | 3    | 4    |
    Then Check result
      | result |
      | 3      |
      | 7      |