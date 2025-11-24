# Selenium POM Framework (Java + TestNG)

This project demonstrates a professional automation framework using:
- Selenium WebDriver  
- TestNG  
- Page Object Model (POM)  
- Java  

The framework tests the login functionality of a real practice website:
https://practicetestautomation.com/practice-test-login/

---

## 🚀 Valid Test Credentials
- Username: student  
- Password: Password123  

---

## 📁 Project Structure
selenium-pom-framework/  
│  
├── src/main/java/com/sachalsain/selenium/pom/framework  
│   ├── pages/  
│   │   ├── LoginPage.java  
│   │   └── DashboardPage.java  
│   │  
│   └── base/  
│       └── BaseTest.java  
│  
├── src/test/java/com/sachalsain/selenium/pom/framework  
│   ├── tests/  
│   │   ├── LoginTests.java  
│	│   └── AdvancedLoginTests.java  
│   ├── utils/  
│   │   └── ScreenshotUtil.java  
│   └── listeners/  
│       └── TestListener.java  
│  
└── README.md  

## 📈 What I Learned from This Task
✔️ Real working automation
✔️ Real selectors
✔️ Valid credentials
✔️ Screenshot on failure
✔️ TestNG listener
✔️ Multiple layers of assertions
✔️ Professional reporting structure


✅ Task Completed: Logging Added (SLF4J + Logback)
### 📈 What I Learned from This Task
✔ Console + file logging.
✔ Logs saved in /logs/test-execution.log
✔ Structuring a basic TestNG test suite.
✔ Practicing GitHub project documentation for employers.

---

## 🧪 Example Test
```java
loginPage.login("student", "Password123");
Assert.assertEquals(dashboardPage.getSuccessMessage(), "Logged In Successfully");
