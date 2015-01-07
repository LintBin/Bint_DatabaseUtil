package com.bint.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bint.dao.impl.TableDaoOracleImpl;
import com.bint.data.Column;
import com.bint.util.DataSource;

public class TableDaoImplTest {
	private TableDaoOracleImpl tableDaoImpl;

	@Test
	public void getAllTableName() throws SQLException {
		List<String> tableNames = tableDaoImpl.getAllTableName();
		for (String name : tableNames) {
			System.out.println(name);
		}
	}

	@Test
	public void getAllColumnByTableName() throws SQLException {
		tableDaoImpl = new TableDaoOracleImpl(new DataSource());
		System.out.println("getAllColumnByTableName is running");
		List<Column> result = tableDaoImpl
				.getAllColumnByTableName("YW_HOLIDAY_APPLY");
		for (Column column : result) {
			System.out.println(column.toString());
		}
		
	}

	@Test
	public void write() throws IOException {
		File dir = new File("javabean");
		dir.mkdir();
		File file = new File("javabean/demo.java");
		file.createNewFile();
		FileWriter fileWritter = new FileWriter("javabean/demo.java", true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write("this is a demo \r\n adsa");
		bufferWritter.close();
	}

}
