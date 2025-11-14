# QA Automation Test

## Technologies
- **Java 17**
- **Maven** - Project builder
- **Selenium WebDriver** - Browser automation
- **Cucumber** - BDD framework
- **JUnit 5** - Test runner
- **Log4j** - Logging
- **Hamcrest** - Assertions
- **FluentWait** - Smart waits

## Test Cases (Chrome, Edge, (Firefox supported))

### UC-1: Empty credentials validation
- Enter credentials
- Clear both fields
- Click Login
- Validate error

### UC-2: Missing password validation
- Enter credentials
- Clear password field only
- Click Login
- Validate error

### UC-3: Successful login
- Enter valid credentials
- Click Login
- Validate title

## Reports

- **Logs**: `target/logs/test-execution.log`
- **HTML Report**: `target/cucumber-report.html`