package com.thinking.demo.chapter9;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/10/25 16:05
 * @since 1.0
 **/

abstract class C11{
    int j = 2;
    public abstract void print();

    public C11() {
        print();
    }
}
public class E1 extends C11{
    private int i = 1;

    @Override
    public void print() {
        System.out.println(i);
    }

    public E1() {
        super();
    }
}

class Ex{
    public static void main(String[] args){
        E1 e1 = new E1();
        e1.print();
    }
}

abstract class C12{
    static void func(C12 cc){
        System.out.println(cc.toString());
    }
}
class C13 extends C12{
    void print(){
        System.out.println("C13.print");
    }
    public static void main(String[] args){
        C13 c13 = new C13();
        C12.func(c13);
    }
}