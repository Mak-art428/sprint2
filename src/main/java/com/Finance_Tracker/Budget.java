package com.Finance_Tracker;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
@Entity
//@Table(name="budgets")
public class Budget
{
	@Id                 //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="b_id",unique = true)
	private int b_id;
	@Column (name="amount_limit",precision=10,scale=2)
	private BigDecimal amount;
	// Stores only the date (e.g., 2025-08-28)
	@Column(name = "start_date")
	private LocalDate sdate;
     // Stores only the date (e.g., 2025-08-28)
	@Column(name = "end_date")
	private LocalDate edate;
   //ManeToOne relationship 
	//foreign key from user  
	@ManyToOne
	@JoinColumn(name="u_id")
	private User u_id;
	@ManyToOne //foreign key from Category 
	@JoinColumn(name="c_id")
	private Category c_id;

	//Default constructor
	public Budget()
	{
		super();
	}
	//parametrized constructor
	public Budget(int b_id,BigDecimal amount,LocalDate sdate,LocalDate edate,User u_id,Category c_id)
	{
		super();
		this.b_id=b_id;
		this.amount=amount;
		this.sdate=sdate;
		this.edate=edate;
		this.u_id=u_id;
		this.c_id=c_id;
	}
    //getter & setter method
	//Default constructor
	public Budget(int b_id2, BigDecimal amount2, LocalDate sdate2, LocalDate edate2) {
		// TODO Auto-generated constructor stub
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public LocalDate getEdate() {
		return edate;
	}
	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}
	public LocalDate getSdate() {
		return sdate;
	}
	public void setSdate(LocalDate sdate)
	{
		this.sdate = sdate;
	}
	public User getU_id() {
		return u_id;
	}
	public void setU_id(User u_id) {
		this.u_id = u_id;
	}
	public Category getC_id() {
		return c_id;
	}
	public void setC_id(Category c_id) {
		this.c_id = c_id;
	}
	//tostring method
	@Override
	public String toString()
	{
		return "Budget [b_id=" + b_id 
				+ ",amount=" + amount 
				+ ",sdate=" + sdate 
				+ ",edate=" + edate 
				+ ",u_id=" + u_id 
				+ ",c_id=" + c_id 
				+ "]";
	}
}
