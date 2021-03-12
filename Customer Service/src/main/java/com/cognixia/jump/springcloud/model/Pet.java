package com.cognixia.jump.springcloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;

	//class variables
	@Id
	@Column(name="PETID")
	Integer id;
	@Column(name="NAME")
	String name;
	@Column(name="AGE")
	Integer age;
	@Column(name="WEIGHT")
	Double weight;
	
	//foreign entity
	@Column(name="CUSTOMERID")
	Integer customerId;
	
	
	
	//constructors
	public Pet() {
		this.id = -1;
		this.name = "N/A";
		this.age = -1;
		this.weight = -1.0;
		this.customerId = -1;
	}
	public Pet(Integer id, String name, Integer age, Double weight, Integer customerId) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.customerId = customerId;
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
	public Integer getAge() {
		return age;
	}
	public Double getWeight() {
		return weight;
	}
	public Integer getCustomerId() {
		return customerId;
	}

	
	//setters
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + ", customerId=" + customerId
				+ "]";
	}
	
}
