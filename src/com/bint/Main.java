package com.bint;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bint.data.DataBase;
import com.bint.data.Table;
import com.bint.exception.NotSupportDataBaseException;
import com.bint.generation.TableWriter;
import com.bint.util.DataBaseFactory;

/**
 * Main方法
 * @author  linhongbin
 * @data:  2015月2月12日 10:57:45
 * @version:  V1.0
 */
public class Main {
	public static void main(String[] args) throws NotSupportDataBaseException {
		DataBase dataBase = DataBaseFactory.getDataBaseInstance();
		List<Table> tables = null;
		try {
			tables = dataBase.getTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TableWriter writer = new TableWriter(tables);
		try {
			writer.creatJavaBean();
			writer.createMapperXml();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
