package com.mashen.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashen.product.dao.ProductDao;
import com.mashen.product.domain.Product;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductDao dao;
	@Override
	public void addProduct(Product p) throws Throwable {
		dao.add(p);
	}

	@Override
	public List<Product> listProduct() throws Throwable{
		return dao.list();
	}

}
