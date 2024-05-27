Feature: Succesfull login with valid credentials

  #@sanity @regression
  #Scenario: Succesfull login with valid credentials
    #Given User is taken to login page by clicking on my account and then on login
    #When user enter email as "akhili@gmail.com" and pwd as "akhilmass"
    #And then clicks on login button
    #Then user is taken to MyAccount page

  @regression
  Scenario Outline: Succesfull login to opencart using DDT
    Given User is taken to login page by clicking on my account and then on login
    When user enter email as "<email>" and pwd as "<pwd>"
    And then clicks on login button
    Then user is taken to MyAccount page

    Examples: 
      | email            | pwd       |
      | akhili@gmail.com | akhilmass |
      | akli@gmail.com   | akhiss    |
      | aki@gmail.com    | akhilm    |
