package com.Finance_Tracker.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.User;
import com.Finance_Tracker.Dao.UserDao;
import Util.HibernateUtil;

public class Userdaoimp implements UserDao
{

	Scanner sc=new Scanner(System.in);
	@Override
	public User createUser(User user) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return user;
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
	public List<User> getAllUsers() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<User> query=session.createQuery("FROM User");
			List<User> userList=query.list();
			return userList;
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
	public User getUser(int u_id) {
		try(Session session=HibernateUtil.getSession()) {

			User user=session.get(User.class,u_id);
			return user;
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
	public User updateUser(int u_id, User updatedUser) {
		try(Session session=HibernateUtil.getSession())
		{
			User user=session.get(User.class,u_id);
			session.beginTransaction();

			user.setU_id(u_id);
			user.setName(updatedUser.getName());
			user.setEmail(updatedUser.getEmail());
			user.setPassword(updatedUser.getPassword());
			user.setPhone(updatedUser.getPhone());
			user.setCreatedAt(updatedUser.getCreatedAt());

			session.saveOrUpdate(user);
			session.getTransaction().commit();
			return user;
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
	public boolean deleteUser(int u_id) {
		try(Session session=HibernateUtil.getSession())
		{
			User user=session.get(User.class,u_id);
			session.beginTransaction();
			if(user!=null) {
				session.delete(user);
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
