package com.mashen.product.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.mashen.product.domain.Product;
import com.mashen.product.service.ProductService;

@Namespace("/product")
@Action("listProduct")
@Result(name="success",location="list.jsp")
public class ListProductAction {
	@Autowired
	private ProductService service;
	private List<Product> productList;
	
	public String execute() throws Throwable{
		productList=service.listProduct();
		return "success";
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
}
