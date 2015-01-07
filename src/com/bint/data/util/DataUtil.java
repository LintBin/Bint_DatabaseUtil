package com.bint.data.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.bint.data.Table;
import com.bint.db.DBConnection;
import com.bint.db.info.IDataBaseInfo;
import com.bint.util.DataSource;

public class DataUtil {
	public DBConnection dbCon = null;
	public PreparedStatement pstmt = null;
	public Connection conn = null;

	public DataUtil(DataSource dabaSource){
		/*try {
			dbCon = new DBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		conn = this.dbCon.getConnection();
	}
	
	public List<Table> getTables(){
		//TODO 判断什么数据库，返回该数据库所拥有的表
		
		return null;
	}
	
	
	
	public Table getOracleTable(){
		//TODO 对Oracle进行表查询，返回一个table类
		
		return null;
	}
	
	public Table getMySQLTable(){
		//TODO
		return null;
	}
}
