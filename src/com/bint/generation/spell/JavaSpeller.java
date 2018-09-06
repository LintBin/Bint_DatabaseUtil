package com.bint.generation.spell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.bint.reader.CustomizedWordReader;
import org.apache.commons.lang.StringUtils;

import com.bint.data.Column;
import com.bint.data.DataTypeHelper;
import com.bint.data.Table;
import com.bint.exception.TypeNotRecognizedException;
/**
 * java类生成的拼写规则
 * @author  BintLin
 * @data:  2015年1月8日 1 23:09:51
 * @version:  V1.0
 */
public class JavaSpeller extends BaseSpell{
	private static final String NEW_LINE = "\n";
	private static final String ONE_TAB = "    ";
	private static final String SPACE = " ";
	private static final String TWO_TAB = ONE_TAB + ONE_TAB;
	
	public static String getTableName (Table table){
		return getAapitalizeFomat(table.getName());
	}

	/**
	 * 从表中的字段转换成JavaBean里面的内容
	 * @param table
	 * @return String
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String getTableContent(Table table) throws FileNotFoundException, IOException{
		System.out.println("table: " + table.getName() );
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(getAnnotation(table));
		stringBuffer.append("public class ");
		//得到javabean里面的内容
		stringBuffer.append(StringUtils.capitalize(getTableName(table)));
		stringBuffer.append(SPACE + "{");
		stringBuffer.append(NEW_LINE);
		stringBuffer.append(this.getProperty(table));
		stringBuffer.append(getMethod(table));
		return stringBuffer.toString();
	}
	
	/**
	 * 得到属性,例如
	 * 		private String name;
	 * 		private int age;
	 * @param table
	 * @return StringBuffer
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private StringBuffer getProperty(Table table) throws FileNotFoundException, IOException{
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : table.getList()){
			stringBuffer.append(ONE_TAB);
			stringBuffer.append("private ");
			
			try {
				stringBuffer.append(DataTypeHelper.judgeDataType(column.getType()));
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
				stringBuffer.append(e.getType());
			}
			stringBuffer.append(" ");
			stringBuffer.append(this.getProperty(column.getName()));
			stringBuffer.append(";");
			stringBuffer.append(NEW_LINE);
		}
		stringBuffer.append(NEW_LINE);
		return stringBuffer;
	}
	/**
	 * @deprecated
	 * 规范属性名
	 *  FORM_CODE -- formCode
	 * @param property
	 * @return String
	 */
	private static String propertyFomat(String property){
		property = property.replaceFirst(property.substring(0, 1), property.substring(0, 1).toLowerCase());

		//如果不存在"_"的字符，则证明该数据库中不是以"_"来命名,而是以驼峰写法来命名
		if(property.indexOf("_") < 0){
			//将首字母变为小写
			return property;
		}else{
			property = StringUtils.lowerCase(property);
			StringBuffer stringBuffer = new StringBuffer();
			String[] strings ;
			strings = StringUtils.split(property, "_" );
			for(int i = 0 ; i<strings.length ; i++){
				if( i > 0){
					stringBuffer.append(StringUtils.capitalize(strings[i])) ;
				}else{
					stringBuffer.append(strings[0]);
				}
			}
			return stringBuffer.toString();
		}
	}

	/**
	 * 
	 * 方法
	 * @param table
	 * @return String
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws TypeNotRecognizedException 
	 */
	private static String getMethod(Table table) throws FileNotFoundException, IOException{
		List<Column> columns = table.getList();
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : columns){
			String camelCase = null;
			String columnName = column.getName();
			try {
				camelCase = DataTypeHelper.judgeDataType(column.getType());
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
				camelCase = e.getType();
			}
			
			
			/*************************set 方法****************************/
			/*stringBuffer.append(ONE_TAB);
			stringBuffer.append("public ");
			stringBuffer.append(camelCase);
			stringBuffer.append(" " + "set");
			stringBuffer.append(getAapitalizeFomat(columnName));
			stringBuffer.append("(String ");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(")" + SPACE + "{" + NEW_LINE);
			stringBuffer.append(TWO_TAB+"this." + propertyFomat(columnName) + " = " +propertyFomat(columnName));
			stringBuffer.append(";" + NEW_LINE + ONE_TAB + "}" + NEW_LINE);
			stringBuffer.append(NEW_LINE);*/
			
			/*********************get 方法 ******************************/
			/*stringBuffer.append(ONE_TAB);
			stringBuffer.append("public ");
			stringBuffer.append(getAapitalizeFomat(column.getName()));
			stringBuffer.append("get");
			stringBuffer.append(getAapitalizeFomat(column.getName()));
			stringBuffer.append("()");
			stringBuffer.append(SPACE + "{" + NEW_LINE);
			stringBuffer.append(TWO_TAB);
			stringBuffer.append("return ");
			stringBuffer.append("this.");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(";" + NEW_LINE);
			stringBuffer.append(ONE_TAB +"}" + NEW_LINE);
			stringBuffer.append(NEW_LINE);*/
		}
		stringBuffer.append(NEW_LINE + "}");
		return stringBuffer.toString();
	}
	/**
	 * WF_FORM_PRINT_TEMPLET -- WfFormPrintTemplet
	 * @param string
	 * @return String
	 */
	private static String getAapitalizeFomat(String string){
		return StringUtils.capitalize(propertyFomat(string));
	}
	
	/**
	 * 表名的注解
	 *  	//表名_table_name
	 * @return String
	 * @author linhongbin
	 */
	private static String getAnnotation(Table table){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("//表名");
		stringBuffer.append(table.getName());
		stringBuffer.append(NEW_LINE);
		return stringBuffer.toString();
	}


	public String getProperty(String columnName){

		String result = super.getInitialsCapitals(columnName);

		if(super.checkInList(result, CustomizedWordReader.LINE_LIST)){
			return result;
		}

		result = StringUtils.uncapitalise(result);

		return result ;
	}
}
 