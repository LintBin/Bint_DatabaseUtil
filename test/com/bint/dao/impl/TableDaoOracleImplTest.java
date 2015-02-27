package com.bint.dao.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.bint.data.DataSource;

public class TableDaoOracleImplTest {
	private TableDaoOracleImpl tableDao = new TableDaoOracleImpl(new DataSource());
	
	@Test
	public void test(){
		try {
			tableDao.test();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
