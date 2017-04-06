package com.mashen.product.action;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.mashen.product.domain.Product;
import com.mashen.product.service.ProductService;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/product")
@Action("doAddProduct")
@Result(name="success",location="listProduct.action",type="redirect")
public class DoAddProductAction implements ModelDriven<Product>{
	@Autowired
	private ProductService service;
	private Product product=new Product();
	private File uploadimg;
	private String uploadimgFileName;
	private String uploadimgContentType;
	

	
	public String execute() throws Throwable{
		String savePath="d:/apps/";
		String saveName=UUID.randomUUID()+"."+FilenameUtils.getExtension(uploadimgFileName);
		FileUtils.copyFile(uploadimg, new File(savePath+saveName));
		product.setImg(saveName);
		service.addProduct(this.product);
		return "success";
	}
	
	
	public File getUploadimg() {
		return uploadimg;
	}
	public void setUploadimg(File uploadimg) {
		this.uploadimg = uploadimg;
	}
	public String getUploadimgFileName() {
		return uploadimgFileName;
	}
	public void setUploadimgFileName(String uploadimgFileName) {
		this.uploadimgFileName = uploadimgFileName;
	}
	public String getUploadimgContentType() {
		return uploadimgContentType;
	}
	public void setUploadimgContentType(String uploadimgContentType) {
		this.uploadimgContentType = uploadimgContentType;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Override
	public Product getModel() {
		return product;
	}
}
