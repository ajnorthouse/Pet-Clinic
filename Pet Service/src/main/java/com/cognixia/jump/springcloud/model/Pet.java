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
	Integer petId;
	@Column(name="NAME")
	String name;
	@Column(name="TYPE")
	String type;
	@Column(name="AGE")
	Integer age;
	@Column(name="WEIGHT")
	Double weight;
	@Column(name="CUSTOMERID")
	Integer customerId;
	
	
	//constructors
	public Pet() {
		super();
	}
	public Pet(Integer petId, String name, String type, Integer age, Double weight, Integer customerId) {
		super();
		this.petId = petId;
		this.name = name;
		this.type = type;
		this.age = age;
		this.weight = weight;
		this.customerId = customerId;
	}
	
	
	//getters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getPetId() {
		return petId;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
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
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
	//toString()
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", type=" + type + ", age=" + age + ", weight=" + weight
				+ ", customerId=" + customerId + "]";
	}
	
}
