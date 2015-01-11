package com.bint.db.info;

public class MySQLInfo implements IDataBaseInfo {
	public static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL_PART = "jdbc:mysql://localhost:3306/";
	public static final String MYSQL_TABLE_QUERY_SQL = "select TABLE_NAME from information_schema.columns where table_schema = ? GROUP BY TABLE_NAME;";
	public static final String MYSQL_COLUMN_QUERY_SQL = "select column_name , data_type from information_schema.columns where table_schema = ? and TABLE_NAME = ?";
	public static final String QUERY_PRIMARY_KEY = "select Column_Name from information_schema.columns where table_schema = ? and TABLE_NAME = ? and column_key='pri'";
	@Override
	public String getUrl() {
		return MYSQL_URL_PART;
	}

	@Override
	public String getDriverName() {
		return MYSQL_DRIVER_NAME;
	}

	@Override
	public String getTablesQuerySql() {
		return MYSQL_TABLE_QUERY_SQL;
	}

	@Override
	public String getColumnquerySql() {
		return MYSQL_COLUMN_QUERY_SQL;
	}
}
