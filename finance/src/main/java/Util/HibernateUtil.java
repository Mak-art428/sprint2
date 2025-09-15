package Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Finance_Tracker.Account;
import com.Finance_Tracker.Budget;
import com.Finance_Tracker.Category;
import com.Finance_Tracker.Goal;
import com.Finance_Tracker.Recurring_transaction;
import com.Finance_Tracker.Transaction;
import com.Finance_Tracker.User;

public class HibernateUtil {
	private final static SessionFactory sessionFactory = buildSessionFactory();
private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Account.class)
					.addAnnotatedClass(Budget.class)
					.addAnnotatedClass(Goal.class)
					.addAnnotatedClass(Category.class)
					.addAnnotatedClass(Transaction.class)
					.addAnnotatedClass(Recurring_transaction.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session getSession()
	{
		return getSessionFactory().openSession(); //session opened
	}
}
