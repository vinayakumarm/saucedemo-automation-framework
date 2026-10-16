# SauceDemo Automation Framework

UI and API test automation for https://www.saucedemo.com and https://reqres.in, built with Java, Selenium WebDriver, TestNG, REST Assured and Maven, using the Page Object Model.

## Tech Stack
Java | Selenium WebDriver | TestNG | REST Assured | Maven | Firefox (geckodriver)

## Test Scenarios
- Login: valid, invalid and locked-out users
- Inventory: product count, sort by price low to high
- Cart: add and remove product
- Checkout: enter details, complete the order, confirmation message
- Logout
- API: list users, single user, user not found, create user

## Requirements
- Java 17 or higher
- Firefox browser
- geckodriver.exe placed in a folder named Softwares1 in the project root (not included in this repo)

## How to Run
mvn clean test