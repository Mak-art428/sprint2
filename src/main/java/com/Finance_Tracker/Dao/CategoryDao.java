package com.Finance_Tracker.Dao;

import java.util.List;

import com.Finance_Tracker.Category;

public interface CategoryDao 
{
	Category createCategory(Category category);
	List<Category>getAllCategory();
	
	Category getCategory(int c_id);
	Category updateCategory(int c_id,Category updatedCategory);
	boolean deleteCategory(int c_id);
}
