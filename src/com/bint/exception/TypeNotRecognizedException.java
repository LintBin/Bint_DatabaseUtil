package com.bint.exception;

public class TypeNotRecognizedException extends Exception{
	private static final long serialVersionUID = 1L;
	
	
	private String type ;
	public TypeNotRecognizedException(String type){
		super("不识别数据库的类型:"  + type);
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
