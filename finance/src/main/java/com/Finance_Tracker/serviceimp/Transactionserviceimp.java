package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Transaction;
import com.Finance_Tracker.Dao.TransactionDao;
import com.Finance_Tracker.daoimp.Transactiondaoimp;
import com.Finance_Tracker.service.Transactionservice;

public class Transactionserviceimp implements Transactionservice{
	
    TransactionDao transactiondao = new Transactiondaoimp();
	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactiondao.createTransaction(transaction);
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactiondao.getAllTransaction();
	}

	@Override
	public Transaction getTransaction(int t_id) {
		// TODO Auto-generated method stub
		return transactiondao.getTransaction(t_id);
	}

	@Override
	public Transaction updateTransaction(int t_id, Transaction updatedTransaction) {
		// TODO Auto-generated method stub
		return transactiondao.updateTransaction(t_id, updatedTransaction);
	}

	@Override
	public boolean deleteTransaction(int t_id) {
		// TODO Auto-generated method stub
		return transactiondao.deleteTransaction(t_id);
	}

}
