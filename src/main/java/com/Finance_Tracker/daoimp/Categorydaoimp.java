package com.Finance_Tracker.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Finance_Tracker.Category;
import com.Finance_Tracker.Dao.CategoryDao;

import Util.HibernateUtil;

public class Categorydaoimp implements CategoryDao{
    Scanner sc=new Scanner(System.in);
	@Override
	public Category createCategory(Category category) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			return category;
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
	public List<Category> getAllCategory() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all students data
			Query<Category> query=session.createQuery("FROM Category");
			List<Category> categoryList=query.list();
			return categoryList;
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
	public Category getCategory(int c_id) {
		try(Session session=HibernateUtil.getSession()) {

			
			Category category=session.get(Category.class,c_id);
			return category;
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
	public Category updateCategory(int c_id, Category updatedCategory) {
		try(Session session=HibernateUtil.getSession())
		{
			Category category=session.get(Category.class,c_id);
			session.beginTransaction();

			category.setC_id(updatedCategory.getC_id());
			category.setName(updatedCategory.getName());
			category.setType(updatedCategory.getType());
			session.saveOrUpdate(category);
			session.getTransaction().commit();
			return category;
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
	public boolean deleteCategory(int c_id) {
		try(Session session=HibernateUtil.getSession())
		{
			Category category=session.get(Category.class,c_id);
			session.beginTransaction();
			if(category!=null) {
				session.delete(category);
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
