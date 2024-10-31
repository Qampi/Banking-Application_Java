import java.util.Scanner;

public class Main {
    static String name;  // username
    static String pin;  // password
    static double cb;  // current balance

    public static void main(String[] args) {
        System.out.println("Welcome to the online banking application");
        signin();
    }

    public static void signin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please create your username: ");
        name = scanner.nextLine();

        while (true) {
            System.out.print("Please create your 4-digit PIN: ");
            pin = scanner.nextLine();
            if (pin.length() == 4 && pin.matches("\\d+")) {
                System.out.print("Confirm your 4-digit PIN: ");
                String confirmPin = scanner.nextLine();
                if (pin.equals(confirmPin)) {
                    break;
                } else {
                    System.out.println("PINs do not match. Please try again.");
                }
            } else {
                System.out.println("The PIN has to be 4 digits.");
            }
        }

        cb = 0.0;  // initialize current balance to 0
        System.out.println("Account created successfully.");

        // Call the main menu function after signin
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    deposit(scanner);
                    break;
                case "2":
                    withdraw(scanner);
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using our banking application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // consume newline left-over
        cb += amount;
        System.out.println("Deposit successful. New balance: R" + cb);
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // consume newline left-over
        if (amount <= cb) {
            cb -= amount;
            System.out.println("Withdrawal successful. New balance: R" + cb);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public static void checkBalance() {
        System.out.println("Your current balance is: R" + cb);
    }
}