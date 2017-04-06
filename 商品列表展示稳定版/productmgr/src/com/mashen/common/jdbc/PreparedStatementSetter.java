package com.mashen.common.jdbc;

import java.sql.PreparedStatement;

/**
 * 负责设置jdbc入参
 * @author liushd
 *
 */
public interface PreparedStatementSetter {
	public void setValues(PreparedStatement ps) throws Throwable;
}
