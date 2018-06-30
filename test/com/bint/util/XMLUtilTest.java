package com.bint.util;

import org.junit.Test;

public class XMLUtilTest {
	private DbConfigXMLUtil dbConfigXmlUtil;
	@Test
	public void xml(){
		dbConfigXmlUtil = new DbConfigXMLUtil();
		System.out.println("name :" + dbConfigXmlUtil.dbName);
	}
	
}
