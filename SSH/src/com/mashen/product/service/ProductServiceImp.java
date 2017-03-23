package com.mashen.product.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ClassUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.common.page.PageUtil;
import com.mashen.common.page.PageVO;
import com.mashen.common.util.SpringUtil;
import com.mashen.product.dao.ProductDao;
import com.mashen.product.domain.Product;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	@Transactional
	public void addProduct(Product p) throws Exception {
		dao.add(p);
	}

	@Override
	public PageVO<Product> listProduct(PageVO<Product> page,
			Map<String,?> queryConditions) throws Exception {
		//Criterion[] criterions = {Restrictions.allEq(queryConditions)};
		Criterion[] criterions = { PageUtil.likeFull("productDesc",
				queryConditions.get("productDesc")) };
			
		Order[] orders = { Order.desc("id") };

		PageUtil.executePaging(dao, criterions, orders, page, Product.class);

		return page;
	}
	public static void main(String[] args) {
		ProductService service=SpringUtil.getBean(ProductService.class);
		PageVO<Product> page=new PageVO<Product>();
		page.setPageSize(2);
		page.setCurPage(1);
		Map<String,Object> queryConditions=new HashMap<String,Object>();
		queryConditions.put("productDesc","手机");
		//queryConditions.put("price",100.5f);
		try {
			service.listProduct(page, queryConditions);
			System.out.println(page);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
