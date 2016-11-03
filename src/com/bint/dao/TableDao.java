package com.bint.dao;

import java.sql.SQLException;
import java.util.List;

import com.bint.data.Column;
import com.bint.data.Table;
/**
 * 
 * @author  linhongbin
 * @data:  2015年2月12日 10:52:51
 * @version:  V1.0
 */
public interface TableDao {
	/**
	 * 得到指定的表名的Column
	 * @param tableName
	 * @throws SQLException
	 * @return List<Column>
	 * @author linhongbin
	 */
	public List<Column> getAllColumnByTableName(String tableName) throws SQLException;
	/**
	 * 得到所有的表名
	 * @throws SQLException
	 * @return List<String>
	 */
	public List<String> getAllTableName() throws SQLException;
	
	/**
	 * 判断是否为主键
	 * @param column
	 * @param table
	 * @throws SQLException
	 * @return Column
	 * @author linhongbin
	 */
	public Column isPrimaryKey(Column column , Table table) throws SQLException; 
}
