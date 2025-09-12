package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Category;
import com.Finance_Tracker.Dao.CategoryDao;
import com.Finance_Tracker.daoimp.Categorydaoimp;
import com.Finance_Tracker.service.Categoryservice;

public class Categoryserviceimp implements Categoryservice{

	CategoryDao categorydao = new Categorydaoimp();
	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categorydao.createCategory(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categorydao.getAllCategory();
	}

	@Override
	public Category getCategory(int c_id) {
		// TODO Auto-generated method stub
		return categorydao.getCategory(c_id);
	}

	@Override
	public Category updateCategory(int c_id, Category updatedCategory) {
		// TODO Auto-generated method stub
		return categorydao.updateCategory(c_id, updatedCategory);
	}

	@Override
	public boolean deleteCategory(int c_id) {
		// TODO Auto-generated method stub
		return categorydao.deleteCategory(c_id);
	}

}
