package com.mashen.product.service;

import java.util.List;

import com.mashen.product.domain.Product;

public interface ProductService {
	
	public void addProduct(Product p) throws Throwable;
	
	public List<Product> listProduct() throws Throwable;
}
