package com.Finance_Tracker;

import java.util.List;

import javax.persistence.*;
@Entity
//@Table(name="categorys")
public class Category 
{
	@Id           //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id",unique = true)
	private int c_id;
	@Column (name="c_name",length=10,nullable=false)
	private String name;
	@Column (name="c_type",length=10)
	private String type;
	//OneToMany relationship
	@OneToMany(mappedBy = "c_id" , cascade = CascadeType.ALL)
	private List<Budget> budgets;
	
	@OneToMany(mappedBy = "c_id" , cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	@OneToMany(mappedBy = "c_id" , cascade = CascadeType.ALL)
	private List<Recurring_transaction> recurringtransactions;
	

	//Default constructor
	public Category()
	{
		super();
	}
	//parametrized constructor
	public Category(int c_id,String name,String type)
	{
		super();
		this.c_id=c_id;
		this.name=name;
		this.type=type;
	}
	//Getter & setter Method
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public List<Recurring_transaction> getRecurringtransactions() {
		return recurringtransactions;
	}
	public void setRecurringtransactions(List<Recurring_transaction> recurringtransactions) {
		this.recurringtransactions = recurringtransactions;
	}
	//tostring method
	@Override
	public String toString()
	{
		return "Category [c_id=" + c_id 
				         + ",name=" + name 
				         + ",type=" + type 
				         + "]";
	}
}

