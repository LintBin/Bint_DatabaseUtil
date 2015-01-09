package com.bint.util;

import com.bint.data.DataBase;
import com.bint.data.DataSource;
import com.bint.data.OracleDataBase;

public class DataBaseFactory {
	private static DataSource dataSource = new DataSource();
	
	public static DataBase getDataBaseInstance(){
		return getDataBase();
	}
	public static DataBase getDataBase(){
		XMLUtil xmlUtil = new XMLUtil();
		System.out.println(xmlUtil.dbType);
		String result = xmlUtil.dbType.toLowerCase();
		System.out.println("result:" + result);
		if ("mysql".equals(result)){
			DataBase oracle =  new OracleDataBase(dataSource);
			System.out.println(" atfer new OracleDataBase" );
			return oracle;
		}else if("oracle".equals(result)){
			return new OracleDataBase(dataSource);
		}else if("sqlserver".equals(result)){
			//TODO 新建一个SQL Server的数据库
			
		}else if("sqllit".equals(result)){
			//TODO 新建一个SQLList的数据库
		}
		return null;
	}

}
