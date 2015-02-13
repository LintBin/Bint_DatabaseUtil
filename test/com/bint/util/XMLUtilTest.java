package com.bint.util;

import org.junit.Test;

public class XMLUtilTest {
	private XMLUtil xmlUtil ;
	@Test
	public void xml(){
		xmlUtil = new XMLUtil();
		System.out.println("name :" + xmlUtil.dbName);
	}
	
}
