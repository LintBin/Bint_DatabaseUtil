package com.bint.dao;

import java.sql.SQLException;
import java.util.List;

import com.bint.data.Column;

public interface TableDao {
	public List<Column> getAllColumnByTableName(String tableName) throws SQLException;
	public List<String> getAllTableName() throws SQLException;
}
