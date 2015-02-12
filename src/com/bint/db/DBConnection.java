package com.bint.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bint.data.DataSource;
/**
 * 数据库链接类
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:58:06
 * @version:  V1.0
 */
public class DBConnection {
	private Connection conn = null;
	private DataSource dataSource;
	public DBConnection(DataSource dataSource) throws Exception{
		this.dataSource = dataSource;
		Class.forName(dataSource.getDriverName());
		System.out.println("DataBase");
		System.out.println("Url : " + dataSource.getUrl());
		System.out.println("username :" + dataSource.getUsername());
		System.out.println( "password :" + dataSource.getPassword());
		this.conn =  DriverManager.getConnection(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword());		
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn!=null){
		    try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}