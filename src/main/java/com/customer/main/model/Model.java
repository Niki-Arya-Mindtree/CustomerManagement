package com.customer.main.model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "CustomerDataBase")
public class Model {
	
	@Id
	private int Id;
	@Column(name="Name")
	private String Name;
	@Column(name="Age")
	private int Age;
	@Column(name="Gender")
	private String Gender;
	
	
	
	public Model() {
		super();
	}
	public Model(int id, String name, int age, String gender) {
		super();
		Id = id;
		Name = name;
		Age = age;
		Gender = gender;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	
}
