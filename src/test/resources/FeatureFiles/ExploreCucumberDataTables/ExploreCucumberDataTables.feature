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
    When There is a data table in shape of List of Maps
      | Series Name          | Book Title |
      | Beast Quest Series 1 | Ferno      |
      | Beast Quest Series 1 | Sepron     |
      | Beast Quest Series 1 | Arcta      |
      | Beast Quest Series 1 | Tagus      |
      | Beast Quest Series 1 | Nanook     |
      | Beast Quest Series 1 | Epos       |
      | Beast Quest Series 2 | Zepha      |
      | Beast Quest Series 2 | Claw       |
      | Beast Quest Series 2 | Soltra     |
      | Beast Quest Series 2 | Vipero     |
      | Beast Quest Series 2 | Arachnid   |
      | Beast Quest Series 2 | Trillion   |
    Then List<Map<String, String>> can be used in this way to process data

  Scenario: Data Table in shape Map<String, String>
    When There is a data table in shape of Map
      | Beast Quest Series 1 Title1 | Ferno    |
      | Beast Quest Series 1 Title2 | Sepron   |
      | Beast Quest Series 1 Title3 | Arcta    |
      | Beast Quest Series 1 Title4 | Tagus    |
      | Beast Quest Series 1 Title5 | Nanook   |
      | Beast Quest Series 1 Title6 | Epos     |
      | Beast Quest Series 2 Title1 | Zepha    |
      | Beast Quest Series 2 Title2 | Claw     |
      | Beast Quest Series 2 Title3 | Soltra   |
      | Beast Quest Series 2 Title4 | Vipero   |
      | Beast Quest Series 2 Title5 | Arachnid |
      | Beast Quest Series 2 Title6 | Trillion |
    Then Map<String, String> can be used in this way to process data

  Scenario: Data Table in shape Map<String,List<String>>
    When There is a data table in shape of Maps
      | Beast Quest Series 1 Titles | Ferno | Sepron | Arcta  | Tagus  | Nanook   | Epos     |
      | Beast Quest Series 2 Titles | Zepha | Claw   | Soltra | Vipero | Arachnid | Trillion |
    Then Map<String, List<String>> can be used in this way to process data

  Scenario: Data Table containing Integers using Lists
    When Add two numbers using Lists
      | 1    | 2    |
      | 3    | 4    |
    Then Check result using Lists
      | 3      |
      | 7      |

  Scenario: Data Table containing Integers using Maps
    When Add two numbers using Maps
      | num1 | num2 |
      | 1    | 2    |
      | 3    | 4    |
    Then Check result using Maps
      | result |
      | 3      |
      | 7      |