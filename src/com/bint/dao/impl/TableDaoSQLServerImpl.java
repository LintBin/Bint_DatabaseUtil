package com.bint.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.dao.impl.base.TableDaoBaseImpl;
import com.bint.data.Column;
import com.bint.data.DataSource;
import com.bint.data.Table;
import com.bint.db.info.SQLServerInfo;

public class TableDaoSQLServerImpl extends TableDaoBaseImpl implements TableDao{
	
	private String dataBaseName = null;
	
	public TableDaoSQLServerImpl(DataSource dataSource) {
		super(dataSource);
		dataBaseName = dataSource.getDbName();
	}
	
	@Override
	public List<String> getAllTableName() throws SQLException{
		List<String> all = new ArrayList<String>();
		String sql = SQLServerInfo.SQL_SERVER_TABLE_QUERY_SQL;
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			String tableName = rs.getString(1);
			all.add(tableName);
		}
		this.pstmt.close();
		return all;
	}
	
	@Override
	public List<Column> getAllColumnByTableName(String tableName) throws SQLException {
		List<Column> result = new ArrayList<Column>();
		String sql = SQLServerInfo.SQL_SERVER_COLUMN_QUERY_SQL;
		System.out.println("sql");
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, tableName);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Column column = new Column(tableName);
			column.setName(rs.getString(1));
			
			int typeCode = rs.getInt(2);
			
			String type = SQLServerInfo.SQLServerColumnType.getName(typeCode);
			
			column.setType(type);
			
			result.add(column);
		}
		this.pstmt.close();
		return result;
	}

	@Override
	public Column isPrimaryKey(Column column, Table table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
