/*
FILE: banking.java

DESCRIPTION: 
Main file for handling register ID's, bank statments and transactions
*/

import java.util.Scanner;

public class Main {

    static int balance = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        curr_balance();
        deposit();
        withdraw();
        curr_balance();
    }

    static void curr_balance()
    {
        System.out.println("Your current balance is: " + balance);
    }

    static void deposit() 
    {
        System.out.print("How much would you like to deposit?: ");
        int deposit = sc.nextInt();

        balance += deposit;

        System.out.println("Your new balance is: " + balance);
    }

    static void withdraw()
    {
        System.out.print("How much would you like to withdraw?: ");
        int withdraw = sc.nextInt();

        balance -= withdraw;

        System.out.println("Your new balance is: " + balance);
    }

    static void balance_change()
    {

        System.out.print("How much would you like to withdraw?: ");
        System.out.print("How much would you like to deposit?: ");
    }
}

// public class Customer_Database
// {
//     int customer_db[1000];

//     static void CustomerAdd()
//     {

//     }

//     static void CustomerRem()
//     {

//     }

//     static void CustomerStatus()
//     {

//     }
// }