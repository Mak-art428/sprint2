package com.Finance_Tracker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
//@Table(name="accounts")
public class Account 
{
	@Id                //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="a_id",unique = true)
	private int a_id;
	@Column (name="a_name",length=50,nullable=false)
	private String name;
	@Column (name="a_type",length=10)
	private String type;
	@Column (name="balance",precision=10,scale=2)
	private BigDecimal balance;
	@Column(name = "created_at", updatable = false, nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	//onetomany relationship
	//foreign key
    @OneToMany(mappedBy="a_id",cascade=CascadeType.ALL)
    private List<Transaction> transactions;
    
    //ManeToOne relationship
    //foreign key from user
	@ManyToOne
	@JoinColumn(name="u_id")
	private User u_id;

	//Default constructor
	public Account()
	{
		super();
	}
	//parametrized constructor
	public Account(int a_id,String name,String type,BigDecimal balance,LocalDateTime createdAt,User u_id)
	{
		this.a_id=a_id;
		this.name=name;
		this.type=type;
		this.balance=balance;
		this.createdAt=createdAt;
		this.u_id=u_id;
	}

	//default constructor
	public Account(int a_id2, String name2, String type2, BigDecimal balance2, LocalDateTime createdAt2) {
		// TODO Auto-generated constructor stub
	}
	//getter & setter method
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public User getU_id() {
		return u_id;
	}
	public void setU_id(User u_id) {
		this.u_id = u_id;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	//tostring method
	@Override
	public String toString()
	{
		return "Account [a_id=" + a_id 
				+ ",name=" + name 
				+ ",type=" + type 
				+ ",balance=" + balance 
				+ ",createdAt=" + createdAt 
				+ ",u_id=" + u_id 
				+ "]";
	}

}
