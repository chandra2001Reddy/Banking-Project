package com.bank;

import java.util.*;

class Company {
	String name;
	long id;
	String mail;
	long Phone_no;
	String dept;
	int age;
	long Salary;
	String Address;
	String Shifts_times;
	int leavescount;
}

class Employee extends Company {
	public String toString() {
		return "-------Displaying Employee details:------\n" + "Name: " + name + "\n" + "ID: " + id + "\n" + "Mail: "
				+ mail + "\n" + "Phone Number: " + Phone_no + "\n" + "Department: " + dept + "\n" + "Age: " + age + "\n"
				+ "Salary: " + Salary + "\n" + "Address: " + Address + "\n" + "Shift Timings: " + Shifts_times + "\n"
				+ "Leaves Count: " + leavescount;
	}
}

class EmployeeManagementProject {
	static List<Employee> employeesList = new ArrayList<>();
	static Scanner s1 = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("!!!----Welcome to Employee Management System---!!!");
			System.out.println("Select one of the following options:");
			System.out.println("1. Add Employee details");
			System.out.println("2. Update Employee details");
			System.out.println("3. Remove Employee details");
			System.out.println("4. Search for Employee details");
			System.out.println("5. Display Employee details");
			System.out.println("6. Monitor Employee details");
			System.out.println("7. Exit the Application");

