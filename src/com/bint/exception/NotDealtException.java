package com.bint.exception;

public class NotDealtException extends Exception{
	private static final long serialVersionUID = -2016099611924168847L;

	public NotDealtException(){
		super("这种状况无法识别");
	}
}