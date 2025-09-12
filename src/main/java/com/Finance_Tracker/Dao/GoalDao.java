package com.Finance_Tracker.Dao;
import java.util.List;

import com.Finance_Tracker.Goal;
public interface GoalDao 
{
	Goal createGoal(Goal goal);
	List<Goal>getAllGoal();
	
	Goal getGoal(int g_id);
	Goal updateGoal(int g_id,Goal updatedGoal);
	boolean deleteGoal(int g_id);


}
