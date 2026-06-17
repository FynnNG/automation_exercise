# Automation Exercise UI Tests (Selenium + Java + TestNG)

This repository contains UI test automation for the demo e‑commerce website [Automation Exercise](https://automationexercise.com), using **Selenium WebDriver**, **Java**, and **TestNG**.

The project covers core user flows such as login, browsing products, adding items to the cart, and placing an order.

---

## Chosen User Journeys

After reviewing https://automationexercise.com, I would consider these six user journeys the most important from a regression and business‑value perspective:

1. **User registration (sign up)**
   - New user creates an account via the Signup/Login page.
2. **User login and logout**
   - Existing user logs in with valid credentials and logs out successfully.
3. **Browse products and view product details**
   - User opens the Products page, searches/filters products, and views product details.
4. **Add products to cart and view cart**
   - User adds one or more products to the cart and verifies the cart contents.
5. **Checkout and place order (logged‑in user)**
   - Logged‑in user proceeds from cart to checkout, confirms address, enters payment details, and completes an order.
6. **Contact form submission**
   - User submits a message via the Contact Us form and sees a confirmation.

These cover core e‑commerce flows: account lifecycle, product discovery, cart, and checkout, plus a key support channel (contact form).

---

## Four Journeys Selected for Automation (and Why)

From the six above, I would script the following four first:

1. **User registration (sign up)**
2. **User login and logout**
3. **Add products to cart and view cart**
4. **Checkout and place order (logged‑in user)**

### Reasons for choosing these four

- **High business impact:**  
  Registration, login, cart, and checkout are critical for any e‑commerce site; if any of these break, users cannot complete purchases.
- **Good end‑to‑end coverage:**  
  These flows together reflect a realistic customer journey: sign up → log in → add to cart → place order.
- **Stable, repeatable behavior:**  
  These features are core to the site and less likely to be purely cosmetic or experimental, making them good candidates for regression tests.
- **Strong ROI for regression:**  
  Automating these scenarios significantly reduces manual regression effort around every deployment while providing fast feedback if critical flows break.
- **Expandable foundation:**  
  Once these are in place, it is straightforward to extend the framework to other flows such as product search, filtering, or contact form submission by reusing the same page objects and utilities.

---

## Chosen Framework and Programming Language

### Programming language: **Java**

**Reasons:**

- Java is widely used in QA/automation teams and has excellent support for Selenium WebDriver and TestNG/JUnit.
- Rich ecosystem (Maven/Gradle, reporting tools, CI plugins) makes it easy to integrate with build pipelines and reporting dashboards.
- Good support in IntelliJ IDEA and other IDEs, which improves productivity and debugging.

### Framework / libraries

- **Selenium WebDriver 4.x** for browser automation.
- **TestNG** as the test framework.
- **Maven** for dependency management and running tests.
- **Page Object Model (POM)** as the design pattern for structuring page interactions.

**Why this combination:**

- **Selenium WebDriver** is the de‑facto standard for UI automation across multiple browsers.
- **TestNG** provides flexible test configuration, data‑driven tests, parallel execution, and rich reporting.
- **Maven** makes dependency management and CI/CD integration straightforward (`mvn test` works out‑of‑the‑box in most CI systems).
- **Page Object Model** separates test logic from UI element locators, making tests easier to read, maintain, and update when the UI changes.

This stack is a common, proven pattern for Selenium‑based regression suites and is easy for other QA engineers to understand and extend.

---

## Basic Framework Design (from Scratch)

The framework is structured around:

- **Page Objects** for each major page.
- **Test classes** grouped by feature or user journey.
- A **BaseTest** to handle WebDriver setup/teardown and shared utilities.

### Key components

1. **BaseTest**
   - Initializes and quits WebDriver (e.g. ChromeDriver) in `@BeforeMethod` / `@AfterMethod`.
   - Applies common browser configuration (window size, timeouts).
   - Provides utility methods such as navigation helpers or handling overlays.

2. **Page Objects**
   - Each page object stores locators as private fields.
   - Exposes high‑level methods that represent user actions (e.g. `login()`, `addFirstProductToCart()`, `proceedToCheckout()`).
   - Avoids direct WebDriver calls in test classes, following POM best practices.

3. **Test classes**
   - Each test class focuses on a feature or journey (e.g. `CheckoutTests`).
   - Tests call page object methods to implement scenarios, keeping test code readable and behavior‑driven.

---

## High‑level Scripts for the Four Journeys

### 1. User registration (sign up)

**Test class:** `RegistrationTests`  
**Scenario:** Register a new user.

Steps:

1. Open home page.
2. Click **Signup / Login**.
3. Enter name and email in the **New User Signup** section.
4. Fill in required registration fields (password, address, etc.).
5. Submit the form.
6. Verify that the user is logged in (e.g. “Logged in as <username>” visible).

This ensures new users can successfully create accounts, which is the entry point for many other flows.

---

### 2. User login and logout

**Test class:** `LoginTests`  
**Scenario:** Log in with valid credentials and log out.

Steps:

1. Open home page.
2. Click **Signup / Login**.
3. Enter valid email and password.
4. Click **Login**.
5. Verify that login was successful (e.g. “Logged in as <username>” visible).
6. Click **Logout**.
7. Verify that the user is redirected back to the login page and is no longer logged in.

This validates both authentication and session termination.

---

### 3. Add products to cart and view cart

**Test class:** `CartTests`  
**Scenario:** Add a product to the cart and verify cart contents.

Steps:

1. From home page, navigate to **Products**.
2. Add the first product to the cart.
3. Navigate to the **Cart** page.
4. Verify that at least one product row is displayed in the cart table.
5. Optionally check product name, quantity, and price.

This ensures the cart mechanism is working and that items persist correctly.

---

### 4. Checkout and place order (logged‑in user)

**Test class:** `CheckoutTests`  
**Scenario:** Place an order after logging in.

Steps:

1. Log in as an existing user.
2. Navigate to **Products** and add a product to the cart.
3. Go to the **Cart** page and verify items exist.
4. Click **Proceed To Checkout**.
5. Verify that address details and order review sections are visible.
6. Click **Place Order**.
7. Enter payment details (card name, number, CVC, expiry).
8. Submit the payment.
9. Verify that a success message/confirmation is displayed.

This scenario verifies the most critical end‑to‑end business flow: a logged‑in user can successfully complete a purchase.

---

## GitHub Repository

All framework code, page objects, tests, and documentation (including answers to these questions) are stored in this repository.

**Repository URL:**  
https://github.com/FynnNG/automation_exercise

The repository is shareable and can be reviewed by the hiring team.
