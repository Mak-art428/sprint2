package com.Finance_Tracker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
@Entity
//@Table(name="transaction")
public class Transaction
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_id",unique = true)
	private int t_id;
	@Column (name="amount",precision=10,scale=2,nullable=false)
	private BigDecimal amount;
	@Column (name="t_type",length=10)
	private String type;
	@Column (name="date")
	@CreationTimestamp
	private LocalDate date;
	@Column (name="description",length=10)
	private String desc;
	//OneToMane Relationship
	@OneToMany(mappedBy = "t_id" , cascade = CascadeType.ALL)
	private List<Recurring_transaction> recurringtransactions;
	//ManeToOne relationship
	@ManyToOne         //foreign key from account
	@JoinColumn(name="a_id")
	private Account a_id;
	@ManyToOne        //foreign key from category
	@JoinColumn(name="c_id")
	private Category c_id;
    //Default constructor
	public Transaction()
	{
		super();
	}
	//parmetrized constructor
	public Transaction(int t_id,BigDecimal amount,String type,LocalDate date,String desc,Account a_id,Category c_id)
	{
		super();
		this.t_id=t_id;
		this.amount=amount;
		this.type=type;
		this.date=date;
		this.desc=desc;
		this.a_id=a_id;
		this.c_id=c_id;
	}
	// default constructor
	public Transaction(int t_id2, BigDecimal balance, String type2, LocalDate date2, String dsec) {
		// TODO Auto-generated constructor stub
	}
	//getter & setter method
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Account getA_id() {
		return a_id;
	}
	public void setA_id(Account a_id) {
		this.a_id = a_id;
	}
	public Category getC_id() {
		return c_id;
	}
	public void setC_id(Category c_id) {
		this.c_id = c_id;
	}
	
	@Override
	public String toString()
	{
		return "Transaction [t_id=" + t_id 
				+ ",amount=" + amount 
				+ ",type=" + type 
				+ ",date=" + date
				+ ",desc=" + desc 
				+ ",a_id+" + a_id 
				+ ",c_id=" + c_id 
				+ "]";
	}
	
	
}
