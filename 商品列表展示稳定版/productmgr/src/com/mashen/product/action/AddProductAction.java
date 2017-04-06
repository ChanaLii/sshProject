package com.mashen.product.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/product")
@Action("addProduct")
@Result(name="success",location="add.jsp")
public class AddProductAction {
	public String execute(){
		return "success";
	}
}
