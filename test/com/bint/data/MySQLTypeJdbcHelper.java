package com.bint.data;

/**
 * Created by bint on 2017/12/10.
 */
public class MySQLTypeJdbcHelper {

    public static void main(String[] args) {
        String str = JdbcTypeHelper.getJdbcType("mysql.int");

        System.out.println(str);
    }

}
