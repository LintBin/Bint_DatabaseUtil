package com.bint.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bint on 2017/8/27.
 */
public class CustomizedWordReader {

    private static final String ENCODING = "UTF-8";

    private static File file;
    public static List<String> LINE_LIST = new ArrayList<>();


    static {
        file = new File("src/customized-word");
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file), ENCODING);

            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据

                if(line != null){
                    LINE_LIST.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //FIXME 需要修复资源没有及时关闭的问题
    /*public CustomizedWordReader() throws IOException {

        file = new File("src/customized-word");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), ENCODING);

        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据

            if(line != null){
                lineList.add(line);
            }
        }
    }*/



    public static void main(String[] args) {

        //CustomizedWordReader c = new CustomizedWordReader();

    }
}
