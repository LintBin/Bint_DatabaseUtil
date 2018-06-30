package com.bint.generation.spell;

import com.bint.data.Column;
import com.bint.data.Table;
import com.bint.reader.CustomizedWordReader;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by bint on 2017/8/26.
 */
public class MapperXmlSpell extends BaseSpell{

    private Table table;

    public MapperXmlSpell(Table table){
        this.table = table;
    }

    public String getXmlName(){

        String tableName = table.getName();

        StringBuffer xmlNameBuffer = new StringBuffer();


        if(super.existUnderline(tableName)){
            String[] strings ;
            strings = StringUtils.split(tableName, "_" );
            for(int i = 0 ; i<strings.length ; i++){

                String string = strings[i];

                //如果全是大写的字母
                if(super.checkAllUpperCase(string)){
                    List<String> lineList = CustomizedWordReader.LINE_LIST;

                    if(lineList == null){
                        break;
                    }

                    String part = null;
                    if(this.checkInList(string,lineList)){
                        part = string;
                    }else{
                        part = BaseSpell.initialsCapitals(string);
                    }

                    xmlNameBuffer.append(part);
                    continue;
                }

                //检查是否存在大写
                if(super.checkExistUpperCase(string)){
                    xmlNameBuffer.append(string);

                    continue;
                }

                xmlNameBuffer.append(super.initialsCapitals(string));
            }
        }

        String xmlName = xmlNameBuffer.toString() + "Mapper.xml";

        return xmlName;
    }

    public String getProperty(String columnName){

        String result = super.getInitialsCapitals(columnName);

        if(this.checkInList(result,CustomizedWordReader.LINE_LIST)){
            return result;
        }

        result = StringUtils.uncapitalise(result);

        return result ;
    }


    public String getImport(){
        String importString = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" > " + NEW_LINE;

        return importString;
    }

    public String getMapper(){
        String mapperString = "<mapper namespace=\" "  + this.getXmlName() + "\">" + NEW_LINE;
        return mapperString;
    }

    public String getMapperEnd(){
        String end =   "</mapper>" + NEW_LINE;
        return end;
    }

    public String getResultMap(){
        String resultMapString = ONE_TAB + "<resultMap id=\"baseResultMap\" type=\" #{modelName} \">" + NEW_LINE;

        return resultMapString;
    }

    public String getResultMapEnd(){
        String resultMapString = ONE_TAB + "</resultMap>" + NEW_LINE;

        return resultMapString;
    }

    public String getResult(){
        String resultString = ONE_TAB + ONE_TAB + "<result column=\"#{column}\" property=\"#{property}\" jdbcType=\"#{type}\" />" + NEW_LINE ;
        return resultString;
    }


    public String getSql(){
        String sqlTag = ONE_TAB + "<sql id=\"Base_Column_List\" >" + NEW_LINE + ONE_TAB + ONE_TAB +"#{sql}" + NEW_LINE + ONE_TAB + "</sql>" + NEW_LINE;

        List<Column> columnList = table.getList();

        StringBuffer sqlBuffer = new StringBuffer();

        for(int i=0;i<columnList.size();i++){
            Column column = columnList.get(i);
            sqlBuffer.append(column.getName());

            if(i != columnList.size() -1){
                sqlBuffer.append(", ");
            }
        }

        String sql = sqlBuffer.toString();
        sqlTag = sqlTag.replace("#{sql}", sql);

        return sqlTag;
    }

    public String getUpdateTag(){
        String sql = ONE_TAB + "<update id=\"update\" >" + NEW_LINE + ONE_TAB + ONE_TAB + "update #{table} set" + ONE_TAB + ONE_TAB + ONE_TAB + "#{field} </update>" ;
        return sql;
    }


}