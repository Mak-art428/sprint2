package com.Finance_Tracker;

import java.math.BigDecimal;
import java.time.LocalDate;


import javax.persistence.*;
@Entity
//@Table(name="goals")
public class Goal
{
	@Id               //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="g_id",unique = true)
	private int g_id;
	@Column (name="g_name",length=10)
	private String name;
	@Column (name="target_amount",precision=10,scale=2)
	private BigDecimal tamount;
	@Column (name="current_amount",precision=10,scale=2)
	private BigDecimal camount;
	@Column (name="target_date")
	private LocalDate date;
	@Column (name="status",length=10)
	private String status;
    //ManeToOne Relationship
	//foreign key from user
	@ManyToOne
	@JoinColumn(name="u_id")
	private User u_id;
	//Default constructor
	public Goal()
	{
		super();
	}
	//parametrized constructor
	public Goal(int g_id,String name,BigDecimal tamount,BigDecimal camount,LocalDate date,String status,User u_id)
	{
		super();
		this.g_id=g_id;
		this.name=name;
		this.tamount=tamount;
		this.camount=camount;
		this.date=date;
		this.status=status;
		this.u_id=u_id;
	}
    //Default Constructor
	public Goal(int g_id2, String name2, BigDecimal tamount2, BigDecimal camount2, LocalDate date2, String status2) {
		// TODO Auto-generated constructor stub
	}
	//getter & setter method
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getTamount() {
		return tamount;
	}
	public void setTamount(BigDecimal tamount) {
		this.tamount = tamount;
	}
	public BigDecimal getCamount() {
		return camount;
	}
	public void setCamount(BigDecimal camount) {
		this.camount = camount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getU_id() {
		return u_id;
	}
	public void setU_id(User u_id) {
		this.u_id = u_id;
	}
	//tostring method
	@Override
	public String toString()
	{
		return "Goal [g_id=" + g_id 
				+ ",name=" + name 
				+ ",tamount=" + tamount 
				+ ",camount=" + camount 
				+ ",date=" + date 
				+ ",status=" + status 
				+ ",u_id=" + u_id 
				+ "]";
	}
}
