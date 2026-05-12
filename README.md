# Yatra Fare and Calendar Automation

## Assignment
Automate Calendar Handling and Fare Selection on Yatra.com using Selenium WebDriver and Java.

## Objective
Automate the selection of travel dates with the lowest fare from the Yatra calendar using Selenium WebDriver and Java.

---

# Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Eclipse IDE

---

# Website Under Test
Yatra Website:
https://www.yatra.com

---

# Assignment Requirements Implemented

## Completed Functionalities
- Launch Yatra.com
- Handle initial pop-ups using WebDriverWait
- Open departure date calendar
- Capture lowest fare in current month
- Capture lowest fare in next month
- Compare fares from both months
- Identify overall lowest fare
- Select the lowest fare date dynamically

---

# Project Structure

```text
src/test/java
 └── com.Yatra
      └── YatraTest.java

pom.xml
README.md
```

---

# Maven Dependencies

Dependencies used:
- Selenium Java
- TestNG
- WebDriverManager

---

# How to Run the Project

## Clone Repository

```bash
git clone https://github.com/devi1129/YatraFareandCalendarAutomation.git
```

## Navigate to Project

```bash
cd YatraFareandCalendarAutomation
```

## Run Using Maven

```bash
mvn test
```

---

# Features Implemented

## Calendar Automation
- Opened Yatra departure calendar
- Extracted fare prices dynamically
- Compared fares across months
- Selected the lowest available fare

## Synchronization Handling
- Used WebDriverWait
- Managed dynamic elements and pop-ups

## Dynamic XPath Handling
- Used dynamic XPath for month and fare selection
- Handled calendar traversal between current and next month

---

# Expected Outcome Achieved

- Calendar opens successfully
- Lowest fare identified in current month
- Lowest fare identified in next month
- Overall minimum fare identified across both months
- Appropriate date selected dynamically

---

# GitHub Repository

Repository Link:
https://github.com/devi1129/YatraFareandCalendarAutomation

---

# Author
Devi P

---


