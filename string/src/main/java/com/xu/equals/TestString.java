package com.xu.equals;



public class TestString {


    public static void main(String[] args) {
        String str0 = "ABC";
        String str1 = "ABC";
        System.out.println(str0 == str1);   //true
        System.out.println(str0.equals(str1));//true
        //说明：String str1 = "ABC"; 可能创建一个对象或者不创建对象。
        //如果"ABC" 这个字符串在java String池中不存在，会在java String池中创建一个String str1= "ABC"的对象。
        //然后把str1指向这个内存地址。之后用这种方式创建多少个值为"ABC"的字符串对象。始终只有一个内存地址被分配，之后都是String的copy。
        //这种被称为‘字符串驻留’，所有的字符串都会在编译之后自动驻留。

        String str2 = new String("ABC");
        String str3 = new String("ABC");
        System.out.println(str2.equals(str3)); // true 比较的值
        System.out.println(str2 == str3); // false 比较的是内存地址。
        //说明：
        //String str2 = new String("ABC"); 至少会创建一个对象，也可能2个。
        //因为用到了new的关键字，肯定会在heap中创建一个str2的对象。它的value值是"ABC"，同时如果这个字符串在string池中不存在，会在string池中创建这个string对象"ABC"。

        String str4 = "ABC";
        String str5 = "ABC";
        String str6 = "AB"+"C";
        System.out.println(str4 == str5); //true 在string池中都是一个内存地址被分配给str3,str4,str5
        System.out.println(str5 == str6); //true

        String str7 = "AB";
        String str8 = str7 + "C";
        System.out.println(str4 == str8); //false
        //说明：
        //str7在编译的时候已经确认为string池的对象。
        //str8在编译的时候不能确认，故str8是一个引用变量。
        //str7+"C"的过程是创建了一个StringBuffer对象，然后用StringBuffer对象执行append方法追加，最后再转成String类型，也就是str7是放在heap里面的对象，str6是放在String常量池里的。
        //两个的内存地址不一样。故结果为false。


        String a = "123";//在String池中新建一个String a = "123"的对象。
        a = "456";//在String池中新生成一个实例对象，值为456，原来的123仍然存在，等待回收
        System.out.println(a);

        //StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，
        // 通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。
        // 一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
        StringBuffer sb = new StringBuffer("abc");
        sb.append("def");
        System.out.println(sb);

        StringBuilder stringBuilder = new StringBuilder("ABC");
        stringBuilder.append("DEF");
        System.out.println(stringBuilder);
        //StringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。
        //不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。

    }

}
