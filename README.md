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
<include the project tree>

---

## 🧪 Example Test
```java
loginPage.login("student", "Password123");
Assert.assertEquals(dashboardPage.getSuccessMessage(), "Logged In Successfully");
