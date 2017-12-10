package com.bint.generation.spell;

import com.bint.reader.CustomizedWordReader;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by bint on 2017/8/26.
 */
public class BaseSpell {
    static final String NEW_LINE = "\n";
    static final String ONE_TAB = "    ";
    static final String SPACE = " ";
    static final String TWO_TAB = ONE_TAB + ONE_TAB;


    /*protected static String getAapitalizeFomat(String string){
        return StringUtils.capitalize(propertyFomat(string));
    }*/



    /*protected static String propertyFomat(String property){


    }*/



    /**
     * 首字母大写
     * @param string
     * @return
     */
    /*protected String initialsCapitals(String string){
        //如果不存在"_"的字符，则证明该数据库中不是以"_"来命名,而是以驼峰写法来命名，则不需要处理
        if(existUnderline(string)){
            return string;
        }

        string = StringUtils.lowerCase(string);
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings ;
        strings = StringUtils.split(string, "_" );
        for(int i = 0 ; i<strings.length ; i++){
            stringBuffer.append(StringUtils.capitalize(strings[i])) ;
        }
        return stringBuffer.toString();
    }*/


    /**
     * 首字母大写,其他小写
     * @param string
     * @return
     */
    protected static String initialsCapitals(String string){

        String lowerCase = StringUtils.lowerCase(string);
        String result = StringUtils.capitalize(lowerCase);
        return result;

    }



    protected static Boolean checkAllUpperCase(String string){
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            if(c >= 97 && c <= 122) {
                return false;
            }
        }
        return true;
    }


    /**
     * 检查是否存在大写
     * @return
     */
    protected static Boolean checkExistUpperCase(String string){
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            if(c >= 65 && c <= 90) {
                return true;
            }
        }
        return false;
    }

    protected Boolean existUnderline(String string){
        Integer index = string.indexOf("_");

        if(index != -1){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        //String str = initialsCapitals("converSionfactors");
        String str = StringUtils.capitalize("converSionfactors");

        System.out.println(str);
    }

    /**
     * 把下划线处理，并转成驼峰写法
     * @param source
     * @return
     */
    protected String getInitialsCapitals(String source){
        StringBuffer result = new StringBuffer();
        String[] strings ;
        strings = StringUtils.split(source, "_" );
        for(int i = 0 ; i<strings.length ; i++){

            String string = strings[i];

            //如果全是大写的字母
            if(this.checkAllUpperCase(string)){
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

                result.append(part);
                continue;
            }

            //检查是否存在大写
            if(this.checkExistUpperCase(string)){
                result.append(string);

                continue;
            }

            if( i == 0 ){
                result.append(string);
            }else{
                string = string.substring(0, 1).toUpperCase() + string.substring(1);
                result.append(string);
            }


        }

        return result.toString();
    }


    protected Boolean checkInList(String string ,List<String> stringList){

        for(String line : stringList){

            if(line.equals(string)){
                return true;
            }
        }

        return false;
    }
}
