package com.Finance_Tracker.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.Recurring_transaction;
import com.Finance_Tracker.Dao.Recurring_transactionDao;

import Util.HibernateUtil;

public class Recurring_transactiondaoimp implements Recurring_transactionDao{

	@Override
	public Recurring_transaction createRecurring_transaction(Recurring_transaction recurring_transaction) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(recurring_transaction);
			session.getTransaction().commit();
			return recurring_transaction;
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
	public List<Recurring_transaction> getAllRecurring_transaction() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Recurring_transaction> query=session.createQuery("FROM Recurring_transaction");
			List<Recurring_transaction> recurring_transactionList=query.list();
			return recurring_transactionList;
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
	public Recurring_transaction getRecurring_transaction(int r_id) {
try(Session session=HibernateUtil.getSession()) {

			
	Recurring_transaction recurring_transaction=session.get(Recurring_transaction.class,r_id);
			return recurring_transaction;
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
	public Recurring_transaction updateRecurring_transaction(int r_id,Recurring_transaction updateRecurring_transaction) {
		try(Session session=HibernateUtil.getSession())
		{
			Recurring_transaction recurring_transaction=session.get(Recurring_transaction.class,r_id);
			session.beginTransaction();

			recurring_transaction.setR_id(r_id);
			recurring_transaction.setAmount(updateRecurring_transaction.getAmount());
			recurring_transaction.setFreq(updateRecurring_transaction.getFreq());
			recurring_transaction.setDate(updateRecurring_transaction.getDate());
			
			session.saveOrUpdate(recurring_transaction);
			session.getTransaction().commit();
			return recurring_transaction;
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
	public boolean deleteRecurring_transaction(int r_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Recurring_transaction recurring_transaction=session.get(Recurring_transaction.class,r_id);
			session.beginTransaction();
			if(recurring_transaction!=null) {
				session.delete(recurring_transaction);
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
