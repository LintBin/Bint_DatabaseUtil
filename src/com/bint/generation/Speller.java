package com.bint.generation;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bint.data.Column;
import com.bint.data.DataTypeHelper;
import com.bint.data.Table;
import com.bint.exception.TypeNotRecognizedException;
/**
 * 拼写要被书写进java文件里面的内容
 * @author  BintLin
 * @data:  2015年1月8日 下午3:09:51
 * @version:  V1.0
 */
public class Speller {
	private static final String NEW_LINE = "\n";
	private static final String ONE_TAB = "    ";
	private static final String SPACE = " ";
	private static final String TWO_TAB = ONE_TAB + ONE_TAB;
	public static String getTableName (Table table){
		return getAapitalizeFomat(table.getName());
	}
	/**
	 * 根据一个表来生成它对应的javabean里面的文字
	 * @param table
	 * @return String
	 */
	public static String getTableContent(Table table){
		System.out.println("table: " + table.getName() );
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(getAnnotation(table));
		stringBuffer.append("public class ");
		//插入类名
		stringBuffer.append(StringUtils.capitalize(getTableName(table)));
		stringBuffer.append(SPACE + "{");
		stringBuffer.append(NEW_LINE);
		stringBuffer.append(getProperty(table));
		stringBuffer.append(getMethod(table));
		return stringBuffer.toString();
	}
	
	/**
	 * 得到一个表里面属性所输出来的属性,如：
	 * 		private String name;
	 * 		private int age;
	 * @param table
	 * @return StringBuffer
	 */
	private static StringBuffer getProperty(Table table){
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : table.getList()){
			stringBuffer.append(ONE_TAB);
			stringBuffer.append("private ");
			//判断返回数据库中的数据类型所对应的Java类型,并插入StringBuffer
			try {
				stringBuffer.append(DataTypeHelper.judgeDataType(column.getType()));
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
			}
			stringBuffer.append(" ");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(";");
			stringBuffer.append(NEW_LINE);
		}
		stringBuffer.append(NEW_LINE);
		return stringBuffer;
	}
	/**
	 * 格式化属性，去掉_，并将属性改为驼峰写法(首字母小写)
	 *  FORM_CODE -- formCode
	 * @param property
	 * @return String
	 */
	private static String propertyFomat(String property){
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
	/**
	 * 
	 * 得到方法的写法
	 * @param table
	 * @return String
	 * @throws TypeNotRecognizedException 
	 */
	private static String getMethod(Table table){
		List<Column> columns = table.getList();
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : columns){
			String camelCase = null;
			String columnName = column.getName();
			try {
				camelCase = DataTypeHelper.judgeDataType(column.getType());
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
			}
			
			
			/*************************set 方法****************************/
			stringBuffer.append(ONE_TAB);
			stringBuffer.append("public ");
			stringBuffer.append(camelCase);
			stringBuffer.append(" " + "set");
			stringBuffer.append(getAapitalizeFomat(columnName));
			stringBuffer.append("(String ");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(")" + SPACE + "{" + NEW_LINE);
			stringBuffer.append(TWO_TAB+"this." + propertyFomat(columnName) + " = " +propertyFomat(columnName));
			stringBuffer.append(";" + NEW_LINE + ONE_TAB + "}" + NEW_LINE);
			stringBuffer.append(NEW_LINE);
			
			/*********************get 方法 ******************************/
			stringBuffer.append(ONE_TAB);
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
			stringBuffer.append(NEW_LINE);
		}
		stringBuffer.append(NEW_LINE + "}");
		return stringBuffer.toString();
	}
	/**
	 *  返回这个String的驼峰写下(首字母大写),例如:
	 * WF_FORM_PRINT_TEMPLET -- WfFormPrintTemplet
	 * @param string
	 * @return String
	 */
	private static String getAapitalizeFomat(String string){
		return StringUtils.capitalize(propertyFomat(string));
	}
	
	/**
	 * 获得该类的注释，注释为:
	 *  	//对应的的表为T_table_name
	 *    ps:表名大写大小写不变
	 * @return String
	 * @author linhongbin
	 */
	private static String getAnnotation(Table table){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("//对应的表为");
		stringBuffer.append(table.getName());
		stringBuffer.append(NEW_LINE);
		return stringBuffer.toString();
	}
}
 