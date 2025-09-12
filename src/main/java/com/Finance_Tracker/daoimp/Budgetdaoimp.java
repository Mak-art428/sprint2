package com.Finance_Tracker.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.Budget;
import com.Finance_Tracker.Dao.BudgetDao;

import Util.HibernateUtil;

public class Budgetdaoimp implements BudgetDao{

	Scanner sc=new Scanner(System.in);
	@Override
	public Budget createBudget(Budget budget) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(budget);
			session.getTransaction().commit();
			return budget;
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
	public List<Budget> getAllBudget() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Budget> query=session.createQuery("FROM Budget");
			List<Budget> budgetList=query.list();
			return budgetList;
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
	public Budget getBudget(int b_id) {
		try(Session session=HibernateUtil.getSession()) {

			Budget budget=session.get(Budget.class,b_id);
			return budget;
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
	public Budget updateBudget(int b_id, Budget updatedbudget) {
		try(Session session=HibernateUtil.getSession())
		{
			Budget budget=session.get(Budget.class,b_id);
			session.beginTransaction();

			budget.setB_id(updatedbudget.getB_id());
			budget.setAmount(updatedbudget.getAmount());
			budget.setSdate(updatedbudget.getSdate());
			budget.setEdate(updatedbudget.getEdate());
			session.saveOrUpdate(budget);
			session.getTransaction().commit();
			return budget;
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
	public boolean deleteBudget(int b_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Budget budget=session.get(Budget.class,b_id);
			session.beginTransaction();
			if(budget!=null) {
				session.delete(budget);
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
