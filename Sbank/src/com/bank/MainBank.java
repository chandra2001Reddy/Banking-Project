package com.bank;

import java.util.*;

public class MainBank {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Bank> C = new ArrayList<>();
		System.out.println("No accounts found. Please Create one");
		Bank bank_account = createAccount(C);
		if (bank_account != null) {
			C.add(bank_account);
		}

		int option;
		do {
			System.out.println("\n #Banking System Application#");
			System.out.println(
					" 1.Create an account \n2. Display all account details \n 3. Search by Account number\n 4. Deposit the amount \n 5. Withdraw the amount \n 6. Remove account\n 7.Exit ");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				Bank bank1 = createAccount(C);
				if (bank1 != null) {
					C.add(bank1);
				}
				break;
			case 2:
				if (C.isEmpty()) {
					System.out.println("No accounts found");
				}
				for (int i = 0; i < C.size(); i++) {
					C.get(i).showAccount();
				}
				break;
			case 3:
				System.out.print("Enter account no. you want to search: ");
				long ac_no = sc.nextLong();
				boolean found = false;
				for (int i = 0; i < C.size(); i++) {
					found = C.get(i).search(ac_no);
					if (found) {
						break;
					}
				}

				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 4:
				System.out.print("Enter Account no. : ");
				ac_no = sc.nextLong();
				found = false;
				for (int i = 0; i < C.size(); i++) {
					found = C.get(i).search(ac_no);
					if (found) {
						System.out.println("Enter the amount to deposit");
						long amount = sc.nextLong();
						C.get(i).deposit(amount);
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 5:
				System.out.print("Enter Account No : ");
				ac_no = sc.nextLong();
				found = false;
				for (int i = 0; i < C.size(); i++) {
					found = C.get(i).search(ac_no);
					if (found) {
						System.out.println("Enter the amount to withdraw");
						long amount = sc.nextLong();
						C.get(i).withdraw(amount);
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist.!");
				}
				break;
			case 6:
				System.out.println("Enter your acc no: ");
				long temp = sc.nextLong();
				found = false;
				for (int i = 0; i < C.size(); i++) {
					found = C.get(i).search(temp);
					if (found) {
						C.remove(i);
						System.out.println("Account deleted successfully");
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist.!");
				}
				break;
			case 7:
				break;
			default:
				System.out.println("Enter the correct Choice");
				break;
			}
		} while (option != 7);
	}

	public static Bank createAccount(ArrayList<Bank> C) {
		int choice;
		String name;
		int acc_type;
		long accNo;
		long balance;
		boolean found;

		Bank bank_account;

		System.out.println("Choose your Bank to crate account");
		System.out.println("1.SBI 2.UNION 3. AndhraBank");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();

		if (choice > 0 && choice <= 3) {

			Random random = new Random();

			// Generate a random 12-digit number
			accNo = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			System.out.print("Enter Name: ");
			name = sc.next();

			System.out.print("Select Account type: \n 1.savings \n2.current");
			acc_type = sc.nextInt();

			if (acc_type > 0 && acc_type <= 2) {
				System.out.print("Enter Balance: ");
				balance = sc.nextLong();

				found = false;
				for (int i = 0; i < C.size(); i++) {
					found = C.get(i).search(accNo);
					if (found) {
						System.out.println("Account with entered accNo already exists.");
						break;
					}
				}
				if (!found) {
					switch (choice) {
					case 1:
						if (balance < 1000) {
							System.out
									.println("Minimum balance is 1000. Please make sure your minimum balance is 1000");
						} else {
							bank_account = new SBI(name, accNo, acc_type, balance);
							System.out.println("Account created");
							return bank_account;
						}
						break;
					case 2:
						if (balance < 2000) {
							System.out
									.println("Minimum balance is 2000. Please make sure your minimum balance is 20000");
						} else {
							bank_account = new UNION(name, accNo, acc_type, balance);
							System.out.println("Account created in nbd");
							return bank_account;
						}
						break;

					case 3:
						if (balance < 3000) {
							System.out
									.println("Minimum balance is 3000. Please make sure your minimum balance is 5000");
						} else {
							bank_account = new AndhraBank(name, accNo, acc_type, balance);
							System.out.println("Account created");
							return bank_account;
						}
						break;

					default:
						System.out.println("Wrong Choice");

					}
				}
			} else {
				System.out.println("invaild account type");
			}
		} else {
			System.out.println("invalid choice");
		}

		return null;

	}

}
