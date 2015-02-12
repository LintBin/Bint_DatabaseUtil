package com.bint.util;

/**
 * 数据库的相关信息
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:56:36
 * @version:  V1.0
 */
public class DriverInfoUtil {
	public static final String ORACLED_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String SQLLITE_DRIVER_NAME = "";
	public static final String SQL_SERVER_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	
	public static final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:";
	public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/";
	public static final String SQLLITE_URL="";
	public static final String SQL_SERVER_URL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=";


}
