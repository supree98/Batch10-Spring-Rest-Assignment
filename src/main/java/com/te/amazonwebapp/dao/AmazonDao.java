package com.te.amazonwebapp.dao;

import java.util.List;

import com.te.amazonwebapp.bean.Admin;
import com.te.amazonwebapp.bean.Item;

public interface AmazonDao {

	public Admin authenticate(Integer id, String password);
	
	public boolean addItem(Item item);
	
	public boolean removeItem(Integer id);
	
	public Item searchItem(Integer id);
	
	public List<Item> getAllItems();
	
	public boolean updateItem(Item item);
}
