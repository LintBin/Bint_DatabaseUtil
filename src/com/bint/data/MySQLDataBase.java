package com.bint.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bint.dao.TableDao;
import com.bint.dao.impl.TableDaoMySQLImpl;

public class MySQLDataBase extends DataBase{
	private TableDao tableDao ;
	public MySQLDataBase(DataSource dataSource) {
		super(dataSource);
		this.dataSource = dataSource;
		tableDao = new TableDaoMySQLImpl(dataSource);
	}
	
	@Override
	public Map<String,Table> getTables() throws SQLException {
		List<String> tableNames = new ArrayList<String>();
		tableNames = tableDao.getAllTableName();
		Map<String,Table> tables = new HashMap<String,Table>() ;
		for(String tableName : tableNames){
			Table table = new Table();
			table.setName(tableName);
			table.setList(tableDao.getAllColumnByTableName(tableName));
			tables.put(tableName,table);
			System.out.println("table:" + table.getName());
		}
		return tables;
	}
	
	@Override
	public Map<String,Table> getTablesMap() throws SQLException {
		List<String> tableNames = new ArrayList<String>();
		tableNames = tableDao.getAllTableName();
		Map<String,Table> tables = new HashMap<String,Table>() ;
		for(String tableName : tableNames){
			Table table = new Table();
			table.setName(tableName);
			table.setList(tableDao.getAllColumnByTableName(tableName));
			tables.put(tableName, table);
		}
		return tables;
	}
}