			int choice = s1.nextInt();
			switch (choice) {
			case 1:
				if (confirmAction("Add Employee details")) {
					addEmployee();
				}
				break;
			case 2:
				if (confirmAction("Update Employee details")) {
					updateEmployee();
				}
				break;
			case 3:
				if (confirmAction("Remove Employee details")) {
					removeEmployee();
				}
				break;
			case 4:
				if (confirmAction("Search for Employee details")) {
					searchDetails();
				}
				break;
			case 5:
				if (confirmAction("Display Employee details")) {
					displayDetails();
				}
				break;
			case 6:
				if (confirmAction("Monitor Employee details")) {
					monitorEmployee();
				}
				break;
			case 7:
				System.out.println("Exiting the Application....Thank You!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}

	static boolean confirmAction(String action) {
		System.out.println("Do you want to " + action + "? (yes/no):");
		String confirm = s1.next();
		return confirm.equalsIgnoreCase("yes");
	}

	static void addEmployee() {
		do {
			Employee emp = new Employee();
			System.out.println("Adding Employee details:");
			s1.nextLine();
			System.out.println("Enter Employee Name:");
			emp.name = s1.nextLine();

			System.out.println("Enter Employee ID (Only numbers): ");
			long id = 0;
			boolean validId = false;
			while (!validId) {
				if (s1.hasNextLong()) {
					id = s1.nextLong();
					if (!isIdExists(id)) {
						validId = true;
					} else {
						System.out.println("Employee with this ID already exists. Please enter a unique ID:");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid Employee ID (Only numbers):");
					s1.next();
				}
			}
			emp.id = id;

			System.out.println("Enter Employee Mail Id:");
			emp.mail = s1.next();

			System.out.println("Enter Employee Phone number (10 digits):");
			long phoneNumber = 0;
			boolean validPhoneNumber = false;
			while (!validPhoneNumber) {
				if (s1.hasNextLong()) {
					phoneNumber = s1.nextLong();
					if (String.valueOf(phoneNumber).length() == 10) {
						validPhoneNumber = true;
					} else {
						System.out.println("Invalid phone number. Please enter a 10-digit phone number:");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid 10-digit phone number:");
					s1.next();
				}
			}
			emp.Phone_no = phoneNumber;

			System.out.println("Enter Employee Department:");
			emp.dept = s1.next();

			System.out.println("Enter Employee Age (below 100):");
			int age = 0;
			boolean validAge = false;
			while (!validAge) {
				if (s1.hasNextInt()) {
					age = s1.nextInt();
					if (age >= 0 && age < 100) {
						validAge = true;
					} else {
						System.out.println("Invalid age. Please enter an age below 100:");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid age:");
					s1.next();
				}
			}
			emp.age = age;

			System.out.println("Enter Employee Salary per month (Only numbers):");
			long salary = 0;
			boolean validSalary = false;
			while (!validSalary) {
				if (s1.hasNextLong()) {
					salary = s1.nextLong();
					if (salary >= 0) {
						validSalary = true;
					} else {
						System.out.println("Invalid salary. Please enter a non-negative salary:");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid salary:");
					s1.next();
				}
			}
			emp.Salary = salary;

			System.out.println("Enter Employee Address:");
			emp.Address = s1.next();

			System.out.println("Enter Employee Shift(Day shift/Night shift:");
			emp.Shifts_times = s1.next();

			System.out.println("Enter Employee Leave count per month (Only numbers):");
			int leaves = 0;
			boolean validLeaves = false;
			while (!validLeaves) {
				if (s1.hasNextInt()) {
					leaves = s1.nextInt();
					if (leaves >= 0) {
						validLeaves = true;
					} else {
						System.out.println("Invalid leaves count. Please enter a non-negative leaves count:");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid leaves count:");
					s1.next();
				}
			}
			emp.leavescount = leaves;

			employeesList.add(emp);
			System.out.println("Employee details added successfully!");

			System.out.println("Do you want to add one more employee? (yes/no):");
			String addMore = s1.next();
			if (!addMore.equalsIgnoreCase("yes")) {
				return;
			}
		} while (true);
	}

	static void updateEmployee() {
		System.out.println("Enter Employee ID whose details you want to update:");
		long searchId = s1.nextLong();

		for (Employee emp : employeesList) {
			if (emp.id == searchId) {
				int opt;
				do {
					System.out.println("Select Options for Update: ");
					System.out.println("1. Update Employee name");
					System.out.println("2. Update Employee Mail");
					System.out.println("3. Update Employee Phone Number");
					System.out.println("4. Update Employee Age");
					System.out.println("5. Update Employee Department");
					System.out.println("6. Update Employee Leaves count");
					System.out.println("7. Update Employee Shift Times");
					System.out.println("8. Exit this option");
					opt = s1.nextInt();

					switch (opt) {
					case 1:
						System.out.println("Enter Employee update Name:");
						emp.name = s1.next();
						break;
					case 2:
						System.out.println("Enter Employee update mail:");
						emp.mail = s1.next();
						break;
					case 3:
						System.out.println("Enter Employee update Phone_no (only number):");
						emp.Phone_no = s1.nextLong();
						break;
					case 4:
						System.out.println("Enter Employee update Age (only number):");
						emp.age = s1.nextInt();
						break;
					case 5:
						System.out.println("Enter Employee update Department:");
						emp.dept = s1.next();
						break;
					case 6:
						System.out.println("Enter Employee update Leaves count:");
						emp.leavescount = s1.nextInt();
						break;
					case 7:
						System.out.println("Enter Employee update Shifts_times:");
						emp.Shifts_times = s1.next();
						break;
					case 8:
						System.out.println("Exiting the update option.");
						break;
					default:
						System.out.println("Invalid choice.");
						break;
					}

				} while (opt != 8);

				System.out.println("Details updated successfully!");
				return;
			}
		}
		System.out.println("Employee with ID " + searchId + " not found.");
	}

	static void removeEmployee() {
		System.out.println("Enter Employee ID whose details you want to Remove:");
		long searchId = s1.nextLong();
		Iterator<Employee> it = employeesList.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			if (emp.id == searchId) {
				it.remove();
				System.out.println("Employee with ID " + searchId + " removed.");
				return;
			}
		}
		System.out.println("Employee with ID " + searchId + " not found.");
	}

	static void searchDetails() {
		System.out.println("Want to display One Employee or All Employee's....?");
		System.out.println("Select options below:");
		System.out.println("1. One Employee details");
		System.out.println("2. All Employee details");
		int op = s1.nextInt();
		if (op == 1) {
			System.out.println("Want to Search by Employee Name or Employee Id or Department....?:");
			System.out.println("1. Employee Name");
			System.out.println("2. Employee Id");
			System.out.println("3. Employee Department");
			int op1 = s1.nextInt();
			if (op1 == 1) {
				System.out.println("Please Enter the Employee Name: ");
				String n = s1.next();
				for (Employee emp : employeesList) {
					if (emp.name.contains(n)) {
						System.out.println(emp);
					}
				}
			} else if (op1 == 2) {
				System.out.println("Please Enter the Employee Id: ");
				long l = s1.nextLong();
				for (Employee emp : employeesList) {
					if (emp.id == l) {
						System.out.println(emp);
					}
				}
			} else if (op1 == 3) {
				System.out.println("Please Enter the Employee Department: ");
				String d = s1.next();
				for (Employee emp : employeesList) {
					if (emp.dept.contains(d)) {
						System.out.println(emp);
					}
				}
			}
		} else if (op == 2) {
			for (Employee emp : employeesList) {
				System.out.println(emp);
			}
		}
	}

	static void displayDetails() {
		for (Employee emp : employeesList) {
			System.out.println(emp);
		}
	}

	static void monitorEmployee() {
		System.out.println("Enter Employee ID whose details you want to Monitor:");
		long searchId = s1.nextLong();
		Iterator<Employee> it = employeesList.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			if (emp.id == searchId) {
				System.out.println("Progress of " + emp.name + " is given below :-");
				System.out.println("Your Leaves count is: " + emp.leavescount);
				System.out.println("Your Actual salary is: " + emp.Salary);
				if (emp.leavescount == 0) {
					double pf = emp.Salary * 0.03;
					double hi = emp.Salary * 0.02;
					double ex = emp.Salary * 0.02;
					System.out.println("After all deductions your salary is: " + (emp.Salary + ex - hi - pf));
					System.out.println("Congratulations....you got Employee of the month!!!");
				} else if (emp.leavescount <= 3) {
					double pf = emp.Salary * 0.03;
					double hi = emp.Salary * 0.02;
					System.out.println("After all deductions your salary is: " + (emp.Salary - hi - pf));
					System.out.println("Keep it up.....!!!");
				} else if (emp.leavescount >= 4 && emp.leavescount <= 5) {
					double pf = emp.Salary * 0.03;
					double hi = emp.Salary * 0.02;
					double lc = emp.Salary * 0.04;
					System.out.println("After all deductions your salary is: " + (emp.Salary - hi - pf - lc));
					System.out.println("Can Do Better.....!!!");
				} else if (emp.leavescount >= 6 && emp.leavescount <= 8) {
					double pf = emp.Salary * 0.03;
					double hi = emp.Salary * 0.02;
					double lc = emp.Salary * 0.1;
					System.out.println("After all deductions your salary is: " + (emp.Salary - hi - pf - lc));
					System.out.println("Very Poor Performance.....Need to Improve.....!!!");
				} else {
					System.out.println("Employee with ID " + searchId + " not found.");
				}
				return;
			}
		}
		System.out.println("Employee with ID " + searchId + " not found.");
	}

	static boolean isIdExists(long id) {
		for (Employee emp : employeesList) {
			if (emp.id == id) {
				return true;
			}
		}
		return false;
	}
}