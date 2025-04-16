# WebVuln

WebVuln is a Java-based project designed to detect and analyze web application vulnerabilities. It combines static and dynamic techniques to identify common security flaws like SQL Injection, Cross-Site Scripting (XSS), and more. The project also includes real-time attack detection capabilities, making it suitable for both assessment and monitoring purposes.

## Features

- **Real-time Attack Detection**
- **Static Vulnerability Scanning**
- **SQL Injection Detection**
- **Cross-Site Scripting (XSS) Detection**
- **User and Web Application Management**
- **Modular Design for Easy Integration**

## Project Structure

| File Name                   | Description |
|----------------------------|-------------|
| `Main.java`                | Entry point of the application. |
| `AttackDetection.java`     | Detects ongoing attacks in real time. |
| `FullVulnerabilityScan.java` | Performs a comprehensive scan across all supported vulnerabilities. |
| `SqlInjection.java`        | Handles detection logic for SQL Injection vulnerabilities. |
| `Xss.java`                 | Handles detection logic for XSS vulnerabilities. |
| `User.java`                | Represents a user in the system. |
| `WebApp.java`              | Represents a web application being tested or monitored. |
| `VulnerabilityDetection.java` | Core engine for identifying vulnerabilities. |
| `README.md`                | Project documentation. |

## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/1xt0p-tech/WebVuln.git
   cd WebVuln
   ```

2. **Compile the project**
   ```bash
   javac *.java
   ```

3. **Run the main class**
   ```bash
   java Main
   ```

## Requirements

- Java 8 or higher
- Basic understanding of web security vulnerabilities

## Use Case

This tool can be used by:

- Students learning about web application security
- Security researchers prototyping detection logic

## License

This project is open-source and free to use under the MIT License.

---

> Built with care by [1xt0p-tech](https://github.com/1xt0p-tech)
