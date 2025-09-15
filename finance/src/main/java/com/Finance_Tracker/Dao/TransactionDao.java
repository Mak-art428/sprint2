package com.Finance_Tracker.Dao;

import java.util.List;

import com.Finance_Tracker.Transaction;

public interface TransactionDao 
{
	Transaction createTransaction(Transaction transaction);
	List<Transaction>getAllTransaction();
	Transaction getTransaction(int t_id);
	Transaction updateTransaction(int t_id,Transaction updatedTransaction);
	boolean deleteTransaction(int t_id);

}
