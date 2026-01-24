/*
FILE: banking.java

DESCRIPTION: 
Main file for handling register ID's, bank statments and transactions
*/

import java.util.Scanner;

public class Main {
    // private static Scanner sc = new Scanner(System.in);
    private static Bank ba = new Bank();
    private static Account acc = new Account();
    private static menuBank mB = new menuBank();


    
    public static void main(String[] args) 
    {
        while (true) 
        { 
            int first_choice = mB.menuPart1();
            
          
            switch(first_choice) {
                case 1: {
                    int accountChoice = mB.accountIntroMenu();
                    switch (accountChoice) {
                        case 1 -> acc.accountManagement();
                        case 2 -> mB.accountCreationMenu();
                        default -> System.out.println("Invalid option");
                    }
                    break;
                }

                case 2: {
                    int bankingChoice = mB.transactionMenu();
                    switch (bankingChoice) {
                        case 1 -> ba.depositBalance();
                        case 2 -> ba.withdrawBalance();
                        case 3 -> ba.currBalance();
                        case 4 -> {
                            System.out.println("Goodbye!");
                            return;
                        }
                        default -> System.out.println("Invalid option");
                    }
                }

                case 3:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

class menuBank 
{
    private static Scanner sc = new Scanner(System.in);
    private static int choice; 

    // 1st Stage of Bank Menu should be a login
    int menuPart1()
    {
        System.out.print("""
            Are you here to either:
            1. Manage Account
            2. Manage your funds
            """);
            choice = sc.nextInt();

            return choice;
    }
    
    // int menuTest()
    // {
    //     System.out.println("Welcome to the Bank of LNA the coolest bank around");
    //     System.out.print("""
    //         1. Add Customer
    //         2. Deposit
    //         3. Withdraw
    //         4. Check Balance
    //         5. Exit
    //         """);
    //     choice = sc.nextInt();
    //     return choice;
    // }

    int transactionMenu()
    {
        System.out.println("This is in progress");
        System.out.print("""
            1. Deposit
            2. Withdraw
            3. Check Balance
            4. Exit
            """);
        choice = sc.nextInt();
        return choice;
    }

    int accountIntroMenu()
    {
        System.out.println("Under construction");
        System.out.print("""
                Do you have an existing account?:
                1. Yes
                2. No
                """);
        choice = sc.nextInt();
        return choice;
    }

    String accountCreationMenu()
    {
        System.out.println("Enter a Username: "); 
        String userName = sc.nextLine();

        System.out.println("Enter a password: "); 
        String passWord = sc.nextLine();

        return userName, passWord; 
    }
}

class Account
{
    private Scanner sc = new Scanner(System.in);
    private final String[] customer_db = new String[1000];
    private int customerCount = 0;

    void addCustomer()
    {
        System.out.println("What is your name?: "); 
        String userName = sc.nextLine();
        if ((userName != null) && (customerCount < customer_db.length))
        {
            customer_db[customerCount] = userName;
            customerCount++;
            System.out.println("Customer added: " + userName);

        }
        else
        {
            System.out.println("Database is full!");
            
        }

    }

    // void removeCustomer()
    // {

    // }

    void accountManagement()
    {
        System.err.println("Under construction");
    }
}


class Bank
{
    private int balance = 0;
    private Scanner sc = new Scanner(System.in);
    // private Transactions transactions = new Transactions();

    public void currBalance() 
    {
        System.out.println("Your current balance is: " + balance);
    }

    public void depositBalance() 
    {
        System.out.print("How much would you like to deposit?: ");
        int deposit = sc.nextInt();
        if (deposit > 0)
        {
            balance += deposit;
        }
    }

    public void withdrawBalance() 
    {
        while (true) 
        {
            System.out.print("How much would you like to withdraw?: ");
            int withdrawal = sc.nextInt();

            if (withdrawal <= balance && withdrawal > 0) 
            {
                balance -= withdrawal;
                break;
            }
            System.out.println("Invalid amount.");
        }
    }
}

