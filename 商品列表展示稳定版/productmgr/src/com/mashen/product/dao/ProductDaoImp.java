package com.mashen.product.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mashen.common.jdbc.DBtemplate;
import com.mashen.common.jdbc.PreparedStatementSetter;
import com.mashen.product.domain.Product;

@Repository
public class ProductDaoImp implements ProductDao {

	@Override
	public void add(Product p) throws Throwable {
		DBtemplate.executeUpdate("INSERT INTO product (productDesc, price, img) VALUES (?,?,?)",
				new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws Throwable {
				ps.setString(1,p.getProductDesc());
				ps.setFloat(2,p.getPrice());
				ps.setString(3,p.getImg());
			}
		});

	}

	@Override
	public List<Product> list() throws Throwable {
		return DBtemplate.list("select * from product",null, Product.class);
	}

}
