# CodingStandards

## 1. Project Description

This project implements a Student Grade Management System in Java as part of a laboratory on coding standards and automated code quality analysis.

The application manages student information and grades while promoting readability, input validation, and consistent programming practices.

## 2. Objectives

- Apply coding standards to Java source code.
- Identify and correct coding style violations using Checkstyle.
- Validate student information and grades.
- Calculate averages and assign letter grades.
- Determine pass/fail status and Honor Roll eligibility.
- Generate initial and final code quality reports.

## 3. Technologies Used

- Java JDK
- Visual Studio Code
- Checkstyle 10.21.2
- Git and GitHub
- GitHub Actions

## 4. Project Structure

```text
CodingStandards_Java/
├── src/
│   └── Main.java
├── version-inicial/
│   └── Main-inicial.java
├── evidencias/
├── .github/
│   └── workflows/
├── checkstyle.xml
├── checkstyle.jar
├── reports-inicial.html
├── reports-inicial.xml
├── reports-final.html
├── reports-final.xml
├── reports-final.txt
└── README.md
```

## 5. Functional Requirements

The application is designed to:

- Create students with a name and student ID.
- Accept numeric grades between 0 and 100.
- Calculate student averages.
- Assign letter grades:
  - A: 90-100
  - B: 80-less than 90
  - C: 70-less than 80
  - D: 60-less than 70
  - F: below 60
- Mark students as passing when their average is at least 60.
- Identify Honor Roll students with an average of at least 90.
- Remove grades by value or index while handling invalid requests.
- Generate a report containing student ID, name, number of grades, average, letter grade, pass/fail status, and Honor Roll status.

## 6. Compilation and Execution

Open a terminal in the project root and run:

```bash
javac -d out src/Main.java
java -cp out src.Main
```

A compatible Java Development Kit (JDK) must be installed.

## 7. Checkstyle Analysis

Checkstyle analyzes Java source code according to the rules configured in `checkstyle.xml`.

Analyze the initial reference version:

```bash
java -jar checkstyle.jar -c checkstyle.xml version-inicial/Main-inicial.java
```

Generate the initial XML report:

```bash
java -jar checkstyle.jar -c checkstyle.xml -f xml -o reports-inicial.xml version-inicial/Main-inicial.java
```

Analyze the final source code:

```bash
java -jar checkstyle.jar -c checkstyle.xml src/Main.java
```

Generate the final XML report:

```bash
java -jar checkstyle.jar -c checkstyle.xml -f xml -o reports-final.xml src/Main.java
```

## 8. GitHub Actions

GitHub Actions can automate Java compilation and Checkstyle analysis for pushes and pull requests targeting the `main` branch.

Workflow files are stored in:

```text
.github/workflows/
```

Workflow results can be checked in the Actions tab on GitHub.

## 9. Reports and Evidence

The laboratory submission should include:

- Initial and final Checkstyle reports.
- Refactored Java source code.
- Project structure screenshot.
- Initial and final analysis screenshots.
- Compilation and execution screenshot.
- GitHub Actions evidence, if configured.
- Final laboratory report.

Only include reports and evidence that have actually been generated.

## 10. GitHub Repository

https://github.com/caalmora/CodingStandards_Java

## 11. Conclusion

This project demonstrates how automated code quality tools can help enforce coding conventions and improve readability and maintainability. Combining Checkstyle with compilation, functional testing, and continuous integration supports more reliable software development.
