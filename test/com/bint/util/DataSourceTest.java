package com.bint.util;

import org.junit.Test;

public class DataSourceTest {
	private DataSource dataSource;
	@Test
	public void getDataSource(){
		try{
			dataSource = new DataSource();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
