package com.bint.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bint.dao.TableDao;
import com.bint.data.Column;
import com.bint.data.DataSource;

public class TableDaoMySQLImplTest {
	private TableDao tableDao = new TableDaoMySQLImpl(new DataSource());
	@Test
	public void getAllTableName(){
		List<String> tableNames = null;
		try {
			tableNames = tableDao.getAllTableName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String tableName : tableNames){
			System.out.println(tableName);
		}
	}
	
	@Test 
	public void getColumn(){
		List<Column> columns = null;
		try { 
			columns = tableDao.getAllColumnByTableName("blog_comment");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(columns.size());
		for (Column column : columns){
			System.out.println("column name :" + column.getName());
		}
		
		
	}
}
