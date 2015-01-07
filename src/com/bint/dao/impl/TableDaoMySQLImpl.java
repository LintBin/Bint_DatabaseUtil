package com.bint.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.db.DBConnection;

public class TableDaoMySQLImpl implements TableDao {
	public DBConnection dbCon = null;
	public PreparedStatement pstmt = null;
	public Connection conn = null;
	@Override
	public List<Column> getAllColumnByTableName(String tableName)
			throws SQLException {
		
		return null;
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
