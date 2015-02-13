package com.bint.util;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bint.data.DataBase;
import com.bint.data.Table;

public class DataBaseFactoryTest {
	@Test
	public void getDataBase(){
		DataBase dataBase = DataBaseFactory.getDataBase();
		try {
			List<Table> tables = dataBase.getTables();
			for(Table table : tables){
				System.err.println(table.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
