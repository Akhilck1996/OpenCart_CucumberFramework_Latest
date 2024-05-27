Feature: Succesfull login to open using DDT with Excel file

  Scenario Outline: Succesfull login to open using DDT with Excel file
    Given User is taken to login page by clicking on my account and then on login
    Then user is taken to MyAccount page by entering the email and pwd from the excel file with excel row "<row_num>"

    Examples: 
      | row_num |
      |       1 |
      |       2 |
      |       3 |
      |       4 |
      |       5 |
