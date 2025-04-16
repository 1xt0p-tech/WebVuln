import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WebApp webApp = new WebApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Thread.sleep(500); // 0.5-second pause before menu
            } catch (InterruptedException e) {
                System.out.println("Pause interrupted.");
            }
            System.out.println("\n=== Web Application Vulnerability ===");
            System.out.println("Choose a module to explore:");
            System.out.println("1. SQL Injection Attack");
            System.out.println("2. XSS Attack");
            System.out.println("3. Vulnerability Scanning");
            System.out.println("4. Attack Pattern Detection");
            System.out.println("5. Full Vulnerability Scan");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new SqlInjection(webApp).run();
                    break;
                case 2:
                    new Xss(webApp).run();
                    break;
                case 3:
                    new VulnerabilityDetection(webApp).run();
                    break;
                case 4:
                    new AttackDetection().run();
                    break;
                case 6:
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                case 5:
                    new FullVulnerabilityScan(webApp).run();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}