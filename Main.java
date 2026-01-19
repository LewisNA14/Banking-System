/*
FILE: banking.java

DESCRIPTION: 
Main file for handling register ID's, bank statments and transactions
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        
        while (true) 
        { 
            System.out.print("""
            1. Add Customer
            2. Deposit
            3. Withdraw
            4. Check Balance
            5. Exit
            """);

            int choice = sc.nextInt();
    
            switch(choice) {
                case 1: customerDb(); break;
                case 2: moneyManage(); break;
            }
        }
        // moneyManage();
        // customerDb();
    }

    public static void moneyManage()
    {
        BalanceManager bm = new BalanceManager();
        bm.currBalance();
        bm.depositBalance();
        bm.withdrawBalance();
        bm.currBalance();
    }

    public static void customerDb() 
    {
        Customer_DB cdb = new Customer_DB();
        cdb.addCustomer();
    }
}

class Customer_DB
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
}


class BalanceManager 
{
    private int balance = 0;
    private Scanner sc = new Scanner(System.in);

    void currBalance() 
    {
        System.out.println("Your current balance is: " + balance);
    }

    void depositBalance() 
    {
        System.out.print("How much would you like to deposit?: ");
        int deposit = sc.nextInt();
        balance += deposit;
    }

    void withdrawBalance() 
    {
        System.out.print("How much would you like to withdraw?: ");
        int withdrawal = sc.nextInt();
        if (withdrawal > balance)
        {
            System.out.print("You're amount exceeds your current balance\n");
            withdrawBalance();
        }
        else
        { 
            balance -= withdrawal;
        }
    }
}

