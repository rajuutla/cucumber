

@tag
Feature: Login Feature
  Validate the login feature
  
# Added the @Before, @After methods in the CommonSharedData file which is shared between multiple step defs using picocontainer

  @tag1
  Scenario: Valid login test
    When Enter the username "tutorial"
    And Enter the password "tutorial"
    And Click on SignIn button
    Then Login should be successful

  @tag2
  Scenario Outline: Invalid login test
   	When Enter the username "tutorial"
    And Enter the password "tutorial"
    And Click on SignIn button
    Then Login should be successful

   
