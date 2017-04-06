package com.mashen.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;


public class DBtemplate {
	
	public static Object execute(Callback c) throws SQLException{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		try{
			return c.execute(conn);
		}finally{
			ConnectionFactory.closeAll(conn, null, null);
		}
	}
	/**
	 * 只适用于增删改
	 * @param sql
	 * @param setter
	 * @return 影响行数
	 * @throws Throwable 
	 */
	public static Integer executeUpdate(String sql,PreparedStatementSetter setter) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			return ps.executeUpdate();
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	}
	
	public static <T> T get(String sql,PreparedStatementSetter setter,Class<T> type) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			ResultSet rs=ps.executeQuery();
		    ResultSetMetaData metaData=rs.getMetaData();
			if(rs.next()){
				T bean=type.newInstance();
			     for(int i=1;i<=metaData.getColumnCount();i++){
			    	 BeanUtils.setProperty(bean,metaData.getColumnName(i),rs.getObject(i));
			     }
				return bean;
			}
			return null;
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	} 
	
	public static <T> List<T> list(String sql,PreparedStatementSetter setter,Class<T> type) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			List<T> list=new ArrayList<T>();
			while(rs.next()){
				 T bean=type.newInstance();
			     for(int i=1;i<=metaData.getColumnCount();i++){
			    	 BeanUtils.setProperty(bean,metaData.getColumnName(i),rs.getObject(i));
			     }
			     list.add(bean);
			}
			return list;
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	} 
	
}
