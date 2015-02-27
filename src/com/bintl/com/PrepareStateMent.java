package com.bintl.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.bint.data.DataSource;
import com.bint.db.DBConnection;

public class PrepareStateMent {
	public DBConnection dbCon = null;
	public PreparedStatement pstmt = null;
	public Connection conn = null;
	public DataSource dataSource;

	public PrepareStateMent(DataSource dataSource) {
		try {
			this.dataSource = dataSource;
			dbCon = new DBConnection(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = this.dbCon.getConnection();
	}

	
	public void getAllColumnByTableName(String tableName) throws SQLException {
		String sql = null;
		sql = "CREATE TABLE 'class' ('cid' NUMBER(10) NOT NULL,'name' VARCHAR2(30) NULL,CONSTRAINT 'PK_CLASS' PRIMARY KEY ('cid')"; 
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dataSource.getDbName());
		ResultSet rs = this.pstmt.executeQuery();
		this.pstmt.close();
	}
}
