package com.mashen.common.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
public interface BaseDao<T> {
	public Serializable add(T entity);

	public void delete(T entity);

	public void update(T entity);

	public T get(Class<T> entityClass, Serializable id);

	public List<T> list(Criterion[] criterions, Class<T> entityClass,
			Order... orders);

	public List<T> listByPage(Criterion[] criterions, int pageSize, int offset,
			Class<T> entityClass, Order... orders);

	public Integer count(Criterion[] criterions, Class<T> entityClass);

}
