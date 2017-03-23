package com.mashen.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDaoImp<T> implements BaseDao<T>{
	@Autowired
	protected HibernateTemplate template;

	public Serializable add(T entity) {
		/* template.persist(entity);
		 return 1;*/
		return template.save(entity);
	}

	public void delete(T entity) {
		template.delete(entity);
	}

	public void update(T entity) {
		template.update(entity);
	}

	public T get(Class<T> entityClass, Serializable id) {
		return template.get(entityClass, id);
	}

	/**
	 * 
	 * @param criterions
	 *            封装查询条件
	 * @param entityClass
	 *            返回类型
	 * @return
	 */
	public List<T> list(Criterion[] criterions, Class<T> entityClass,
			Order... orders) {
		return template.execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Criteria c = session.createCriteria(entityClass);
				if (criterions != null) {
					for (Criterion crion : criterions) {
						if(crion!=null)
							c.add(crion);
					}
				}
				if (orders != null) {
					for (Order order : orders) {
						c.addOrder(order);
					}
				}

				return c.list();
			}

		});
	}

	public List<T> listByPage(Criterion[] criterions, int pageSize, int offset,
			Class<T> entityClass, Order... orders) {
		return template.execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Criteria c = session.createCriteria(entityClass);
				if (criterions != null) {
					for (Criterion crion : criterions) {
						if(crion!=null)
						c.add(crion);
					}
				}
				if (orders != null) {
					for (Order order : orders) {
						c.addOrder(order);
					}
				}
				c.setFirstResult(offset);//设置分页开始位置
				c.setMaxResults(pageSize);//设置分页大小
				return c.list();
			}

		});
	}
	
	public Integer count(Criterion[] criterions,
			Class<T> entityClass) {
		return template.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				Criteria c = session.createCriteria(entityClass);
				if (criterions != null) {
					for (Criterion crion : criterions) {
						if(crion!=null)
						c.add(crion);
					}
				}
				c.setProjection(Projections.rowCount());
				Long count= (Long)c.uniqueResult();//确定是单条记录可以调用uniqueResult方法
				return count.intValue();
			}

		});
	}

}
