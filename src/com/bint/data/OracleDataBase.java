package com.bint.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bint.dao.TableDao;
import com.bint.dao.impl.TableDaoOracleImpl;
/**
 * TODO  Oralce数据库
 * @author  BintLin
 * @data:  2015年1月9日 下午4:49:58
 * @version:  V1.0
 */
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
			table.setName(tableName);
			table.setList(tableDao.getAllColumnByTableName(tableName));
			tables.add(table);
			System.out.println("table:" + table.getName());
		}
		return tables;
	}
	
}
