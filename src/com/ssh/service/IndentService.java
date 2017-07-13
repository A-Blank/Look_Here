package com.ssh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.IndentDao;
import com.ssh.entity.Indent;
import com.ssh.entity.Item;
import com.ssh.entity.Product;

@Service
@Transactional
public class IndentService {

	@Autowired private IndentDao indentDao;

	private HttpSession httpSession;
	
	/*
	 * 创建订单
	 */
	public Indent createIndent(Product product) {
		Indent indent = new Indent();
		List<Item> items = new ArrayList<Item>();
		indent.setItems(items);
		indent.setAmount(0);
		indent.setTotal(0);
		addItem(indent, product);
		return indent;
	}

	/*
	 * 添加订单商品项
	 */
	public void addItem(Indent indent, Product product) {
		indent.setAmount(indent.getAmount()+1);
		indent.setTotal(indent.getTotal()+product.getPrice());
		List<Item> items = indent.getItems();
		for (Item item : items) {
			if (item.getProduct().getId() == product.getId()) {
				item.setAmount(item.getAmount() + 1);
				item.setTotal(item.getPrice()*item.getAmount());
				return;
			}
		}
		Item item = new Item();
		item.setAmount(1);
		item.setIndent(indent);
		item.setPrice(product.getPrice());
		item.setProduct(product);
		item.setTotal(item.getPrice()*item.getAmount());
		items.add(item);
		return;
	}
	
	/*
	 * 订单提交
	 */
	public Indent saveIndent(Indent indent){
		indent.setStatus(1);
		indent.setSystime(new Date());
		indentDao.save(indent);
		for(Item item : indent.getItems()){
			item.setIndent(indent);
			indentDao.save(item);
		}
		return indent;
	}

	public List<Indent> findIndentsByUserId(String userId) {
		List<Indent> indents=indentDao.findIndentsByUserId(userId);
		return indents;
	}

	public List<Item> findItemsByIndentID(int id) {
		return indentDao.findItemsByIndentID(id);
	}


}
