package com.demos;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class StringPatternMatch {
    private Logger logger = LoggerFactory.getLogger("stringPatternMatch");
    private Consumer consumer = s -> logger.info("value: {}, type: {}", s, s.getClass());

    @Test
    public void violentMatch() {
        String s = "abcdef";
        String p = "ef";
        int sLen = s.length(), plen = p.length();
        int i = 0, j = 0;
        char c1 , c2 ;
        int count = 0;
        while (i < sLen && j < plen) {
            count ++;
            c1 = s.charAt(i);
            c2 = p.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                j = 0;
                i = i - j + 1;
            }
        }
        logger.info("got ? : {}, count: {}", s.substring(i - j, i -j + plen), count);
    }

    @Test
    public void test() {
        String s = "abacde";
        final char c = s.charAt(0);
        final char c2 = s.charAt(4);
        logger.info("char-1: {}, char-2: {}, equal ? : {}", c, c2, c == c2);

    }

}
