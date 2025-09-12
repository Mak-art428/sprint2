package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Recurring_transaction;
import com.Finance_Tracker.Dao.Recurring_transactionDao;
import com.Finance_Tracker.daoimp.Recurring_transactiondaoimp;
import com.Finance_Tracker.service.Recurring_transactionservice;

public class Recurring_transactionserviceimp implements Recurring_transactionservice {

	Recurring_transactionDao recurring_transactiondao = new Recurring_transactiondaoimp();
	@Override
	public Recurring_transaction createRecurring_transaction(Recurring_transaction recurring_transaction) {
		// TODO Auto-generated method stub
		return recurring_transactiondao.createRecurring_transaction(recurring_transaction);
	}

	@Override
	public List<Recurring_transaction> getAllRecurring_transaction() {
		// TODO Auto-generated method stub
		return recurring_transactiondao.getAllRecurring_transaction();
	}

	@Override
	public Recurring_transaction getRecurring_transaction(int r_id) {
		// TODO Auto-generated method stub
		return recurring_transactiondao.getRecurring_transaction(r_id);
	}

	@Override
	public Recurring_transaction updateRecurring_transaction(int r_id,Recurring_transaction updateRecurring_transaction) {
		// TODO Auto-generated method stub
		return recurring_transactiondao.updateRecurring_transaction(r_id, updateRecurring_transaction);
	}

	@Override
	public boolean deleteRecurring_transaction(int r_id) {
		// TODO Auto-generated method stub
		return recurring_transactiondao.deleteRecurring_transaction(r_id);
	}

}
