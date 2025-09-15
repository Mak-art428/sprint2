package com.Finance_Tracker.service;

import java.util.List;

import com.Finance_Tracker.Goal;

public interface Goalservice 
{
	Goal createGoal(Goal goal);
	List<Goal>getAllGoal();
	
	Goal getGoal(int g_id);
	Goal updateGoal(int g_id,Goal updatedGoal);
	boolean deleteGoal(int g_id);

}
