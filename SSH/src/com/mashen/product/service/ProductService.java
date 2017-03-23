package com.mashen.product.service;


import java.util.Map;

import com.mashen.common.page.PageVO;
import com.mashen.product.domain.Product;

public interface ProductService {
	
	public void addProduct(Product p) throws Exception;
	
	public PageVO<Product>  listProduct(PageVO<Product> page,Map<String,?> queryConditions) throws Exception;
}
