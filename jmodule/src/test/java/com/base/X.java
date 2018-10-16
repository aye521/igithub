package com.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class X<T> {
    public X(T t) { }
    public T get() { return null; }

    public static int f(String s) {
        System.out.println(s);
        return 1;
    }
    public static int f(Object o) {
        System.out.println(o);
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(f(new X<>("").get()));
        System.out.println(f(new X("").get()));
//        List<String> lst1 = new ArrayList<String>(Arrays.asList(1,2));
        List<String> lst2 = new ArrayList(Arrays.asList(1,2));
        lst2.forEach(s -> System.out.println(s));

        List<? super Integer> li;
        List<? super Integer> ln = new ArrayList<>();
        li = ln;

    }
}
