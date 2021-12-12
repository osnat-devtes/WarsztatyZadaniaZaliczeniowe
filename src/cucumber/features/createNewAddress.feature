Feature: Add a new address to the account on my store

  Scenario Outline: user can add an address to his/her account
    Given an open browser with my store website
    When an email <email> and a password <password> areas are filled in
    Then checking if an user has already created at least one address and clicking address button
    And the link should contain 'https://mystore-testlab.coderslab.pl/index.php?controller=addresses'
    When after clicking on Create new address the form is filled in with alias <alias>,address <address>,city <city>,zip/postal <zipCode>,country <country>,phone <phone>
    Then the address container should contain alias <alias>,address <address>,city <city>,zip/postal <zipCode>,country <country>,phone <phone>
    Then erasing the second address and the string should contain 'Address successfully deleted!'
    And close the browser

    Examples:
      |email                       |password                    |alias   |address            |city     |zipCode    |country        |phone    |
      |edqmvgciosxbbrvmhz@kvhrw.com|edqmvgciosxbbrvmhz@kvhrw.com|Address2|Pretty Street 234  |Edinburgh|567890     |United Kingdom |345345621|


