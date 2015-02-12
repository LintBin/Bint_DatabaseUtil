package com.bint.dao;

import java.sql.SQLException;
import java.util.List;

import com.bint.data.Column;
import com.bint.data.Table;
/**
 * 
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:52:51
 * @version:  V1.0
 */
public interface TableDao {
	/**
	 * 得到某个表的所有的列
	 * @param tableName
	 * @throws SQLException
	 * @return List<Column>
	 * @author linhongbin
	 */
	public List<Column> getAllColumnByTableName(String tableName) throws SQLException;
	/**
	 * 得到当前数据库的所有的表名字
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
