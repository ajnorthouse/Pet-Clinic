package com.cognixia.jump.springcloud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUSTOMERID")
	Integer customerId;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="EMAILADDRESS")
	String emailAddress;
	
	@Column(name="ZIPCODE")
	String Zipcode;
	
	@Transient
	List<Pet> accts;
	
	public Customer() {
		super();
	}

	public Customer(Integer customerId, String name, String emailAddress, String zipcode) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailAddress = emailAddress;
		Zipcode = zipcode;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public List<Pet> getAccts() {
		return accts;
	}

	public void setAccts(List<Pet> accts) {
		this.accts = accts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailAddress=" + emailAddress + ", Zipcode="
				+ Zipcode + "]";
	}


	

}
