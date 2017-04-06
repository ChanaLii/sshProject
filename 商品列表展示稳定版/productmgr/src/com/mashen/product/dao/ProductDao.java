package com.mashen.product.dao;

import java.util.List;

import com.mashen.product.domain.Product;

public interface ProductDao {
	
	public void add(Product p) throws Throwable ;
	
	public List<Product> list() throws Throwable ;
}
