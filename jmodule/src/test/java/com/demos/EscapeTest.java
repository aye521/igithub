package com.demos;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class EscapeTest {
    private final Logger logger = LoggerFactory.getLogger("EscapeTest");

    @Test
    public void quizOne(){
        logger.info("processors : {}", Runtime.getRuntime().availableProcessors());
        int n = 16;
        toBinary(n);
        n |= n >>> 1;
        toBinary(n);
    }

    void toBinary(int i){
        String binary = String.format("%016d", new BigInteger(Integer.toBinaryString(i)));
        logger.info("Binary format : {} , Decimal: {}",binary, i);
    }

    @Test
    public void arrayStoreException(){
        Object[] o = "one two three".split(" ");
        o[0] = 3;
    }
}
