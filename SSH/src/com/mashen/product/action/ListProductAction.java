package com.mashen.product.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.mashen.common.page.PageVO;
import com.mashen.product.domain.Product;
import com.mashen.product.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/product")
@Action("listProduct")
@Result(name="success",location="list.jsp")
public class ListProductAction extends ActionSupport implements ModelDriven<PageVO<Product>>{
	@Autowired
	private ProductService service;
	private PageVO<Product> pagevo=new PageVO<Product>();
	private String productDesc;
	
	public PageVO<Product> getPagevo() {
		return pagevo;
	}


	public void setPagevo(PageVO<Product> pagevo) {
		this.pagevo = pagevo;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public String execute() throws Exception{
		Map<String,String> queryConditions=new HashMap<String,String>();
		queryConditions.put("productDesc", this.productDesc);
		System.out.println(queryConditions);
		pagevo=service.listProduct(pagevo, queryConditions);
		return "success";
	}
	

	@Override
	public PageVO<Product> getModel() {
		return pagevo;
	}

	
}
