package com.bint.util;

import com.bint.data.DataBase;
import com.bint.data.DataSource;
import com.bint.data.MySQLDataBase;
import com.bint.data.OracleDataBase;
import com.bint.data.SQLServerDataBase;
import com.bint.exception.NotSupportDataBaseException;
/**
 * 数据库工厂类
 * @author  linhongbin
 * @data:  2015年2月12日    10:55:19
 * @version:  V1.0
 */
public class DataBaseFactory {
	private static DataSource dataSource = new DataSource();
	
	public static DataBase getDataBaseInstance() throws NotSupportDataBaseException{
		return getDataBase();
	}
	/**
	 * 得到数据库
	 * @return DataBase
	 * @author linhongbin
	 * @throws NotSupportDataBaseException 
	 */
	public static DataBase getDataBase() throws NotSupportDataBaseException{
		DbConfigXMLUtil dbConfigXmlUtil = new DbConfigXMLUtil();
		String result = dbConfigXmlUtil.dbType.toLowerCase();
		if ("mysql".equals(result)){
			return new MySQLDataBase(dataSource);
		}else if("oracle".equals(result)){
			return new OracleDataBase(dataSource);
		}else if("sqlserver".equals(result)){
			return new SQLServerDataBase(dataSource);
		}
		throw new NotSupportDataBaseException();
	}

}
