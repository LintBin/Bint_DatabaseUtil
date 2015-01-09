package com.bint.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bint.data.DataSource;
import com.bint.db.DBConnection;

public class TableDaoBaseImpl {
	public DBConnection dbCon = null;
	public PreparedStatement pstmt = null;
	public Connection conn = null;
	
	public TableDaoBaseImpl(DataSource dataSource) {
		try {
			dbCon = new DBConnection(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = this.dbCon.getConnection();
	}
}
