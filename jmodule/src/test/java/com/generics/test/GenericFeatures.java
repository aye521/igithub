package com.generics.test;

import com.base.Foo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GenericFeatures {
    private  Logger logger = LoggerFactory.getLogger(GenericFeatures.class);
    private  Consumer consumer = s -> logger.info("value: {}, type: ",s,s.getClass());

    @Test
    public  void demo1(){
        List<?> lst = new ArrayList();
        lst.add(null);
        lst.forEach(consumer);
        Foo<?> f1 = new Foo(1).get(""); //ok - can pass String where Object is expected
//        new Foo<>(1).get(""); //fail - cannot pass String where Integer is expected
    }

}
