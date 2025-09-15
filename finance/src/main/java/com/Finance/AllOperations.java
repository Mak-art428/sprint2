package com.Finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.Finance_Tracker.service.Userservice;
import com.Finance_Tracker.Account;
import com.Finance_Tracker.Budget;
import com.Finance_Tracker.Category;
import com.Finance_Tracker.Goal;
import com.Finance_Tracker.Recurring_transaction;
import com.Finance_Tracker.Transaction;
import com.Finance_Tracker.User;
import com.Finance_Tracker.service.Accountservice;
import com.Finance_Tracker.service.Categoryservice;
import com.Finance_Tracker.service.Budgetservice;
import com.Finance_Tracker.service.Goalservice;
import com.Finance_Tracker.service.Recurring_transactionservice;
import com.Finance_Tracker.service.Transactionservice;

import com.Finance_Tracker.serviceimp.Accountserviceimp;
import com.Finance_Tracker.serviceimp.Budgetserviceimp;
import com.Finance_Tracker.serviceimp.Categoryserviceimp;
import com.Finance_Tracker.serviceimp.Goalserviceimp;
import com.Finance_Tracker.serviceimp.Recurring_transactionserviceimp;
import com.Finance_Tracker.serviceimp.Transactionserviceimp;
import com.Finance_Tracker.serviceimp.Userserviceimp;

public class AllOperations {
	static Userservice userservice = new Userserviceimp();
	static Accountservice accountservice = new Accountserviceimp();
	static Categoryservice categoryservice = new Categoryserviceimp();
	static Budgetservice budgetservice = new Budgetserviceimp();
	static Goalservice goalservice = new Goalserviceimp();
	static Transactionservice transactionservice = new Transactionserviceimp();
	static Recurring_transactionservice recurringservice = new Recurring_transactionserviceimp();

	static Scanner sc=new Scanner(System.in);

