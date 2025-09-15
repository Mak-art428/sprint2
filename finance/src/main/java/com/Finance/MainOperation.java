package com.Finance;
import java.util.Scanner;
import static com.Finance.AllOperations.*;

public class MainOperation {

	static Scanner sc=new Scanner(System.in);
	
public static void mainOps() throws Exception {
	
        while (true) {
            System.out.println("\n===== Finance Tracker =====");
            System.out.println("1. User Operations");
            System.out.println("2. Account Operations");
            System.out.println("3. Category Operations");
            System.out.println("4. Transaction Operations");
            System.out.println("5. Budget Operations");
            System.out.println("6. Goal Operations");
            System.out.println("7. Recurring Operations");   
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: userOperations(); 
                break;
                case 2: accountOperations();
                break;
                case 3: categoryOperations();
                break; 
                case 4: transactionOperations(); 
                break;
                case 5: budgetOperations(); 
                break;
                case 6: goalOperations(); 
                break;
                case 7: recurringOperations();
                break;
                case 8: System.exit(0);
            }
        }
    }
public static void main(String[] args) throws Exception
{
	
	mainOps();

}
}