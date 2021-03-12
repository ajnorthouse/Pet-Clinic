package com.cognixia.jump.springcloud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	//class variables
	@Id
	@Column(name="CUSTOMERID")
	Integer id;
	@Column(name="NAME")
	String name;
	@Column(name="PHONENUMBER")
	String phoneNumber;
	@Column(name="EMAILADDRESS")
	String emailAddress;
	@Column(name="CITY")
	String city;
	
	//foreign entity
	@Transient
	List<Pet> pets;
	
	
	
	//constructors
	public Customer() {
		this.id = 0;
		this.name = "N/A";
		this.phoneNumber = "N/A";
		this.emailAddress = "N/A";
		this.city = "N/A";
		this.pets = new ArrayList<Pet>();
	}
	public Customer(Integer id, String name, String phoneNumber, String emailAddress, String city) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.city = city;
		this.pets = new ArrayList<Pet>();
	}
	public Customer(Integer id, String name, String phoneNumber, String emailAddress, String city, List<Pet> pets) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.city = city;
		this.pets = pets;
	}

	
	//getters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getCity() {
		return city;
	}
	public List<Pet> getPets() {
		return pets;
	}

	
	//setters
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + ", city=" + city + ", pets=" + pets + "]";
	}

	

}
