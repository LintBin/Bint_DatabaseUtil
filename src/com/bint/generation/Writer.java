package com.bint.generation;

import java.util.List;

import com.bint.data.Table;

public class Writer {
	List<Table> tables = null;
	public Writer(List<Table> tables){
		this.tables = tables;
	}
	public void creatJavaBean(){
		//TODO 利用tables生成javabean文件
		System.out.println("ColumnAmount : " + tables.size());
		for(Table table : tables){
			System.out.println("tableName : " + table.getName());
		}
	}
}
