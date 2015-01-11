package com.bint.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.data.DataSource;
import com.bint.db.info.MySQLInfo;

public class TableDaoMySQLImpl extends TableDaoBaseImpl implements TableDao {
	public TableDaoMySQLImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	@Override
	public List<Column> getAllColumnByTableName(String tableName)
			throws SQLException {
		System.out.println("getAllColumnByTableName is running");
		List<Column> result = new ArrayList<Column>();
		String sql = MySQLInfo.MYSQL_COLUMN_QUERY_SQL;
		System.out.println("sql");
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dataSource.getDbName());
		this.pstmt.setString(2, tableName);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Column column = new Column(tableName);
			column.setName(rs.getString(1));
			column.setType(rs.getString(2));
			result.add(column);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public List<String> getAllTableName() throws SQLException {
		List<String> all = new ArrayList<String>();
		String sql = MySQLInfo.MYSQL_TABLE_QUERY_SQL;
		String dataBaseName = dataSource.getDbName();
		System.out.println( "int mysql :  SQL executed is :" + sql );
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dataBaseName);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			String tableName = rs.getString(1);
			all.add(tableName);
		}
		this.pstmt.close();
		return all;
	}

}
