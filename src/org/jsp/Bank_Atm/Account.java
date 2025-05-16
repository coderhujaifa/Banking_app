//package org.jsp.Bank_Atm;
//
//public class Account {
//
//	String account_holder_name;
//	String dod;
//	String pin;
//	double money;
//	long ano;
//	public void Bank_Driver(String account_holder_name, String dod, String pin, double money, long ano) {
//		super();
//		this.account_holder_name = account_holder_name;
//		this.dod = dod;
//		this.pin = pin;
//		this.money = money;
//		this.ano = ano;
//	}
//	
//	public void accountDelete() {
//		System.out.println("account_holder_name");
//		System.out.println("dod");
//		System.out.println("pin");
//		System.out.println("money");
//		System.out.println("ano");
//	}
//}

package org.jsp.Bank_Atm;

public class Account {
    String account_holder_name;
    String dod;
    String pin;
    double money;
    long ano;

    // Correct constructor
    public Account(String account_holder_name, String dod, String pin, double money, long ano) {
        this.account_holder_name = account_holder_name;
        this.dod = dod;
        this.pin = pin;
        this.money = money;
        this.ano = ano;
    }

    public void accountDelete() {
        System.out.println(account_holder_name);
        System.out.println(dod);
        System.out.println(pin);
        System.out.println(money);
        System.out.println(ano);
    }
}

