package com.Finance_Tracker.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.Transaction;
import com.Finance_Tracker.Dao.TransactionDao;

import Util.HibernateUtil;

public class Transactiondaoimp implements TransactionDao {

	@Override
	public Transaction createTransaction(Transaction transaction) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(transaction);
			session.getTransaction().commit();
			return transaction;
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return null;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Transaction> query=session.createQuery("FROM Transaction",Transaction.class);
			List<Transaction> transactionList=query.list();
			return transactionList;
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Transaction getTransaction(int t_id) {
try(Session session=HibernateUtil.getSession()) {

			
	     Transaction transaction=session.get(Transaction.class,t_id);
			return transaction;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Transaction updateTransaction(int t_id, Transaction updatedTransaction) {
		try(Session session=HibernateUtil.getSession())
		{
			Transaction transaction=session.get(Transaction.class,t_id);
			session.beginTransaction();

			//transaction.setT_id(t_id);
			transaction.setAmount(updatedTransaction.getAmount());
			transaction.setType(updatedTransaction.getType());
			transaction.setDate(updatedTransaction.getDate());
			transaction.setDesc(updatedTransaction.getDesc());
			session.saveOrUpdate(transaction);
			session.getTransaction().commit();
			return transaction;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public boolean deleteTransaction(int t_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Transaction transaction=session.get(Transaction.class,t_id);
			session.beginTransaction();
			if(transaction!=null) {
				session.delete(transaction);
				session.getTransaction().commit();
				return true;
			}
			return false;	
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
