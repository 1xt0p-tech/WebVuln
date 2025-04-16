import java.util.Scanner;

public class Xss {
    private WebApp webApp;

    public Xss(WebApp webApp) {
        this.webApp = webApp;
    }

    public void run() {
        System.out.println("DEBUG: Starting XSS run...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== XSS Attack ===");
        System.out.println("Description: This module demonstrates Cross-Site Scripting (XSS), where attackers inject harmful scripts into a web page. These scripts can steal data or trick users. You'll enter a comment, then we'll test multiple XSS vectors to see how the system handles them.");
        System.out.println("Check XSS by entering a malicious script like <script>alert('XSS')</script>, or use a normal comment like 'Great post!'.");
        System.out.print("Enter a comment: ");
        String comment;
        try {
            comment = scanner.nextLine();
            System.out.println("DEBUG: Comment entered: " + comment);
        } catch (Exception e) {
            System.out.println("Error reading comment: " + e.getMessage());
            return;
        }

        System.out.println("\nChecking vulnerable output for your input...");
        try {
            Thread.sleep(1500); // 1.5-second pause
            System.out.println("DEBUG: After vulnerable pause");
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
        String vulnerableHtml = webApp.vulnerableComment(comment);
        boolean userInputVulnerable = vulnerableHtml.contains(comment);
        System.out.println("Vulnerable HTML output: " + vulnerableHtml);
        System.out.println("Result: " + (userInputVulnerable ? "Vulnerable! Your input could execute if malicious." : "Safe"));
        System.out.println("Explanation: In a real web page, unescaped scripts would run, causing harm like alerts or data theft.");

        System.out.println("\nChecking secure output for your input...");
        try {
            Thread.sleep(1500); // 1.5-second pause
            System.out.println("DEBUG: After secure pause");
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
        String secureHtml = webApp.secureComment(comment);
        boolean userInputSafe = !secureHtml.contains("<script>");
        System.out.println("Secure HTML output: " + secureHtml);
        System.out.println("Result: " + (userInputSafe ? "Safe" : "Vulnerable!"));
        System.out.println("Explanation: Escaping special characters prevents script execution.");

        System.out.println("\nChecking additional XSS vectors...");
        try {
            Thread.sleep(1000); // 1-second pause
            System.out.println("DEBUG: After vectors pause");
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
        checkXss("<script>alert('XSS')</script>", "script tag injection");
        checkXss("onerror=alert('XSS')", "event handler injection");
        checkXss("<img src=x onerror=alert('XSS')>", "HTML injection");
        checkSecureComment("<script>alert('XSS')</script>");
        System.out.println("DEBUG: XSS run completed.");
    }

    private void checkXss(String input, String testName) {
        System.out.println("DEBUG: Checking XSS - " + testName);
        System.out.println("- Checking " + testName + " (" + input + ")...");
        try {
            Thread.sleep(1500); // 1.5-second pause
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
        String output = webApp.vulnerableComment(input);
        boolean isVulnerable = output.contains(input);
        System.out.println("  Result: " + (isVulnerable ? "Vulnerable!" : "Safe"));
    }

    private void checkSecureComment(String input) {
        System.out.println("DEBUG: Checking secure comment");
        System.out.println("- Checking secure comment output (" + input + ")...");
        try {
            Thread.sleep(1500); // 1.5-second pause
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
        String output = webApp.secureComment(input);
        boolean isSafe = !output.contains("<script>");
        System.out.println("  Result: " + (isSafe ? "Safe" : "Vulnerable!"));
    }
}