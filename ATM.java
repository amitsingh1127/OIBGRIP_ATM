import java.util.Scanner;
// This Code Is Written By Amit Kumar Under The Internship Program Of Oasis Infobyte In Java Programming//

public class ATM {
    private double balance;
    private int pin;
    private String transactionHistory = "";

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory += "Deposit: Rs." + amount + "\n";
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory += "Withdrawal: Rs." + amount + "\n";
        }
    }

    public String getTransactionHistory() {
        return transactionHistory;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(5000.00, 1234);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Oasis Bank ATM. Please enter your PIN:");
        int pin = scanner.nextInt();

        if (!atm.validatePin(pin)) {
            System.out.println("Invalid PIN.");
            System.exit(1);
        }

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Check balance"); // Select this to checking the balance 
            System.out.println("2. Deposit"); // Select this to deposit the money 
            System.out.println("3. Withdraw"); // Select this to withdraw the money
            System.out.println("4. Transaction history"); // Select this to view the Transaction history
            System.out.println("5. Exit"); // Select this to Exit from the ATM Interface.

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Your balance is: Rs." + atm.getBalance());
            } else if (choice == 2) {
                System.out.println("Enter deposit amount:");
                double amount = scanner.nextDouble();
                atm.deposit(amount);
            } else if (choice == 3) {
                System.out.println("Enter withdrawal amount:");
                double amount = scanner.nextDouble();
                atm.withdraw(amount);
            } else if (choice == 4) {
                System.out.println("Transaction history:");
                System.out.println(atm.getTransactionHistory());
            } else if (choice == 5) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
