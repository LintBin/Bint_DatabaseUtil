package com.bint.util;

import com.bint.exception.NotDealtException;

public class WriteHelper {
	public String judgeDataType(String type) throws NotDealtException{
		String low_result = type.toLowerCase();
		if ("date".equals(low_result)){
			return "Date";
		}if("varchar2".equals(low_result)){
			return "String";
		}if("varchar".equals(low_result)){
			return "String";
		}if("bigint".equals(low_result)){
			return "long";
		}if("int".equals(low_result)){
			return "int";
		}
		throw new NotDealtException();
		
	}
}
