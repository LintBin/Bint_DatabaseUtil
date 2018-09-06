package com.bint.util;

import com.bint.reader.CustomizedWordReader;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by bint on 2018/9/5.
 */
public class HumpNameUtil {


    public static String getHumpName(String name){

        StringBuffer xmlNameBuffer = new StringBuffer();
        //如果存在下划线
        if(existUnderline(name)){
            String[] strings ;
            strings = StringUtils.split(name, "_" );
            for(int i = 0 ; i<strings.length ; i++){

                String string = strings[i];

                //如果全是大写的字母
                if(checkAllUpperCase(string)){
                    List<String> lineList = CustomizedWordReader.LINE_LIST;

                    if(lineList == null){
                        break;
                    }

                    String part = null;
                    if(checkInList(string,lineList)){
                        part = string;
                    }else{
                        part = initialsCapitals(string);
                    }

                    xmlNameBuffer.append(part);
                    continue;
                }

                //检查是否存在大写
                if(checkExistUpperCase(string)){
                    xmlNameBuffer.append(string);
                    continue;
                }
                xmlNameBuffer.append(initialsCapitals(string));
            }
        }else {

            String first = name.substring(0, 1);

            String s = StringUtils.lowerCase(first);

            String s1 = s + name.substring(1, name.length());

            xmlNameBuffer.append(s1);

        }

        return xmlNameBuffer.toString();
    }

    public static String getPropertyHumpName(String name){

        String humpName = getHumpName(name);

        String second = humpName.substring(1, 2);

        Boolean checkExistUpperCase = checkExistUpperCase(second);

        if(!checkExistUpperCase){
            String first = name.substring(0, 1);
            String lowerCase = StringUtils.lowerCase(first);

            return lowerCase + humpName.substring(1, humpName.length());
        }

        return humpName;
    }


    /**
     * 首字母大写,其他小写
     * @param string
     * @return
     */
    private static String initialsCapitals(String string){

        String lowerCase = StringUtils.lowerCase(string);
        String result = StringUtils.capitalize(lowerCase);
        return result;

    }


    private static Boolean checkAllUpperCase(String string){
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            if(c >= 97 && c <= 122) {
                return false;
            }
        }
        return true;
    }


    private static Boolean existUnderline(String string){
        Integer index = string.indexOf("_");

        if(index != -1){
            return true;
        }

        return false;
    }

    private static Boolean checkInList(String string ,List<String> stringList){

        for(String line : stringList){

            if(line.equals(string)){
                return true;
            }
        }
        return false;
    }


    private static Boolean checkExistUpperCase(String string){
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            if(c >= 65 && c <= 90) {
                return true;
            }
        }
        return false;
    }
}
