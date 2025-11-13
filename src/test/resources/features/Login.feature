Feature: Login on Saucedemo

    @UC-1
    Scenario Outline: Type credentials then clearing both inputs and check the error message
        Given the user opens the browser "<browser>" and access to login page
        When the user enters the username "<username>"
        And clear the username field
        When the user enters the password "<password>"
        And clear the password field
        And clicks the login button
        Then the error message "<errorMessage>" should be displayed
        And close the driver

    Examples:
        | browser | username        | password       | errorMessage                       |
        | chrome  | standard_user   | secret_sauce   | Epic sadface: Username is required |
        | edge    | standard_user   | secret_sauce   | Epic sadface: Username is required |

    @UC-2
    Scenario Outline: Type credentials then clearing the password field and check the error message
        Given the user opens the browser "<browser>" and access to login page
        When the user enters the username "<username>"
        When the user enters the password "<password>"
        And clear the password field
        And clicks the login button
        Then the error message "<errorMessage>" should be displayed
        And close the driver

    Examples:
        | browser | username        | password       | errorMessage                       |
        | chrome  | standard_user   | secret_sauce   | Epic sadface: Password is required |
        | edge    | standard_user   | secret_sauce   | Epic sadface: Password is required |

    @UC-3
    Scenario Outline: Type credentials, login and validate the title
        Given the user opens the browser "<browser>" and access to login page
        When the user enters the username "<username>"
        When the user enters the password "<password>"
        And clicks the login button
        Then the user should see the title "<title>"
        And close the driver

    Examples:
        | browser | username        | password       | title     |
        | chrome  | standard_user   | secret_sauce   | Swag Labs |
        | edge    | standard_user   | secret_sauce   | Swag Labs |