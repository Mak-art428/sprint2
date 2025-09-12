package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Budget;
import com.Finance_Tracker.Dao.BudgetDao;
import com.Finance_Tracker.daoimp.Budgetdaoimp;
import com.Finance_Tracker.service.Budgetservice;

public class Budgetserviceimp implements Budgetservice
{

	BudgetDao budgetdao = new Budgetdaoimp();
	@Override
	public Budget createBudget(Budget budget) {
		// TODO Auto-generated method stub
		return budgetdao.createBudget(budget);
	}

	@Override
	public List<Budget> getAllBudget() {
		// TODO Auto-generated method stub
		return budgetdao.getAllBudget();
	}

	@Override
	public Budget getBudget(int b_id) {
		// TODO Auto-generated method stub
		return budgetdao.getBudget(b_id);
	}

	@Override
	public Budget updateBudget(int b_id, Budget updatedbudget) {
		// TODO Auto-generated method stub
		return budgetdao.updateBudget(b_id, updatedbudget);
	}

	@Override
	public boolean deleteBudget(int b_id) {
		// TODO Auto-generated method stub
		return budgetdao.deleteBudget(b_id);
	}
	

}
