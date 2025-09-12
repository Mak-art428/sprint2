package com.Finance_Tracker.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Finance_Tracker.Account;
import com.Finance_Tracker.Dao.AccountDao;

import Util.HibernateUtil;

public class Accountdaoimp implements AccountDao{

	Scanner sc=new Scanner(System.in);
	@Override
	public Account createAccount(Account account) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			return account;
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
	public List<Account> getAllAccount(Account account) {
		try(Session session=HibernateUtil.getSession())
		{
			Query<Account> query=session.createQuery("FROM Account");
			List<Account> accountList=query.list();
			return accountList;
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
	public Account getAccount(int a_id) {
		try(Session session=HibernateUtil.getSession()) {

			Account account=session.get(Account.class,a_id);
			return account;
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
	public Account updateAccount(int a_id, Account updatedAccount) {
		try(Session session=HibernateUtil.getSession())
		{
			Account account=session.get(Account.class,a_id);
			session.beginTransaction();

			account.setA_id(a_id);
			account.setName(updatedAccount.getName());
			account.setType(updatedAccount.getType());
			account.setBalance(updatedAccount.getBalance());
			account.setCreatedAt(updatedAccount.getCreatedAt());

			session.saveOrUpdate(account);
			session.getTransaction().commit();
			return account;
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
	public boolean deleteAccount(int a_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Account account=session.get(Account.class,a_id);
			session.beginTransaction();
			if(account!=null)
			{
				session.delete(account);
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
