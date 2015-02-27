package com.bint.util;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;

import com.bint.data.DataBase;
import com.bint.data.Table;

public class DataBaseFactoryTest {
	@Test
	public void getDataBase(){
		DataBase dataBase = DataBaseFactory.getDataBase();
		try {
			Map<String,Table> tables = dataBase.getTables();
			for(String tableName : tables.keySet()){
				System.err.println(tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
