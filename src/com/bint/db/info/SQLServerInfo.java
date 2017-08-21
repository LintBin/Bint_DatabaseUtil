package com.bint.db.info;


import com.bint.util.XMLUtil;

public class SQLServerInfo implements IDataBaseInfo{

	private XMLUtil xmlUtil;
	
	
	public static final String SQL_SERVER_TABLE_QUERY_SQL = "select name from sysobjects where xtype='U'";
	public static final String SQL_SERVER_COLUMN_QUERY_SQL = "select name ,xtype from syscolumns where id = object_id(?) ;";
	public static String SQL_SERVER_URL_PAR = "jdbc:sqlserver://#{host}:#{port};databaseName=";
	public static final String SQL_SERVER_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	@Override
	public String getUrl() {

		SQL_SERVER_URL_PAR = SQL_SERVER_URL_PAR.replace("#{host}",xmlUtil.dbHost);
		SQL_SERVER_URL_PAR = SQL_SERVER_URL_PAR.replace("#{port}", xmlUtil.port);

		return SQL_SERVER_URL_PAR;
	}

	@Override
	public String getDriverName() {
		return SQL_SERVER_DRIVER_NAME;
	}

	@Override
	public String getTablesQuerySql() {
		return SQL_SERVER_TABLE_QUERY_SQL;
	}

	@Override
	public String getColumnquerySql() {
		return SQL_SERVER_COLUMN_QUERY_SQL;
	}
	
	
	
	
	
	
	
	//sql server里面对应的类型 枚举类型
	public enum SQLServerColumnType {

		IMAGE("image",34),
		TEXT("text",35),
		TINY_INT("tinyint",48),
		SMALL_INT("smallint",52),
		INT("int",56),
		SMALL_DATE_TIME("smalldatetime",58),
		REAK("real",59),
		MONEY("money",60),
		DATE_TIME("datetime",61),
		FLOAT("float",62),
		N_TEXT("ntext",99),
		BIT("bit",104),
		DECIMAL("decimal",106),
		NUMERIC("numeric",108),
		SMALL_MONEY("smallmoney",122 ),
		BIG_INT("bigint",127),
		VAR_BINARY("varbinary",165),
		VAR_CHAR("varchar",167 ),
		BINARY("binary",173),
		CHAR("char",175),
		TIMESAMP("timestamp",189),
		N_VAR_CHAR("nvarchar",231),
		SYS_NAME("sysname",231),
		N_CHAR("nchar",239),
		XML("xml",241);
		
		
		// 构造方法
        SQLServerColumnType(String type, int index) {
            this.type = type;
            this.index = index;
        }
        
        private String type;
        private int index;
        
        public String getType(){
        	return this.type;
        }
        
        public int getIndex(){
        	return this.index;
        }
        
        /**
        * 根据索引,获得对应类型
        * @param index
        * @return
        */
       public static String getName(int index){  
           for (SQLServerColumnType e : SQLServerColumnType.values()) {  
               if (e.getIndex() == index) {  
                   return e.type;  
               }  
           }  
           return null;  
       }
        
	}
	
	
}
