package com.bint.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.data.DataSource;
import com.bint.data.Table;
import com.bint.db.info.MySQLInfo;
/**
 * 针对MySQL的表数据库访问层
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:51:46
 * @version:  V1.0
 */
public class TableDaoMySQLImpl extends TableDaoBaseImpl implements TableDao {
	public String dataBaseName = null;
	public TableDaoMySQLImpl(DataSource dataSource) {
		super(dataSource);
		dataBaseName = dataSource.getDbName();
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

	@Override
	public Column isPrimaryKey(Column column ,Table table) throws SQLException {
		String tableName = table.getName();
		String sql = MySQLInfo.QUERY_PRIMARY_KEY;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dataBaseName);
		this.pstmt.setString(2, tableName);
		String pkColumn = null;
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			pkColumn = rs.getString(1);
		}
		boolean flag = StringUtils.equals(column.getName(), pkColumn);
		return null;
	}

}
