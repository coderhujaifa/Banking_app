package org.jsp.Bank_Atm;

import java.util.Scanner;

public class Bank_Driver {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter bank name to open account");
        String bname = s.next();
        System.out.println("Enter address of bank");
        String loc = s.next();
        System.out.println("Enter bank IFSC code");
        String ifcs = s.next();
        Bank b = new Bank(bname, loc, ifcs);

        boolean option = true;
        while (option) {
            System.out.println("Enter your choice");
            System.out.println("1. Create account");
            System.out.println("2. Check details");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Delete account");
            System.out.println("6. Exit");

            int choice = s.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter name");
                    String name = s.next();
                    System.out.println("Enter date of opening");
                    String dod = s.next();
                    System.out.println("Enter pin");
                    String pin = s.next();
                    System.out.println("Enter money to deposit");
                    double money = s.nextDouble();
                    System.out.println("Enter account number");
                    long ano = s.nextLong();
                    b.createAccount(new Account(name, dod, pin, money, ano));
                    System.out.println("================================");
                    break;
                }
                case 2: {
                    b.bankDeposite();
                    System.out.println("================================");
                    break;
                }
                case 3: {
                    System.out.println("Enter account number to deposit money");
                    long ano1 = s.nextLong();
                    System.out.println("Enter amount to deposit");
                    double money1 = s.nextDouble();
                    b.Deposite(ano1, money1);
                    System.out.println("================================");
                    break;
                }
                case 4: {
                    System.out.println("Enter account number to withdraw money");
                    long ano1 = s.nextLong();
                    System.out.println("Enter amount to withdraw");
                    double money1 = s.nextDouble();
                    b.Withdraw(ano1, money1);
                    System.out.println("================================");
                    break;
                }
                case 5: {
                    b.DeleteAccount();
                    break;
                }
                case 6: {
                    System.out.println("Thank you for using " + bname);
                    System.out.println("Have a good day!");
                    option = false;
                    break;
                }
                default: {
                    System.out.println("Enter a valid choice.");
                    break;
                }
            }
        }

        s.close(); // Close scanner
    }
}
