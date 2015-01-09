package com.bint.data;

import java.util.List;

public class MySQLDataBase extends DataBase{

	public MySQLDataBase(DataSource dataSource) {
		super(dataSource);
	}
	@Override
	public List<Table> getTables() {
		
		return null;
	}

	public String getDBName() {
		// TODO Auto-generated method stub
		return null;
	}

}
