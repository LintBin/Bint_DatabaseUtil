package com.bint.exception;

public class TypeNotRecognizedException extends Exception{
	private static final long serialVersionUID = 1L;

	public TypeNotRecognizedException(String type){
		super("这种数据类型无法识别:" + "数据类型为" + type);
	}
}
