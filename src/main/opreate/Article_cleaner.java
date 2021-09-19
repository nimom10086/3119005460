package main.opreate;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class Article_cleaner {


    public List<String> divisionArticle(File file) throws IOException {
        FileReader fileReader = new FileReader(file);//将文件读成字符流
        BufferedReader bufferedReader = new BufferedReader(fileReader);//将字符流读成字节流
        String temp;
        StringBuilder stringBuilder = new StringBuilder();
        while ((temp = bufferedReader.readLine()) != null) {//按行读取
            stringBuilder.append(temp);
        }
        String[] s = stringBuilder.toString()//清洗文章标点符号，按照句号分句
                .replace(" ", "")
                .replace("“", "")
                .replace("”", "")
                .replace("：", "，")
                .replace("？", "。")
                .split("。");

        return Arrays.asList(s);
    }
}

