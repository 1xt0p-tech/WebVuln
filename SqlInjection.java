import java.util.Scanner;

public class SqlInjection {
    private WebApp webApp;

    public SqlInjection(WebApp webApp) {
        this.webApp = webApp;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== SQL Injection Attack ===");
        System.out.println("Description: This module shows how SQL Injection can trick a login system. Hackers enter malicious inputs to bypass authentication, accessing accounts without valid credentials. You'll try a normal login and a malicious one to see the difference.");
        System.out.println("Check SQL Injection by entering a malicious username like ' OR 1=1 -- with any password, or use a normal login like username 'admin' with password 'password123'.");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("\nTesting vulnerable login...");
        try {
            Thread.sleep(1500); // 1.5-second pause
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }
        boolean vulnerableResult = webApp.vulnerableLogin(username, password);
        System.out.println("Login result: " + (vulnerableResult ? "Success" : "Failed"));

        System.out.println("\nTesting secure login...");
        try {
            Thread.sleep(1500); // 1.5-second pause
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }
        boolean secureResult = webApp.secureLogin(username, password);
        System.out.println("Login result: " + (secureResult ? "Success" : "Failed"));

        try {
            Thread.sleep(1000); // 1-second pause before explanation
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }
        if (vulnerableResult && !secureResult) {
            System.out.println("Explanation: The vulnerable login allowed access due to SQL Injection, which manipulated the database query. The secure login blocked it by checking credentials properly.");
        } else {
            System.out.println("Explanation: Normal login attempt processed. Try a malicious input like ' OR 1=1 -- to see SQL Injection in action.");
        }
    }
}