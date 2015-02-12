package com.bint.data;

public class Column {
	private String name;
	private String type;
	private boolean isForeignKey;
	private String tableName;

	public Column(String tableName) {
		this.tableName = tableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isForeignKey() {
		return isForeignKey;
	}

	public void setForeignKey(boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", type=" + type + ", isForeignKey="
				+ isForeignKey + ", tableName=" + tableName + "]";
	}

}
