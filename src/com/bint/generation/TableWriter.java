package com.bint.generation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.bint.data.Column;
import com.bint.data.JdbcTypeHelper;
import com.bint.data.Table;
import com.bint.generation.spell.BaseSpell;
import com.bint.generation.spell.JavaSpeller;
import com.bint.generation.spell.MapperXmlSpell;
import com.bint.util.DbConfigXMLUtil;
import com.bint.constants.Constants;

/**
 * 控制写入文件的类
 * @author  linhongbin
 * @data:  2015年2月12日 11:00:42
 * @version:  V1.0
 */
public class TableWriter extends BaseSpell{
	List<Table> tables = null;
	public TableWriter(List<Table> tables){
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

			String dbType = DbConfigXMLUtil.dbType;

			for(Column column : columnList){

				String word = mapperXmllSpell.getResult();

				word = word.replace("#{column}", column.getName());
				word = word.replace("#{property}", mapperXmllSpell.getProperty(column.getName()));

				String dbTypeInCofing = dbType + "." +  column.getType();
				String type = JdbcTypeHelper.getJdbcType(dbTypeInCofing);
				if(type == null){
					System.out.println("没有" + dbTypeInCofing + "类型");
					continue;
				}
				word = word.replace("#{type}" , type);

				bufferWritter.write(word);
			}

			bufferWritter.write(mapperXmllSpell.getResultMapEnd());

			bufferWritter.write(mapperXmllSpell.getSql());



			//update的sql
			String updateTag = mapperXmllSpell.getUpdateTag();
			String fieldStr = "";
			for(Column column : columnList){
				//fieldStr = fieldStr + "\n"  + column.getName() + " = " + "#{ " + mapperXmllSpell.getProperty(column.getName()) + "}" + ",";
				String line = NEW_LINE + column.getName() + " = " + "#{ " + mapperXmllSpell.getProperty(column.getName()) + "}" + ",";
				line = this.generateLine(3,line);

				fieldStr = fieldStr + line;
			}

			fieldStr = fieldStr.substring(0, fieldStr.length() - 1);

			updateTag = updateTag.replace("#{field}", fieldStr);
			updateTag = updateTag.replace("#{table}", table.getName());
			updateTag = this.generateLine(1, updateTag);
			bufferWritter.write(updateTag);

			bufferWritter.write(mapperXmllSpell.getMapperEnd());
			bufferWritter.close();
		}
	}

	public void createMapperXml() throws IOException {
		String dirName = "mybatis-xml";
		File dir = new File(dirName);
		dir.mkdir();



		String template = this.getMapperXmlTemplate();

		for(Table table: tables){

			String templateClone = new String(template);

			String tableName = table.getName();

			String mapperName = tableName + "Mapper";

			//生成文件
			String path = dirName + "/" + mapperName + ".xml";
			File file = new File(path);

			//替换mapper名字
            templateClone = templateClone.replace("#{namespace}", mapperName);


			//替换实体名字
            templateClone = templateClone.replace("#{baseResultType}", tableName);

			//更换列名字
			String sqlDatil = this.getSqlDatil(table);
            templateClone = templateClone.replace("#{sqlDatil}", sqlDatil);




			file.createNewFile();

			FileWriter fileWritter = new FileWriter( path, true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

			bufferWritter.write(templateClone);

			bufferWritter.close();
		}
	}

	/**
	 * 得到mapper的模版
	 * @return
	 */
	private String getMapperXmlTemplate(){
		File mapperXmlTemplateFile = new File("src/com/bint/db/info/template/resultListDetailTemplate");

		List<String> stringList = new ArrayList<>();
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(mapperXmlTemplateFile),Constants.FILE_ENCODING);

			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";
			line = br.readLine();
			while (line != null) {
				line = br.readLine(); // 一次读入一行数据

				if(line != null){
					stringList.add(line + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuilder stringBuilder = new StringBuilder();

		for(String string : stringList){
			stringBuilder.append(string);
		}

		return stringBuilder.toString();
	}


	private String getSqlDatil(Table table){

		List<Column> columnList = table.getList();


		StringBuilder stringBuilder = new StringBuilder();

		for(Column column : columnList){

			String string = "`" + column.getName() + "` , ";

			stringBuilder.append(string);
		}


		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

		return stringBuilder.toString();
	}




}
