package com.bank;

public interface Bank {
	long getBalance();

	void withdraw(long amount);

	void deposit(long amount);

	void showAccount();

	boolean search(long acc_no);
}
