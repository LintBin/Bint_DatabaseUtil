package com.bint.data;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;

import com.bint.util.DataBaseFactory;

public class MySQLDataBaseTest {
	
	@Test
	public void test() throws SQLException {
		System.out.println("run");
		DataBase mysql = DataBaseFactory.getDataBase();
		Map<String,Table> tables = mysql.getTables();
		System.out.println("size:" + tables.size());
		for (String tableName : tables.keySet()) {
			Table table = tables.get(tableName);
			System.err.println(table.getName());
		}
	}

	@Test
	public void getTableMap() {
		DataBase mysql = DataBaseFactory.getDataBase();
		try {
			mysql.getTablesMap();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
