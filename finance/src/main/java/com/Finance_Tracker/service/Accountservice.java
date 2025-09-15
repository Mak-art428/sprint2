package com.Finance_Tracker.service;

import java.util.List;

import com.Finance_Tracker.Account;

public interface Accountservice
{
	Account createAccount(Account account);
	List<Account> getAllAccount(Account account);
	Account getAccount(int a_id);
	Account updateAccount(int a_id,Account updatedAccount);
	boolean deleteAccount(int a_id);
}
