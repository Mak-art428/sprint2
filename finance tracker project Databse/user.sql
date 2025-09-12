package com.Finance_Tracker;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name="users")
public class User 
{
	@Id           //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="u_id",unique = true)
	private int u_id;
	@Column (name="name",length=20,nullable=false)
	private String name;
	@Column (name="email",length=50,nullable=false)
	private String email;
	@Column (name="password",length=6,nullable=false)
	private String password;
	@Column (name="phone_number",length=10,nullable=false)
	private String phone;
	@Column(name = "created_at", updatable = false, nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	//one to many relationship
	//foreign key
	@OneToMany(mappedBy = "u_id" , cascade = CascadeType.ALL)
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "u_id" , cascade = CascadeType.ALL)
	private List<Budget> budgets;
	
	@OneToMany(mappedBy = "u_id" , cascade = CascadeType.ALL)
	private List<Goal> goals;
	
	@OneToMany(mappedBy = "u_id" , cascade = CascadeType.ALL)
	private List<Recurring_transaction> recurringtransactions;

	//default constructor
	public User()
	{
		super();
	}
	//parametrized constructor
	public User(int u_id,String name,String email,String password,String phone,LocalDateTime createdAt)
	{
		super();
		this.u_id=u_id;
		this.name=name;
		this.email=email;
		this.password=password;
		this.phone=phone;
		this.createdAt=createdAt;
	    setEmail(email);
	    setPhone(phone);
	}
	//getter and setter method
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	//Email validation
    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        // ✅ General email validation (must contain @ and domain part)
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // ✅ Restrict only to Gmail if required
        if (!email.toLowerCase().endsWith("@gmail.com")) {
            throw new IllegalArgumentException("Only Gmail addresses are allowed.");
        }

        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public String getphone() {
	        return phone;
	    }
	    // Contact number validation
	    public void setPhone(String phone) {
	        if (phone == null || phone.isEmpty()) {
	            throw new IllegalArgumentException("Contact number cannot be empty.");
	        }

	        // Only 10 digits allowed, optional + not allowed in strict mode
	        if (!phone.matches("^[0-9]{10}$")) {
	            throw new IllegalArgumentException("Invalid contact number. It must contain exactly 10 digits.");
	        }

	        this.phone = phone;
	    }
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public List<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}
	public List<Goal> getGoals() {
		return goals;
	}
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
	public List<Recurring_transaction> getRecurringtransactions() {
		return recurringtransactions;
	}
	public void setRecurringtransactions(List<Recurring_transaction> recurringtransactions) {
		this.recurringtransactions = recurringtransactions;
	}
	// tostring method
	@Override
	public String toString()
	{
		return "User [u_id=" + u_id 
				+ ",name=" + name 
				+ ",email=" + email 
				+ ",password=******" //Masked
				+  ",phone=" + phone 
				+ ",createdAt=" + createdAt 
				+ "]";
	}
}
