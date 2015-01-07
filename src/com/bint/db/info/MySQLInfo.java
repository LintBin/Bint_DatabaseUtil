package com.bint.db.info;

public class MySQLInfo implements IDataBaseInfo {
	public static final String MYSQL_DRIVER_NAME = "MYSQL.jdbc.driver.MYSQLriver";
	public static final String MYSQL_URL_PART = "jdbc:MYSQL:thin:@127.0.0.1:1521:";
	public static final String MYSQL_TABLE_QUERY_SQL = "";
	public static final String MYSQL_COLUMN_QUERY_SQL= "";
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColumnquerySql() {
		// TODO Auto-generated method stub
		return null;
	}
}
