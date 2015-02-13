package com.bint.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.bint.exception.TypeNotRecognizedException;
/**
 * 数据类型助手，用来处理数据库中相关的数据类型
 * @author BintLin
 *
 */
public class DataTypeHelper {
	/**
	 * 判断数据库的类型与Java类型所对应的关系
	 * @param type
	 * @return Java类型中所对应的类型，对应关系如下：
	 * 		data      ---  Data
	 *  	varchar   ---  String
	 *  	varchar2  ---  String
	 *  	bigint    ---  long
	 *  	int		  ---  int
	 * 		number    ---  long
	 * 	 	clob 	  ---  byte[]
	 *      blob      ---  byte[]
	 *      text      ---  String
	 * @throws TypeNotRecognizedException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static String judgeDataType(String type) throws TypeNotRecognizedException, FileNotFoundException, IOException{
		String lowResult = StringUtils.lowerCase(type);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/type.properties"));
		Enumeration<Object> es = prop.keys();
		//从Properties中取出key去比对
		while(es.hasMoreElements()){
			String lowTypeStr = (String) es.nextElement();
			if(StringUtils.equals(lowTypeStr,lowResult)){
				return prop.getProperty(lowTypeStr);
			}
		}
		throw new TypeNotRecognizedException(type);
	}
}
