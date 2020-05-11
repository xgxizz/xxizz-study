package com.xu;

public class SubClass extends SuperClass {
    public int a = 2;
    public SubClass(){
        System.out.println("a = " + a);
    }
    public int getA(){
        return a;
    }

    public static void main(String[] args) {
        SuperClass aclass = new SuperClass();
        SuperClass bclass = new SubClass();
        System.out.println("aclass.a is " + aclass.a);//aclass.a is 1
        System.out.println("bclass.a is " + bclass.a);//bclass.a is 1
        System.out.println("aclass.getA() is " + aclass.getA());//aclass.getA() is 1
        System.out.println("bclass.getA() is " + bclass.getA());//bclass.getA() is 2
        System.out.println("num1 is "+ (aclass.a + bclass.a));//num1 is 2
        System.out.println("num2 is "+ (aclass.getA() + bclass.getA()));//num2 is 3
        System.out.println("num3 is "+ (aclass.a + bclass.getA()));//num3 is 3
        System.out.println("num4 is "+ (aclass.getA() + bclass.a));//num4 is 2
    }
}
