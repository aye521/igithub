package com.base;

import java.util.List;

public class Box<T> {

    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return this.t;
    }



    public <U extends Number> void inspectOfin(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    void foo(List<?> i) {
//        i.set(0, i.get(0));// with compile error
        // to avoid compile error,use a hepler method
        foo(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }


}
