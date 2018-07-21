package com.lambda.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaDemos {
    Logger logger = LoggerFactory.getLogger(LambdaDemos.class);
    List<String> list;
    List<Integer> listNum;
    @Before
    public void initField(){
        list = Arrays.asList("Java","Python","Javascript");
        listNum = Arrays.asList(300,80,999,100,360);
    }

    @Test
    public void lambdaUsage(){
        // anonymous runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                logger.info("Runnable with anonymous inner class!");
            }
        };

        Runnable r2 = () -> logger.info("Runnalbe with lambda expression");

        r1.run();
        r2.run();
    }
    @Test
    public void newForEach(){
//        logger.info(">>>lamda for each<<<");
//        list.forEach(str -> logger.info(str));
        logger.info("***method references with natural order ***");
        list.forEach(logger::info);
        logger.info("###to upper case with default sorted###");
        list.stream().sorted().forEach(str -> {String s = str.toUpperCase();logger.info(s);});
        logger.info("### custom order with str's length");
        list.stream().sorted((a,b) -> a.length() - b.length()).forEach(logger::info);
        logger.info("filter");
        List<String> collect = list.stream().filter(s -> s.length() < 8).collect(Collectors.toList());
        boolean j = collect.stream().anyMatch(s -> s.startsWith("J"));
        logger.info("collect element start with J ? {}",j);
        Long collectCounting = collect.stream().collect(Collectors.counting());
        logger.info(collectCounting.toString());
        IntSummaryStatistics stics = listNum.stream().mapToInt(i -> i * 10).summaryStatistics();
        logger.info("list int statictics, sum:{},average:{},max:{},min:{},count:{}",stics.getSum(),stics.getAverage(),stics.getMax(),stics.getMin(),stics.getCount());
    }

    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
    @Test
    public void funcInterface(){
        Function<String,String> fn = str -> str + " -> with function interface";
        logger.info(add("hello", fn));
        Function<Integer,Integer> add1 = i -> i + 1;
        Function<Integer,Integer> add2 = add1.andThen((i2) -> i2 * 2);
        logger.info(add2.apply(3).toString());
    }
    @Test
    public void filterTest() {
        Predicate<String> predicate_1 = s -> s.startsWith("J");
        Predicate<String> predicate_2 = s -> s.endsWith("a");
        Predicate<String> predicate_3 = s -> s.endsWith("n");
        list.stream().filter(predicate_1).filter(predicate_2).forEachOrdered(logger::info);
        list.stream().filter(predicate_1.and(predicate_2)).forEachOrdered(logger::info);
        list.stream().filter(predicate_1.or(predicate_3)).forEachOrdered(logger::info);
    }
    @Test
    public void mapReduce(){
        Function<Integer,Double> compute = i -> i + i * 0.12;
        listNum.stream().map(compute).forEachOrdered(d -> logger.info(d.toString()));
        Optional<Double> reduce = listNum.stream().map(compute).reduce((sum, next) -> sum + next);
        logger.info("total bill : {}", reduce.get());
    }

}
//--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED
