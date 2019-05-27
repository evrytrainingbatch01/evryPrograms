package com.evry.springproject.Domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "accId")
	private int accId;
	
	@Column(name = "accBalance")
	private BigDecimal accBalance;
	
	@Column(name = "userAccountNo")
	private int userAccountNo;
	
	@Column(name = "accounttype")
	private String AccountType;
	
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="account_bank_id")
	private Bank bank;
	
	@JsonIgnore
	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
//	@JoinColumn(name="account_user_id")
	private User user;
	
	public Account() {}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public BigDecimal getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(BigDecimal accBalance) {
		this.accBalance = accBalance;
	}

	public int getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(int userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accBalance=" + accBalance + ", userAccountNo=" + userAccountNo
				+ ", AccountType=" + AccountType  +"]";
	}
	
	

}
