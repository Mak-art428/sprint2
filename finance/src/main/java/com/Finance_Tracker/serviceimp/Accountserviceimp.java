package com.Finance_Tracker.serviceimp;

import java.util.List;

import com.Finance_Tracker.Account;
import com.Finance_Tracker.Dao.AccountDao;
import com.Finance_Tracker.daoimp.Accountdaoimp;
import com.Finance_Tracker.service.Accountservice;

public class Accountserviceimp implements Accountservice{

	AccountDao accountdao = new Accountdaoimp();
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountdao.createAccount(account);
	}

	@Override
	public List<Account> getAllAccount(Account account) {
		// TODO Auto-generated method stub
		return accountdao.getAllAccount(account);
		}

	@Override
	public Account getAccount(int a_id) {
		// TODO Auto-generated method stub
		return accountdao.getAccount(a_id);
	}

	@Override
	public Account updateAccount(int a_id, Account updatedAccount) {
		// TODO Auto-generated method stub
		return accountdao.updateAccount(a_id, updatedAccount);
	}

	@Override
	public boolean deleteAccount(int a_id) {
		// TODO Auto-generated method stub
		return accountdao.deleteAccount(a_id);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}
}
