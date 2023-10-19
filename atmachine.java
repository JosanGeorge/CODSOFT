import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner sc;

    public ATM(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
        sc = new Scanner(System.in);
    }

    public void Options() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processUserChoice() {
        int choice;
        do {
            Options();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + userAccount.getBalance());
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = sc.nextDouble();
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = sc.nextDouble();
        if (amount > 0 && userAccount.withdraw(amount)) {
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class atmachine {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the bank account
        ATM atm = new ATM(initialBalance);
        atm.processUserChoice();
    }
}
