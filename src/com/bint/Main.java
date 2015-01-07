package com.bint;

import java.sql.SQLException;
import java.util.List;

import com.bint.data.DataBase;
import com.bint.data.Table;
import com.bint.generation.Writer;
import com.bint.util.DataBaseFactory;
import com.bint.util.DataSource;


public class Main {
	public static void main(String[] args) {
		DataBase dataBase = DataBaseFactory.getDataBaseInstance();
		List<Table> tables = null;
		try {
			tables = dataBase.getTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Writer writer = new Writer(tables);
	}
}
