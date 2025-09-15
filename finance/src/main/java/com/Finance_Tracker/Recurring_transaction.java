package com.Finance_Tracker;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
@Entity
///@Table(name="recurringtransactions")
public class Recurring_transaction 
{
	@Id           //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="r_id",unique = true)
	private int r_id;
	@Column (name="amount",precision=10,scale=2,nullable=false)
	private BigDecimal amount;
	@Column (name="frequency",length=10)
	private String freq;
	@Column (name="next_due_date")
	private LocalDate date;
	//ManeToOne relationship ,foreign key from user 
	@ManyToOne
	@JoinColumn(name="u_id")
	private User u_id;
	@ManyToOne      //foreign key from transaction
	@JoinColumn(name="t_id")
	private Transaction t_id;
	@ManyToOne       //foreign key from category
	@JoinColumn(name="c_id")
	private  Category c_id;

	//Default constructor
	public Recurring_transaction()
	{
		super();
	}
	//parametrized constructor
	public Recurring_transaction(int r_id,BigDecimal amount,String freq,
			LocalDate date,User u_id,Transaction t_id,Category c_id)
	{
		super();
		this.r_id=r_id;
		this.amount=amount;
		this.freq=freq;
		this.date=date;
		this.u_id=u_id;
		this.t_id=t_id;
		this.c_id=c_id;
	}
	public Recurring_transaction(int r_id2, BigDecimal amount2, String freq2, LocalDate date2) {
		// TODO Auto-generated constructor stub
	}
	//getter & setter method
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getFreq() {
		return freq;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getU_id() {
		return u_id;
	}
	public void setU_id(User u_id) {
		this.u_id = u_id;
	}

	public Transaction getT_id() {
		return t_id;
	}
	public void setT_id(Transaction t_id) {
		this.t_id = t_id;
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
		return "Recurring_transaction [r_id=" + r_id 
				+ ",amount=" + amount 
				+ ",freq=" + freq 
				+ ",date=" + date 
				+ ",u_id=" + u_id 
				+ "]";
	}
}