package com.thinking.demo.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * E29
 *
 * @author Alphonse
 * @date 2019/11/19 15:27
 * @since 1.0
 **/
interface Fruit {}
class Apple implements Fruit {}
class Orange implements Fruit {}
public class T4<T> {
    void type(List<? super T> list, T arg) {
        //T a = list.get(0);
        Object b = list.get(1);
        list.add(arg);
    }
    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<>();
        List<? extends Fruit> list1 = Arrays.asList(new Apple(), new Orange());
        List<? super Apple> list2 = new ArrayList<>();
        list2.add(new Apple());
        list.add(null);
        list.contains(new Apple());
        //list.add(new Apple());  // illegal
        //list.add(new Object()); // illegal
        Number[] numList = new Integer[10];
        numList[0] = 5;
        numList[1] = 2;

        Holder<Integer> intHolder = new Holder<>(4);
        int num = intHolder.get();
        intHolder.set(3);

    }
    // **** **********************************
    void ff(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //T t = holder.get(); // **** ??
        Object object = holder.get();
    }
    void gg(Holder<? extends T> holder, T arg) {
        //holder.set(arg);
        T t = holder.get();
    }
    // **** ***********************************
    /**
     * 写数据用 <? super T> 存储数据，因为元素T是可以向上转型为T的或者T的父类的（最终转型为Object）。
     * 读数据用 <? extends T> 读数据是类型为? extends T的元素保证是可以向上转换为T的。
     */
}

/**
 * 泛型重载了extends关键字，有一个类A，两个接口B和C，使用泛型时，类一定要放在首位，即：<T extends A&B&C>
 */

class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
}

class E29 {
    void f(Holder<List<?>> holder) {
        List list = holder.get();
        System.out.println(list);
        list.add(new Apple());
        list.add(new Holder<String>());
        list.get(0);
        System.out.println(list);
        holder.set(new ArrayList<Integer>(5));
        holder.get().add(null);
    }
    <T> void g(List<Holder<T>> list) {
        Holder holder = list.get(0);
        Object obj = holder.get();
        holder.set("ssss");
        holder.set(new Apple());
        Apple apple = (Apple) holder.get();
        //list.add(new Holder<String>("sd"));
        System.out.println(list);
    }

    /**
     * 如果把？改为T，在list里面新增元素会报错，如果只是修改list原有元素的值则正常执行。
     * Error:(81, 13) java: 对于add(com.thinking.demo.chapter15.Holder<java.lang.String>), 找不到合适的方法
     *     方法 java.util.Collection.add(com.thinking.demo.chapter15.Holder<T>)不适用
     *       (参数不匹配; 无法推断com.thinking.demo.chapter15.Holder<>的类型参数
     *           原因: 推论变量T具有不兼容的限制范围
     *             等式约束条件: T
     *             下限: java.lang.String)
     *     方法 java.util.List.add(com.thinking.demo.chapter15.Holder<T>)不适用
     *       (参数不匹配; 无法推断com.thinking.demo.chapter15.Holder<>的类型参数
     *           原因: 推论变量T具有不兼容的限制范围
     *             等式约束条件: T
     *             下限: java.lang.String)
     *
     */
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder) {
        f1(holder);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw); //会有warning
        f2(raw);
        E29 e29 = new E29();
        List list = new ArrayList();
        list.add("String.class");
        list.add(new Apple());
        e29.f(new Holder<>(list));
        list.removeAll(list);
        list.add(new Holder<>("ss"));
        list.add(new Holder<>(new Apple()));
        e29.g(list);
    }
}
interface Payable<T> {}
class Employee implements Payable {}
class Hourly extends Employee implements Payable{}
