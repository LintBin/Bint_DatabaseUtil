package com.bint.data;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bint.data.DataBase;
import com.bint.data.Table;
import com.bint.util.DataBaseFactory;

public class MySQLDataBaseTest {
	@Test
	public void test() throws SQLException{
		System.out.println("run");
		DataBase mysql = DataBaseFactory.getDataBase();
		List<Table> tables = mysql.getTables();
		System.out.println("size:" + tables.size());
		for(Table table : tables ){
			System.out.println(table.toString());
		}
	}
}
