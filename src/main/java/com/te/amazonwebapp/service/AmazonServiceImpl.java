package com.te.amazonwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.amazonwebapp.bean.Admin;
import com.te.amazonwebapp.bean.Item;
import com.te.amazonwebapp.dao.AmazonDaoImpl;

@Service
public class AmazonServiceImpl implements AmazonService{

	@Autowired
	AmazonDaoImpl amazonDao;
	
	@Override
	public Admin authenticate(Integer id, String password) {
		
		Admin admin = amazonDao.authenticate(id, password);
		return admin;
	}

	@Override
	public boolean addItem(Item item) {
		boolean result = amazonDao.addItem(item) ;
		return result;
	}

	@Override
	public boolean removeItem(Integer id) {
		boolean result = amazonDao.removeItem(id);
		return result;
	}

	@Override
	public Item searchItem(Integer id) {
		Item item = amazonDao.searchItem(id);
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> list = amazonDao.getAllItems();
		return list;
	}

	@Override
	public boolean updateItem(Item item) {
		boolean result = amazonDao.updateItem(item);
		return result;
	}

}
