package com.bint;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.bint.data.DataBase;
import com.bint.data.Table;
import com.bint.generation.Writer;
import com.bint.util.DataBaseFactory;

/**
 * 创建JavaBean的Main方法
 * @author  linhongbin
 * @data:  2015年2月12日 上午10:57:45
 * @version:  V1.0
 */
public class CreateJavaBeanMain {
	public static void main(String[] args) {
		DataBase dataBase = DataBaseFactory.getDataBaseInstance();
		Map<String,Table> tables = null;
		try {
			tables = dataBase.getTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Writer writer = new Writer(tables);
		try {
			writer.creatJavaBean();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
