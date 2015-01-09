package com.bint.data;

import org.apache.commons.lang.StringUtils;

import com.bint.exception.NotDealtException;
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
	 * @throws TypeNotRecognizedException
	 */
	public static String judgeDataType(String type) throws TypeNotRecognizedException{
		String low_result = StringUtils.lowerCase(type);
		if (StringUtils.equals("date",low_result)){
			return "Date";
		}if(StringUtils.equals("varchar2", low_result)){
			return "String";
		}if(StringUtils.equals("varchar",low_result)){
			return "String";
		}if(StringUtils.equals("bigint",low_result)){
			return "long";
		}if(StringUtils.equals("int", low_result)){
			return "int";
		}if(StringUtils.equals("number",low_result)){
			return "long";
		}if(StringUtils.equals("clob", low_result)){
			return "byte[]";
		}if(StringUtils.equals("blob", low_result)){
			return "byte[]";
		}
		throw new TypeNotRecognizedException(type);
	}
}
