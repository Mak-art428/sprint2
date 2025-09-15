package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Goal;
import com.Finance_Tracker.Dao.GoalDao;
import com.Finance_Tracker.daoimp.Goaldaoimp;
import com.Finance_Tracker.service.Goalservice;

public class Goalserviceimp implements Goalservice{

	GoalDao goaldao = new Goaldaoimp();
	@Override
	public Goal createGoal(Goal goal) {
		// TODO Auto-generated method stub
		return goaldao.createGoal(goal);
	}

	@Override
	public List<Goal> getAllGoal() {
		// TODO Auto-generated method stub
		return goaldao.getAllGoal();
	}

	@Override
	public Goal getGoal(int g_id) {
		// TODO Auto-generated method stub
		return goaldao.getGoal(g_id);
	}

	@Override
	public Goal updateGoal(int g_id, Goal updatedGoal) {
		// TODO Auto-generated method stub
		return goaldao.updateGoal(g_id, updatedGoal);
	}

	@Override
	public boolean deleteGoal(int g_id) {
		// TODO Auto-generated method stub
		return goaldao.deleteGoal(g_id);
	}

}
