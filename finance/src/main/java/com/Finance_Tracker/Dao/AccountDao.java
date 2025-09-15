package com.Finance_Tracker.Dao;

import java.util.List;

import com.Finance_Tracker.Account;

public interface AccountDao 
{
	Account createAccount(Account account);
	List<Account> getAllAccount(Account account);
	Account getAccount(int a_id);
	Account updateAccount(int a_id,Account updatedAccount);
	boolean deleteAccount(int a_id);
	
}
