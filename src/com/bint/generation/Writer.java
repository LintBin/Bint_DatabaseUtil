package com.bint.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bint.data.Column;
import com.bint.data.Table;
import com.bint.generation.spell.JavaSpeller;
import com.bint.generation.spell.MapperXmlSpell;

/**
 * 控制写入文件的类
 * @author  linhongbin
 * @data:  2015年2月12日 11:00:42
 * @version:  V1.0
 */
public class Writer {
	List<Table> tables = null;
	public Writer(List<Table> tables){
		this.tables = tables;
	}
	
	/**
	 * 生成javabean
	 * @throws IOException
	 */
	public void creatJavaBean() throws IOException{
		JavaSpeller speller = new JavaSpeller();
		File dir = new File("javabean");
		dir.mkdir();
		for(Table table : tables){
			//生成文件
			File file = new File("javabean/" + speller.getTableName(table) + ".java");
			file.createNewFile();
			FileWriter fileWritter = new FileWriter("javabean/" + speller.getTableName(table) + ".java", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(speller.getTableContent(table));
			bufferWritter.close();
		}
		for(Table table : tables){
			System.out.println(table.toString());
		}
	}

	public void createMyBatisXml() throws IOException {

		String dirName = "mybatis-xml";
		File dir = new File(dirName);
		dir.mkdir();

		for(Table table : tables){

			MapperXmlSpell mapperXmllSpell = new MapperXmlSpell(table);

			//生成文件
			String path = dirName + "/" + mapperXmllSpell.getXmlName();
			File file = new File(path);
			file.createNewFile();

			FileWriter fileWritter = new FileWriter( path, true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

			List<Column> columnList = table.getList();

			bufferWritter.write(mapperXmllSpell.getImport());

			bufferWritter.write(mapperXmllSpell.getMapper());


			bufferWritter.write(mapperXmllSpell.getResultMap());

			for(Column column : columnList){

				String word = mapperXmllSpell.getResult();

				word = word.replace("#{column}", column.getName());
				word = word.replace("#{property}", mapperXmllSpell.getProperty(column.getName()));

				bufferWritter.write(word);
			}

			bufferWritter.write(mapperXmllSpell.getResultMapEnd());


			bufferWritter.write(mapperXmllSpell.getSql());
			bufferWritter.write(mapperXmllSpell.getMapperEnd());
			bufferWritter.close();
		}
	}
}
