package com.bint.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.bint.data.Table;
/**
 * 书写类
 * @author  linhongbin
 * @data:  2015年2月12日 上午11:00:42
 * @version:  V1.0
 */
public class Writer {
	Map<String,Table> tables = null;
	public Writer(Map<String,Table> tables){
		this.tables = tables;
	}
	/**
	 * 利用tables生成javabean
	 * @throws IOException
	 */
	public void creatJavaBean() throws IOException{
		Speller speller = new Speller();
		File dir = new File("javabean");
		dir.mkdir();
		/*for(Table table : tables){
			//新建相应的java类
			File file = new File("javabean/" + speller.getTableName(table) + ".java");
			file.createNewFile();
			FileWriter fileWritter = new FileWriter("javabean/" + speller.getTableName(table) + ".java", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(speller.getTableContent(table));
			bufferWritter.close();
		}*/
		for(String keyName:tables.keySet()){
			Table table = tables.get(keyName);
			File file = new File("javabean/" + speller.getTableName(table) + ".java");
			file.createNewFile();
			FileWriter fileWritter = new FileWriter("javabean/" + speller.getTableName(table) + ".java", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(speller.getTableContent(table));
			bufferWritter.close();
		}
	}
}
