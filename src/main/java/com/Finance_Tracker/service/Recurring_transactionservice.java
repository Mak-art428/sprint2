package com.Finance_Tracker.service;

import java.util.List;

import com.Finance_Tracker.Recurring_transaction;

public interface Recurring_transactionservice 
{
	Recurring_transaction createRecurring_transaction(Recurring_transaction recurring_transaction);
	List<Recurring_transaction>getAllRecurring_transaction();
	
	Recurring_transaction getRecurring_transaction(int r_id);
	Recurring_transaction updateRecurring_transaction(int r_id,Recurring_transaction updateRecurring_transaction);
	boolean deleteRecurring_transaction(int r_id);
}
