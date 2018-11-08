package com.bint.data;

import com.bint.db.info.IDataBaseInfo;
import com.bint.db.info.MySQLInfo;
import com.bint.db.info.OracleInfo;
import com.bint.db.info.SQLServerInfo;
import com.bint.util.DbConfigXMLUtil;

public class DataSource {
	private DbConfigXMLUtil dbConfigXmlUtil = new DbConfigXMLUtil();
	private IDataBaseInfo dataBaseInfo= null;
	
	public DataSource(){
		System.out.println("in the construction of DataSource:" + dbConfigXmlUtil.dbName);
		dataBaseInfo = getDataInfo();
		System.out.println("in the construction of DataSource :" + dataBaseInfo.getUrl());
	}

	public DbConfigXMLUtil getDbConfigXmlUtil() {
		return dbConfigXmlUtil;
	}

	public String getUsername() {
		return DbConfigXMLUtil.dbUsername;
	}

	public String getPassword() {
		return DbConfigXMLUtil.dbPassword;
	}
	
	public String getDbName(){
		return DbConfigXMLUtil.dbName;
	}



	public String getUrl() {
		System.out.println("in the DataSource , url :" + dataBaseInfo.getUrl() + getDbName());
		return dataBaseInfo.getUrl() + getDbName();
	}
	
	public String getDriverName() {
		System.out.println("in the dataSource :" + dataBaseInfo.getDriverName());
		return dataBaseInfo.getDriverName();
	}

	public IDataBaseInfo getDataInfo(){
		System.out.println("getDataInfo");
		String result = dbConfigXmlUtil.dbType.toLowerCase();
		if ("mysql".equals(result)){
			System.out.println("mysql数据库");
			return new MySQLInfo();
		}else if("oracle".equals(result)){
			System.out.println("oracle 数据库");
			return new OracleInfo();
		}else if("sqlserver".equals(result)){
			return new SQLServerInfo();
		}
		return null;
	}

	
}
