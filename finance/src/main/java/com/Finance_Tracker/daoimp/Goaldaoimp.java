package com.Finance_Tracker.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.Category;
import com.Finance_Tracker.Goal;
import com.Finance_Tracker.Dao.GoalDao;

import Util.HibernateUtil;

public class Goaldaoimp implements GoalDao{
    Scanner sc=new Scanner(System.in);
	@Override
	public Goal createGoal(Goal goal) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(goal);
			session.getTransaction().commit();
			return goal;
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
	public List<Goal> getAllGoal(){
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Goal> query=session.createQuery("FROM Goal");
			List<Goal> GoalList=query.list();
			return GoalList;
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
	public Goal getGoal(int g_id) {
try(Session session=HibernateUtil.getSession()) {

			
			Goal goal=session.get(Goal.class,g_id);
			return goal;
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
	public Goal updateGoal(int g_id, Goal updatedGoal) {
		try(Session session=HibernateUtil.getSession())
		{
			Goal goal=session.get(Goal.class,g_id);
			session.beginTransaction();

			goal.setG_id(updatedGoal.getG_id());
			goal.setName(updatedGoal.getName());
			goal.setTamount(updatedGoal.getTamount());
			goal.setCamount(updatedGoal.getCamount());
		    goal.setDate(updatedGoal.getDate());
		    goal.setStatus(updatedGoal.getStatus());
			session.saveOrUpdate(goal);
			session.getTransaction().commit();
			return goal;
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
	public boolean deleteGoal(int g_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Goal goal=session.get(Goal.class,g_id);
			session.beginTransaction();
			if(goal!=null) {
				session.delete(goal);
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

	@Override
	public List<Goal> getAllBudget() {
		// TODO Auto-generated method stub
		return null;
	}

}
