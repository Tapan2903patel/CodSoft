import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args)
    {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        // Add some sample accounts
        atm.addAccount(new BankAccount("1", 1000));
        atm.addAccount(new BankAccount("2", 2000));

        boolean exit = false;

        while (!exit) {
            System.out.println("ATM Machine");
            System.out.println("1. Select Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    atm.selectAccount(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    atm.checkBalance();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}

class ATM
{
    private Map<String, BankAccount> accounts;
    private BankAccount currentAccount;

    public ATM()
    {
        this.accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account)
    {
        accounts.put(account.getAccountNumber(), account);
    }

    public void selectAccount(String accountNumber)
    {
        if (accounts.containsKey(accountNumber))
        {
            currentAccount = accounts.get(accountNumber);
            System.out.println("Account " + accountNumber + " selected.");
        }
        else
        {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(double amount)
    {
        if (currentAccount == null)
        {
            System.out.println("No account selected.");
            return;
        }
        if (amount > 0 && amount <= currentAccount.getBalance())
        {
            currentAccount.withdraw(amount);
            System.out.println("Withdrawal successful. Current balance: " + currentAccount.getBalance());
        }
        else
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount)
    {
        if (currentAccount == null)
        {
            System.out.println("No account selected.");
            return;
        }
        if (amount > 0)
        {
            currentAccount.deposit(amount);
            System.out.println("Deposit successful. Current balance: " + currentAccount.getBalance());
        }
        else
        {
            System.out.println("Invalid amount.");
        }
    }

    public void checkBalance()
    {
        if (currentAccount == null)
        {
            System.out.println("No account selected.");
            return;
        }
        System.out.println("Current balance: " + currentAccount.getBalance());
    }
}

class BankAccount
{
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
        }
    }
}
