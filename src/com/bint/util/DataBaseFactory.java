package com.bint.util;

import com.bint.data.DataBase;
import com.bint.data.DataSource;
import com.bint.data.MySQLDataBase;
import com.bint.data.OracleDataBase;
/**
 * 数据库工厂
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:55:19
 * @version:  V1.0
 */
public class DataBaseFactory {
	private static DataSource dataSource = new DataSource();
	
	public static DataBase getDataBaseInstance(){
		return getDataBase();
	}
	/**
	 * 得到数据库实例
	 * @return DataBase
	 * @author linhongbin
	 */
	public static DataBase getDataBase(){
		XMLUtil xmlUtil = new XMLUtil();
		String result = xmlUtil.dbType.toLowerCase();
		if ("mysql".equals(result)){
			return new MySQLDataBase(dataSource);
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
