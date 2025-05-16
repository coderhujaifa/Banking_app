package org.jsp.Bank_Atm;

public class Bank {

    String bname;
    String loc;
    String ifsc_code;
    Account a;

    public Bank(String bname, String loc, String ifsc_code) {
        this.bname = bname;
        this.loc = loc;
        this.ifsc_code = ifsc_code;
    }

    public void bankDeposite() {
        System.out.println("Bank Name: " + bname);
        System.out.println("Location: " + loc);
        System.out.println("IFSC Code: " + ifsc_code);
        if (a != null) {
            System.out.println("Account Holder Name: " + a.account_holder_name);
            System.out.println("Date of Opening: " + a.dod);
            System.out.println("PIN: " + a.pin);
            System.out.println("Balance: " + a.money);
        } else {
            System.out.println("Please open your account first.");
        }
    }

    public void createAccount(Account a) {
        if (this.a == null) {
            this.a = a;
            System.out.println("Account successfully created.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public void Deposite(long ano, double money) {
        if (a != null && a.ano == ano) {
            if (money > 0) {
                a.money += money;
                System.out.println("Deposited amount: " + money);
                System.out.println("Total balance: " + a.money);
            } else {
                System.out.println("Enter a valid amount to deposit.");
            }
        } else {
            System.out.println("Enter a valid account number.");
        }
    }

    public void Withdraw(long ano, double money) {
        if (a != null && a.ano == ano) {
            if (money > 0) {
                if (a.money >= money) {
                    a.money -= money;
                    System.out.println("Withdrawn amount: " + money);
                    System.out.println("Total balance: " + a.money);
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Enter a valid amount to withdraw.");
            }
        } else {
            System.out.println("Enter a valid account number.");
        }
    }

    public void DeleteAccount() {
        this.a = null;
        System.out.println("Account deleted.");
    }
}
