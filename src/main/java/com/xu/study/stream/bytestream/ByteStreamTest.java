package com.xu.study.stream.bytestream;


import org.junit.jupiter.api.Test;

import java.io.*;

public class ByteStreamTest {


    @Test
    public void test01() throws IOException {
        InputStream is = new FileInputStream("F://a.txt");
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = is.read(buff))!= -1){
            System.out.println(new String(buff,0,len));
        }
        is.close();
    }
    //BufferedInputStream是一种封装别的流以提高效率的流，所以它的初始化需要一个的InputStream流对象。
    @Test
    public void test02() throws IOException {
        InputStream is = new FileInputStream("F://a.txt");
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buff = new byte[1024];
        int len = 0;
        while((len = bis.read(buff)) != -1){
            System.out.println(new String(buff,0,len));
        }
        is.close();
        bis.close();
    }

    @Test
    public void test03() throws IOException {

        OutputStream os = new FileOutputStream("F://b.txt");
        os.write("hello outputStream !!".getBytes());
        os.close();
    }
}
