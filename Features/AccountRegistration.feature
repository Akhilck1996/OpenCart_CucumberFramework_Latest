Feature: Succesfull registration to opencart with Valid details

  Scenario: Succesfull registration to opencart with Valid details
    Given user is taken to Registration page on clicking on MyAccount and then on Register link
    When user Enters all the below details
      | FrstName | pudsi      |
      | LstName  | kudsi      |
      | Telphone | 9876543210 |
      | Password | pudsi@123  |
    And clicks on PrivacyPolicy CheckBox
    And Clicks on Contiue button
    Then User account is Succesfully register
