package com.bint.data;

import com.bint.db.info.IDataBaseInfo;
import com.bint.db.info.MySQLInfo;
import com.bint.db.info.OracleInfo;
import com.bint.util.XMLUtil;

public class DataSource {
	private XMLUtil xmlUtil = new XMLUtil();
	private IDataBaseInfo dataBaseInfo= null;
	
	public DataSource(){
		System.out.println("in the construction of DataSource:" + xmlUtil.dbName);
		dataBaseInfo = getDataInfo();
		System.out.println("in the construction of DataSource :" + dataBaseInfo.getUrl());
	}
	
	
	
	
	public XMLUtil getXmlUtil() {
		return xmlUtil;
	}


	
	public String getUsername() {
		return XMLUtil.dbUsername;
	}

	public String getPassword() {
		return XMLUtil.dbPassword;
	}
	
	public String getDbName(){
		return XMLUtil.dbName;
	}

	public String getUrl() {
		System.out.println("in the DataSource , url :" + dataBaseInfo.getUrl());
		return dataBaseInfo.getUrl() + getDbName();
	}
	
	public String getDriverName() {
		System.out.println("in the dataSource :" + dataBaseInfo.getDriverName());
		return dataBaseInfo.getDriverName();
	}

	public IDataBaseInfo getDataInfo(){
		System.out.println("getDataInfo");
		String result = xmlUtil.dbType.toLowerCase();
		if ("mysql".equals(result)){
			return new MySQLInfo();
		}else if("oracle".equals(result)){
			return new OracleInfo();
		}else if("sqlserver".equals(result)){
			//TODO 新建一个SQL Server的数据库
			
		}else if("sqllit".equals(result)){
			//TODO 新建一个SQLList的数据库
		}
		return null;
	}

	
}
