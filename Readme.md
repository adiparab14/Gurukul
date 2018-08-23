# Gurukul Application Automated Testing

This project is developed for functional and regression testing of the application.

## Test Approach and Framework

- The project is developed using Java and Selenium Automation Framework. TestNG is used as the testing framework. Based on TestNG groups a specific set of test cases can be excuted. 
- Page Object Model (POM) design pattern is used to separate the WebElements, Page Methods and the Test execution.
- Log4j is used for logging and execution logs are present in the file test.log
- Some test cases are created as independent and some are dependent on each other. This has been done deiberately as an example.
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) is used to manage binaries for driver files for browsers using maven. This reduces the hassle to download individual browser binaries. 

## Test Cases
Following test cases have been executed

| Sr No  | Test Case Description |Result|
| ------ | ------------- |--------------|
| 1| Login - Valid Login|Passed|
| 2| Login - Invalid Login|Passed|
| 3| Login - Invalid Registration|Passed|
| 4| Accounts - Valid Settings Save|Passed|
| 5| Account - Invalid Settings Save|Passed|
| 6| Account - Invalid Password Reset |Passed|
| 7| Account - Invalidate Session |Passed|
| 8| Branch - Create Branch|Passed|
| 9| Branch - Edit Branch|Passed|
| 10| Branch - Delete Branch|Passed|
| 11| Staff - Create Staff|Passed|
| 12| Staff - Edit Staff|Passed|
| 13| Staff - Update Staff|Passed|


## Pre-requisites
All the required dependencies are mentioned in the POM. Maven compiler is used for compilation of code and maven surefire plugin for test execution.

__Step 1: Install Maven 3.0.3+__
[Download from here](http://maven.apache.org/download.html)

__Step 2: Ensure maven binaries are on your PATH (ie. you can run `mvn` from anywhere)__

Follow the installation instructions from [here](http://maven.apache.org/download.html#Installation).

__Step 3: Running Tests__
Run the following command in the root folder of the project
```
mvn test
``` 

## Issues Identified
- Registration of new user fails.
- Password change does not work.
- Sometimes, branch does not get deleted or edited. This can cause Edit and Delete Branch test cases to fail.

## Improvements that can be made
- Test cases can be made data driven.
- Negative test scenarios can be added.
- Screenshot functionality can be added in case of failure.