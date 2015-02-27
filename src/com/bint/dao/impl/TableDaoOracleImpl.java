package com.bint.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.data.Constraint;
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
		List<Column> result = new ArrayList<Column>();
		String sql = OracleInfo.ORACLE_COLUMN_QUERY_SQL;
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
	
	
	/**
	 * 获得该表主键作为的约束
	 * @param tableName
	 * @throws SQLException
	 * @return List<Constraint>
	 * @author linhongbin
	 */
	public List<Constraint> getConstriantName(String tableName) throws SQLException{
		String sql = OracleInfo.ORACLE_CONSTRAIN_NAME_QUERY_SQL;
		List<Constraint> result = new ArrayList<Constraint>();
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, tableName);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Constraint constraint = new Constraint();
			constraint.setContraintName(rs.getString(1));
			result.add(constraint);
		}
		this.pstmt.close();
		return result;
	}
	
	/**
	 * @return String
	 * @author linhongbin
	 */
	public String getPKName(String table){
		
		
		return null;
	}

	@Override
	public Column isPrimaryKey(Column column, Table table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void test() throws SQLException{
		//String sql = "CREATE TABLE class (cid NUMBER(10) NOT NULL,name VARCHAR2(30) NULL,CONSTRAINT PK_CLASS PRIMARY KEY (cid))";
		//System.err.println(sql);
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " + 
                " last VARCHAR(255), " + 
                " age INTEGER, " + 
                " PRIMARY KEY ( id ))"; 
		//this.pstmt = this.conn.prepareStatement(sql);
		stmt.executeUpdate(sql);
		//this.pstmt.close();
	}
}
