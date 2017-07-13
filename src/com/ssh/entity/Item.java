package com.ssh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id	// 注解主键
	@GeneratedValue //id生成策略  默认auto 相当于native - 自增字段
	private int id;
	private float price;
	private int amount;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Indent indent;

	private float total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Indent getIndent() {
		return indent;
	}
	public void setIndent(Indent indent) {
		this.indent = indent;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
