# Amazon Testing Task

In this task, we are supposed to create Selenium Web browser tests using Java language for  [amazon.com](http://amazon.com/)  with following details:

- Search Nikon and sort results from highest price to slowest.

- Select second product and click it for details.

- From details check (verify with assert) that product topic contains text “Nikon D3X”

Bonus points will be given from:

- Creating Cucumber scenario which is used for test execution/test step mapping.

- Implementing the webpage opening step so that url is parameter

- The test is implemented as Maven project and the test can be executed from command line using command: mvn clean test. Inspector will set suitable path to the Chrome/Firefox drivers.
# Configuration

This code is tested with following configuration:

-   Jdk build 1.8.0_281
-   apache-maven-3.8.2
-   chromedriver 2.41.578737
-   Windows 10
- cucumber-jvm 6.11.0

In order to run the test, run mvn clean test. The configuration has been done such that report is generated under [https://reports.cucumber.io/reports](https://reports.cucumber.io/reports)

