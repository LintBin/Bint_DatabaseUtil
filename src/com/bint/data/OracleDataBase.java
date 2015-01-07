package com.bint.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.dao.impl.TableDaoOracleImpl;
import com.bint.util.DataSource;

public class OracleDataBase extends DataBase{
	private DataSource dataSource ;
	private TableDao tableDao;
	public OracleDataBase(DataSource dataSource) {
		super(dataSource);
		this.dataSource = dataSource;
		tableDao = new TableDaoOracleImpl(dataSource);
	}
	@Override
	public List<Table> getTables() throws SQLException {
		List<String> tableNames = new ArrayList<String>();
		tableNames = tableDao.getAllTableName();
		List<Table> tables = new ArrayList<Table>() ;
		for(String tableName : tableNames){
			Table table = new Table();
			table.setList(tableDao.getAllColumnByTableName(tableName));
			tables.add(table);
		}
		return tables;
	}
	
}
