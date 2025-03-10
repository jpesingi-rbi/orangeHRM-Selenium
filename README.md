# 🚀 Selenium Test Automation Framework

This is a **Selenium Test Automation Framework** built using **Java, TestNG, and Extent Reports**. It supports UI test automation, generates detailed test reports, and can be extended for CI/CD integration.

## 📌 Tech Stack
- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Extent Reports**
- **Maven (Dependency Management)**

---

## 📂 Project Structure
📁 src/test/java
│── 📁 base                # Base Test setup (ExtentReports, WebDriver)
│── 📁 pages               # Page Object Model (POM) classes
│── 📁 tests               # Test classes (TestNG)
│── ExtentManager.java     # Manages Extent Reports instance
│── BaseTest.java          # Setup & teardown for tests
│── testng.xml             # TestNG suite configuration
📁 src/main/resources
│── config.properties      # Application URLs, credentials, etc.
📁 test-output
│── ExtentReport.html      # Generated test report (after execution)
📁 pom.xml                 # Maven dependencies & build configurations
