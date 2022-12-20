# Automation test

**Prerequisites**

1. Java 11 or above should be present and environment variable should be set in the local system.
2. Maven should be present and environment variable should be set in the local system.

### Selenium-Maven-Cucumber-TestNG framework.

* Used maven as it can easily handle the entire lifecycle of a project.
* Added Log4j Api to generate log files.
* Used Allure and cucumber reports.
* Used GSON library to convert Java Objects into their JSON representation and vice versa
### Packages:

#### API Tests

* Test file: `src/test/java/org/example/test/RCBAPIResponseTest.java`
* Model classes - `src/main/java/org/example/test/model/rcbJsonResponse`
* Utils: `src/main/java/org/example/sedin/utilities`


### Maven Project Execution using following command:

To execute->`mvn clean test`

### Report generation:

Run Command after test execution->`allure serve target/allure-results
`  
Allure report path-> target/allure-results


### API Test cases covered:

> Test that validates the RCB cricket team has only 4 foreign players    
> Test that validates the RCB cricket team has at least 1 wicket keeper

### Reporting:

> Allure and cucumber  reports

### Author: Mohammed Yunus F

