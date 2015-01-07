package com.bint.data;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bint.util.DataBaseFactory;

public class OralceDataBaseTest {
	private DataBase oracle = DataBaseFactory.getDataBaseInstance();
	@Test
	public void getTables(){
		List<Table> tables = null;
		try {
			tables = oracle.getTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Table table : tables){
			System.out.println(table.toString());
		}
	}
}
