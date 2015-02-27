package com.bint.data;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;

import com.bint.util.DataBaseFactory;

public class OralceDataBaseTest {
	private DataBase oracle = DataBaseFactory.getDataBaseInstance();
	@Test
	public void getTables(){
		Map<String,Table> tables = null;
		try {
			tables = oracle.getTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(String tableName : tables.keySet()){
			System.out.println(tableName);
		}
	}
}
