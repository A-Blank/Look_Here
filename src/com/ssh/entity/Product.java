package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="product")
public class Product {

	@Id	// 注解主键
	@GeneratedValue//id生成策略  默认auto 相当于hibernate的native - 自增字段
	private int id;
	
	@Column(name="name",nullable=false,length=32)
	private String name;
	
	@Column(name="cover",nullable=false,length=32)
	private String cover;
	
	@Column(name="price",nullable=false)
	private float price;
	
	private String introduce;
	
	@Column(name="category",nullable=false,length=32)
	private String category;
	
	@Column(name="isNew",nullable=false,length=32)
	private boolean isNew;

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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

	
}