	public static User userInputs()
	{
		sc.nextLine();
		System.out.println("Enter userID:");
		int u_id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter UserName:");
		String name=sc.nextLine();

		System.out.println("Enter Email:");
		String email=sc.nextLine();

		System.out.println("Password:");
		String password=sc.nextLine();

		System.out.println("Phone No:");
		String phone=sc.nextLine();

		LocalDateTime createdAt=LocalDateTime.now();
		return new User(u_id, name, email, password, phone, createdAt);
	}
	//for Accounts
	public static Account accountInputs()
	{
		sc.nextLine();
		System.out.println("Enter AccountID:");
		int a_id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Account Name:");
		String name=sc.nextLine();
		System.out.println("Account_type(Bank,Wallet,cash,credit):");
		String type=sc.nextLine();
		System.out.println("Enter Balance");
		BigDecimal balance=sc.nextBigDecimal();
		LocalDateTime createdAt=LocalDateTime.now();
		return new Account(a_id, name, type, balance, createdAt);
	}
	//for category
	public static Category categoryInputs()
	{
		sc.nextLine();
		System.out.println("Enter CategoryID:");
		int c_id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Category Name:");
		String name=sc.nextLine();
		System.out.println("Enter Category_type(income/expanse):");
		String type=sc.nextLine();
		return new Category(c_id, name, type);
	}
	//for Transaction
	public static Transaction transactionInputs()
	{
		sc.nextLine();
		System.out.println("Enter TransactionID:");
		int t_id=sc.nextInt();	
		sc.nextLine();
		System.out.println("Enter Amount");
		BigDecimal balance=sc.nextBigDecimal();
		sc.nextLine();
		System.out.println("Enter Transaction_type(credit/Debit):");
		String type=sc.nextLine();
		LocalDate date=LocalDate.now();
		System.out.println("Enter Description:");
		String dsec=sc.nextLine();
		return new Transaction(t_id, balance, type, date, dsec);
	}
	//for budget
	public static Budget budgetInputs()
	{
		sc.nextLine();
		System.out.println("Enter BudgetID:");
		int b_id=sc.nextInt();
		System.out.println("Enter Amount");
		BigDecimal amount=sc.nextBigDecimal();

		LocalDate sdate=LocalDate.now();

		LocalDate edate=sdate.plusMonths(1);

		return new Budget(b_id,amount,sdate,edate);
	}
	//for Goal
	public static Goal goalInputs()
	{
		sc.nextLine();
		System.out.println("Enter GoalID:");
		int g_id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Goal Name:");
		String name = sc.nextLine();
		System.out.println("Enter Target Amount:");
		BigDecimal tamount=sc.nextBigDecimal();
		System.out.println("Enter current Amount:");
		BigDecimal camount=sc.nextBigDecimal();
		LocalDate date = LocalDate.now().plusMonths(6);
		sc.nextLine();
		System.out.println("Enter Status(complete/Pending):");
		String status= sc.nextLine();
		return new Goal(g_id,name,tamount,camount,date,status);
	}
	//for recurring
	public static Recurring_transaction recurringtransactionInputs()
	{
		sc.nextLine();
		System.out.println("Enter Recurring_ID:");
		int r_id=sc.nextInt();
		System.out.println("Enter Amount");
		BigDecimal amount=sc.nextBigDecimal();
		sc.nextLine();
		System.out.println("Enter frequency(Daily/Weekly/Monthly/Yearly):");
		String freq = sc.nextLine();
		LocalDate date=LocalDate.now();
		return new Recurring_transaction(r_id,amount,freq,date);
	}
	// ---------------- USER OPERATIONS ----------------
	public static void userOperations() throws Exception {
		while (true) {
			System.out.println("1.Add User\n2.View All Users\n3.Update User\n4.Delete User\n5.Back");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				User u = userInputs();
				userservice.createUser(u);
				System.out.println("User saved." + u);
				break;
			case 2:
				List<User> user=userservice.getAllUsers();
				user.forEach(System.out::println);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter User ID to update:");
				int u_id = sc.nextInt();
				if (userservice.getUser(u_id) != null) {
					User upd = userInputs();
					userservice.updateUser(u_id, upd);
					System.out.println("User updated:" + upd);
				} else 
				{
					throw new Exception("User not found.");
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter User ID to delete:");
				int delU = sc.nextInt();
				userservice.deleteUser(delU);
				System.out.println("Userdeleted Succesfully." + delU);
				break;
			case 5: return;
			}
		}
	}
	// ---------------- ACCOUNT OPERATIONS ----------------
	public static void accountOperations() throws Exception {
		while (true) {
			System.out.println("1.Add Account\n2.View All Accounts\n3.Update Account\n4.Delete Account\n5.Back");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("Enter user ID: ");
				int userId = sc.nextInt(); sc.nextLine();
				User u = userservice.getUser(userId);
				if (u != null) {
					System.out.print("Enter account name:");
					String name = sc.nextLine();
					System.out.print("Enter type(Bank/cash/Wallet/credit)");
					String type = sc.nextLine();
					System.out.print("Enter balance: ");
					BigDecimal balance = sc.nextBigDecimal();

					Account acc = new Account();
					acc.setName(name);
					acc.setType(type);
					acc.setBalance(balance);
					acc.setU_id(u);

					accountservice.createAccount(acc);
					System.out.println("Account created: " + acc);
				} else System.out.println("User not found.");
				break;
			case 2:
				List<Account> accounts=accountservice.getAllAccount(null);
				accounts.forEach(System.out::println);
				break;
			case 3:
				sc.nextLine();
				System.out.print("Enter account ID: ");
				int a_id = sc.nextInt(); sc.nextLine();
				Account acc = accountservice.getAccount(a_id);
				if (acc != null) {
					System.out.print("Enter new name: ");
					acc.setName(sc.nextLine());
					System.out.print("Enter Account_type(Bank,Wallet,cash,credit):");
					acc.setType(sc.nextLine());
					System.out.print("Enter balance");
					acc.setBalance(sc.nextBigDecimal());
					accountservice.updateAccount(a_id, acc);
					System.out.println("Account updated." + acc);
				} else 
				{
					throw new Exception("Account not found.");
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Account ID to delete:");
				int delA = sc.nextInt();
				accountservice.deleteAccount(delA);
				System.out.println("Account deleted." + delA);
				break;
			case 5: return;
			}
		}
	}// ---------------- CATEGORY OPERATIONS ----------------
	public static void categoryOperations() throws Exception 
	{
		while (true) 
		{
			System.out.println("1.Add Category\n2.View All Categories\n3.Update Category\n4.Delete Category\n5.Back");
			int input = sc.nextInt();
			switch (input) 
			{
			case 1:
				Category c = categoryInputs();
				categoryservice.createCategory(c);
				System.out.println("Category saved." + c);
				break;
			case 2:
				List<Category> category=categoryservice.getAllCategory();
				category.forEach(System.out::println);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Category ID to update:");
				int c_id = sc.nextInt();
				if (categoryservice.getCategory(c_id) != null) 
				{
					Category upd = categoryInputs();
					categoryservice.updateCategory(c_id, upd);
					System.out.println("Category updated." + upd);
				} else 
				{
					throw new Exception("Category not found.");
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Category ID to delete:");
				int delC = sc.nextInt();

				categoryservice.deleteCategory(delC);
				System.out.println("Category Deleted" + delC);
				break;
			case 5: 
				return;
			}
		}
	}
	// ---------------- TRANSACTION OPERATIONS ----------------
	public static void transactionOperations() throws Exception {
		while (true) {
			System.out.println("1.Add Transaction\n2.View All Transactions\n3.Update Transaction\n4.Delete Transaction\n5.Back");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("Enter account ID: ");
				int a_id = sc.nextInt();
				System.out.print("Enter category ID: ");
				int c_id = sc.nextInt(); 
				sc.nextLine();
				Account acc = accountservice.getAccount(a_id);
				Category c = categoryservice.getCategory(c_id);

				if (acc != null && c != null) {

					System.out.print("Enter TransactionId: ");
					int t_id = sc.nextInt();

					System.out.print("Enter amount: ");
					BigDecimal amt = sc.nextBigDecimal();
					sc.nextLine();
					System.out.print("Enter description: ");
					String desc = sc.nextLine();

					System.out.print("Enter type (debit/credit): ");
					String type = sc.nextLine();
					Transaction t = new Transaction();
					t.setT_id(t_id);
					t.setAmount(amt);
					t.setDesc(desc);

					t.setA_id(acc);
					t.setC_id(c);
					t.setType(type);
					t.setDate(LocalDate.now());

					transactionservice.createTransaction(t);
					System.out.println(" Transaction created: " + t);
				} else 
				{
					System.out.println(" Invalid account or category.");
				}
				break;

			case 2:
				List<Transaction> transaction=transactionservice.getAllTransaction();
				transaction.forEach(System.out::println);
				break;
			case 3:
				sc.nextLine();
				System.out.print("Enter transaction ID: ");
				int id = sc.nextInt(); 
				sc.nextLine();
				Transaction t = transactionservice.getTransaction(id);
				if (t != null) 
				{
					System.out.println("Enter Amount");
					t.setAmount(sc.nextBigDecimal());
					sc.nextLine();
					System.out.println("Enter Transaction_type(credit/Debit):");
					t.setType(sc.nextLine());
					System.out.print("Enter new description: ");
					t.setDesc(sc.nextLine());

					transactionservice.updateTransaction(id, t);
					System.out.println(" Transaction updated." + t);
				} else 
				{
					System.out.println("Transaction not found.");
				}
				break;

			case 4:
				sc.nextLine();
				System.out.println("Enter Transaction ID to delete:");
				int delT = sc.nextInt();
				transactionservice.deleteTransaction(delT);
				System.out.println("Transaction deleted." + delT);
				break;
			case 5: return;
			}
		}
	}
	// ---------------- BUDGET OPERATIONS ----------------
	public static void budgetOperations() throws Exception {
		while (true) {
			System.out.println("1.Add Budget\n2.View All Budgets\n3.Update Budget\n4.Delete Budget\n5.Back");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("Enter user ID: ");
				int uid = sc.nextInt(); sc.nextLine();
				User u = userservice.getUser(uid);
				if (u != null) {
					System.out.print("Enter budget ID: ");
					int b_id = sc.nextInt();
					System.out.print("Enter amount: ");
					BigDecimal amt = sc.nextBigDecimal();

					Budget b = new Budget();
					b.setB_id(b_id);
					b.setAmount(amt);
					b.setSdate(LocalDate.now());
					b.setEdate(LocalDate.now().plusMonths(1));
					b.setU_id(u);

					budgetservice.createBudget(b);
					System.out.println(" Budget created: " + b);
				} else 
				{
					System.out.println(" User not found.");
				}
				break;

			case 2:
				List<Budget> budget=budgetservice.getAllBudget();
				budget.forEach(System.out::println);
				break;
			case 3:
				sc.nextLine();
				System.out.print("Enter budget ID: ");
				int b_id = sc.nextInt(); 
				sc.nextLine();
				Budget b = budgetservice.getBudget(b_id);
				if (b != null) {
					System.out.print("Enter amount: ");
					BigDecimal amt = sc.nextBigDecimal();
					b.setAmount(amt);
					b.setEdate(LocalDate.now());
					b.setEdate(LocalDate.now());
					budgetservice.updateBudget(b_id, b);
					System.out.println("Budget updated." + b);
				} else
				{
					System.out.println("Budget not found.");
				}
				break;

			case 4:
				sc.nextLine();
				System.out.println("Enter Budget ID to delete:");
				int delB = sc.nextInt();
				budgetservice.deleteBudget(delB);
				System.out.println("Budget deleted." + delB);
				break;
			case 5: return;
			}
		}
	}

	// ---------------- GOAL OPERATIONS ----------------
	public static void goalOperations() throws Exception {
		while (true) {
			System.out.println("1.Add Goal\n2.View All Goals\n3.Update Goal\n4.Delete Goal\n5.Back");
			int input = sc.nextInt(); sc.nextLine();
			switch (input) {
			case 1:
				System.out.print("Enter user ID: ");
				int u_id = sc.nextInt();
				sc.nextLine();
				User u = userservice.getUser(u_id);
				if (u != null) {
					System.out.print("Enter goal name: ");
					String name = sc.nextLine();
					System.out.print("Enter target amount: ");
					BigDecimal tamount = sc.nextBigDecimal();
					sc.nextLine();
					System.out.print("Enter current amount: ");
					BigDecimal camount = sc.nextBigDecimal();
					sc.nextLine();
					System.out.println("Enter Status(complete/Pending):");
					String status= sc.nextLine();

					Goal g = new Goal();
					g.setName(name);
					g.setTamount(tamount);
					g.setCamount(camount);
					g.setDate(LocalDate.now().plusMonths(6));
					g.setStatus(status);
					g.setU_id(u);

					goalservice.createGoal(g);
					System.out.println("Goal created:" + g);
				} else 
				{
					System.out.println("User not found.");
				}
				break;

			case 2:
				List<Goal> goal=goalservice.getAllGoal();
				goal.forEach(System.out::println);
				break;
			case 3:
				System.out.print("Enter goal ID: ");
				int g_id = sc.nextInt();
				Goal g = goalservice.getGoal(g_id);
				if (g != null) {
					System.out.print("Enter Goal Name:");
					g.setName(sc.nextLine());
					sc.nextLine();
					System.out.print("Enter new Target amount: ");
					g.setTamount(sc.nextBigDecimal());
					sc.nextLine();
					System.out.print("Enter new current amount: ");
					g.setCamount(sc.nextBigDecimal());
					sc.nextLine();
					System.out.println("Enter Status(complete/Pending):");
					String status= sc.nextLine();
					g.setStatus(status);
					goalservice.updateGoal(g_id, g);
					g.setDate(LocalDate.now().plusMonths(2));
					System.out.println("Goal updated." + g);
				} else
				{
					System.out.println(" Goal not found.");
				}
				break;

			case 4:
				sc.nextLine();
				System.out.println("Enter Goal ID to delete:");
				int delG = sc.nextInt();
				goalservice.deleteGoal(delG);
				System.out.println("Goal deleted." + delG);
				break;
			case 5: return;
			}
		}
	}

	// ---------------- RECURRING OPERATIONS ----------------
	public static void recurringOperations() throws Exception {
		while (true) {
			System.out.println("1.Add Recurring\n2.View All Recurrings\n3.Update Recurring\n4.Delete Recurring\n5.Back");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("Enter user ID: ");
				int u_id = sc.nextInt();
				sc.nextLine();
				User u = userservice.getUser(u_id);
				if (u != null) {
					System.out.print("Enter id: ");
					int r_id = sc.nextInt();
					System.out.print("Enter amount: ");
					BigDecimal amt = sc.nextBigDecimal(); 
					sc.nextLine();
					System.out.print("Enter frequency(Daily/Weekly/Monthly/Yearly):");
					String freq = sc.nextLine();

					Recurring_transaction r = new Recurring_transaction();
					r.setR_id(r_id);
					r.setAmount(amt);
					r.setFreq(freq);
					r.setDate(LocalDate.now());
					r.setU_id(u);

					recurringservice.createRecurring_transaction(r);
					System.out.println("Recurring transaction created:" + r);
				} else 
				{
					System.out.println("User not found.");
				}
				break;

			case 2:
				List<Recurring_transaction> recurring_transaction= recurringservice.getAllRecurring_transaction();
				recurring_transaction.forEach(System.out::println);
				break;
			case 3:
				System.out.print("Enter recurring transaction ID: ");
				int r_id = sc.nextInt();
				sc.nextLine();
				Recurring_transaction r = recurringservice.getRecurring_transaction(r_id);
				if (r != null) {
					System.out.print("Enter Amount:");
					BigDecimal amt = sc.nextBigDecimal(); 
					r.setAmount(amt);
					sc.nextLine();
					System.out.print("Enter frequency(Daily/Weekly/Monthly/Yearly):");
					String freq = sc.nextLine();
					r.setFreq(freq);
					recurringservice.updateRecurring_transaction(r_id, r);
					System.out.println("Recurring transaction updated." + r);
				} else
				{
					System.out.println("Not found.");
				}
				break;


			case 4:
				sc.nextLine();
				System.out.println("Enter Recurring ID to delete:");
				int delR = sc.nextInt();
				recurringservice. deleteRecurring_transaction(delR);
				System.out.println("Recurring deleted." + delR);
				break;
			case 5: return;
			}
		}
	}
}
