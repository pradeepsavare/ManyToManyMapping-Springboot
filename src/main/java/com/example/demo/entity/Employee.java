package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "emp_dep",
	joinColumns = @JoinColumn(name = "emp_id"),
	inverseJoinColumns = @JoinColumn(name = "dep_id"))
	private Set<Department> depatrments = new HashSet<>();
	
	public Employee() {
		
	}

	public Employee(String name, String email, Set<Department> depatrments) {
		super();
		this.name = name;
		this.email = email;
		this.depatrments = depatrments;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Department> getDepatrments() {
		return depatrments;
	}

	public void setDepatrments(Set<Department> depatrments) {
		this.depatrments = depatrments;
	}
	
	
	
}
