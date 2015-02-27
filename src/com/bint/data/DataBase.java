package com.bint.data;

import java.sql.SQLException;
import java.util.Map;

public abstract class DataBase {
	public DataSource dataSource;
	private String dbName;
	private String url;
	private String driverName;

	public DataBase(DataSource dataSource) {
		this.dataSource = dataSource;
		this.url = this.dataSource.getUrl();
		this.dbName = this.dataSource.getDbName();
	}

	public String getDbName() {
		return dbName;
	}

	public String getUrl() {
		return url;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Map<String,Table> getTables() throws SQLException {
		return null;
	}
	
	public Map<String,Table> getTablesMap() throws SQLException {
		return null;
	}
}
