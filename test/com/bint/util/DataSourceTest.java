package com.bint.util;

import org.junit.Test;

import com.bint.data.DataSource;

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
