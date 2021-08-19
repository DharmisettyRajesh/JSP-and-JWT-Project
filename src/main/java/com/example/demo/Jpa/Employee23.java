package com.example.demo.Jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Employee23 {
	@Id
	private int id;
	private String name;
	private long phno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public Employee23(int id, String name, long phno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
	}
	public Employee23() {
		super();
	}
	

}
