package com.Finance_Tracker.service;

import java.util.List;

import com.Finance_Tracker.Budget;

public interface Budgetservice 
{
	Budget createBudget(Budget budget);
	List<Budget> getAllBudget();
	Budget getBudget(int b_id);
	Budget updateBudget(int b_id,Budget updatedbudget);
	boolean deleteBudget(int b_id);

}
