package com.bint.data;

import java.util.List;

public class Table {
	private List<Column> list = null;
	private String name;
	public List<Column> getList() {
		return list;
	}

	public void setList(List<Column> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer sf = new StringBuffer();
		for(Column column : list){
			sf = sf.append(column.toString()+ "\n");
		}
		return sf.toString();
	}
	
}
