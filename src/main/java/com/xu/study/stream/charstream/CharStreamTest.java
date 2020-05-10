package com.xu.study.stream.charstream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

public class CharStreamTest {
    @Test
    public void test01() throws IOException {
        InputStreamReader isr = new FileReader("F://b.txt");
        char[] buff = new char[1024];
        int len;
        int i = 0;
        //循环，每次读取1024字符
        while ((len = isr.read(buff)) != -1){
            i++;
            System.out.println(new String(buff, 0, len));
            System.out.println("i-------------------->>>>>"+i);
        }
    }
    @Test
    public void test02() throws IOException {
        InputStreamReader isr = new FileReader("F://b.txt");
        BufferedReader bf = new BufferedReader(isr);
        char[] buff = new char[1024];
        int len;
        int i = 0;
        //循环，每次读取1024字符
        while ((len = bf.read(buff)) != -1){
            i++;
            System.out.println(new String(buff, 0, len));
            System.out.println("i-------------------->>>>>"+i);
        }
        isr.close();
        bf.close();
    }

    @Test
    public void test03() throws IOException {
        OutputStream os = new FileOutputStream("F://c.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write("你好呀");
        osw.flush();
        osw.close();
    }

    @Test
    public void test04() throws IOException {
        FileWriter fw = new FileWriter("F://d.txt");
        fw.write("test04()");
        fw.close();
    }

    @Test
    public void test05() throws IOException {
        FileWriter fw = new FileWriter("F://e.txt");
        BufferedWriter osw = new BufferedWriter(fw);
        osw.write("test05");
        osw.close();
    }

    //指定字符集写入文件
    @Test
    public void test06() throws IOException {
        //指定字符集为iso-8859-1
        OutputStream os = new FileOutputStream("F://g.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF8");
        osw.write("你好呀");
        osw.flush();
        osw.close();

        //读取文件内容
        InputStream is = new FileInputStream("F://g.txt");
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF8"));
        char[] buff = new char[1024];
        int len;
        while ((len=isr.read(buff))!=-1){
            System.out.println(new String(buff,0,len));
        }

    }
}
