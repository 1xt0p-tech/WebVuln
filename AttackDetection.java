import java.util.Scanner;

public class AttackDetection {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Attack Pattern Detection ===");
        System.out.println("Description: This module scans inputs for signs of attacks like SQL Injection or XSS. It looks for suspicious patterns, like script tags or SQL keywords, to catch hackers early. You'll enter inputs to see if they're flagged as dangerous.");
        System.out.println("Check attack detection by entering a malicious input like <script>alert('XSS')</script> or ' OR 1=1 --, or a normal input like 'Hello world'.");
        System.out.print("Enter an input to check: ");
        String input = scanner.nextLine();

        System.out.println("\nAnalyzing input...");
        try {
            Thread.sleep(1500); // 1.5-second pause
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }
        detectAttack(input);
    }

    private void detectAttack(String input) {
        if (input.contains("<script>") || input.contains("OR 1=1")) {
            System.out.println("Potential attack detected: " + input);
            System.out.println("Reason: Contains suspicious patterns (e.g., script tags or SQL keywords).");
        } else {
            System.out.println("Input seems normal: " + input);
        }
    }
}