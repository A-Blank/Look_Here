package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user",uniqueConstraints={@UniqueConstraint(columnNames={"phone"})})
public class User {

	@Id
	@GeneratedValue(generator="id",strategy=GenerationType.IDENTITY)   
    @GenericGenerator(name="id",strategy="uuid")  
	private String id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="password",nullable=false,length=32)
	private String password;
	
	@Column(name="phone",nullable=false,length=32,unique=true)
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
