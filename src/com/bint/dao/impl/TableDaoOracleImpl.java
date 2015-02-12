package com.bint.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.data.DataSource;
import com.bint.data.Table;
import com.bint.db.info.OracleInfo;
/**
 * 针对Oracle的表数据库访问层
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:52:25
 * @version:  V1.0
 */
public class TableDaoOracleImpl extends TableDaoBaseImpl implements TableDao{
	
	public TableDaoOracleImpl(DataSource dataSource) {
		super(dataSource);
	}

	public List<String> getAllTableName() throws SQLException {
		List<String> all = new ArrayList<String>();
		String sql = OracleInfo.ORACLE_TABLE_QUERY_SQL;
		System.out.println( "SQL executed is :" + sql );
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
	public List<Column> getAllColumnByTableName(String tableName)
			throws SQLException {
		System.out.println("getAllColumnByTableName is running");
		List<Column> result = new ArrayList<Column>();
//		String sql = "select column_name , data_type from user_tab_columns where Table_Name= ?";
		String sql = OracleInfo.ORACLE_COLUMN_QUERY_SQL;
		System.out.println("sql");
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, tableName);
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
	public Column isPrimaryKey(Column column , Table table) throws SQLException{
		String sql = "select * from user_constraints a, user_ind_columns b where a.index_name = b.index_name and b.table_name = ? and b.column_name = 'C_USER' and a.constraint_type = 'P';";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, column.getName());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.getString(1) == null){
			column.setForeignKey(false);
		}else{
			column.setForeignKey(true);
		}
		return column;
	}
}
