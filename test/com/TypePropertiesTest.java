package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

public class TypePropertiesTest {
	@Test
	public void test() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/type.properties"));
			Enumeration es = prop.keys();
			while(es.hasMoreElements()){
				System.err.println((String)es.nextElement());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
