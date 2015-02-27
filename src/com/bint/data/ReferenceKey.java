package com.bint.data;

public class ReferenceKey extends Column {
	// 在数据库中的表名，未经过驼峰写法处理
	private String referenceTable;
	private String column;

	public ReferenceKey(String tableName) {
		super(tableName);
	}
	
	
}
