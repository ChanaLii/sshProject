package com.mashen.common.jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface Callback {
	
	public Object execute(Connection conn) throws SQLException;
}
