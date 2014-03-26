package test;

import java.nio.charset.Charset;

public class UTF16Test {  
    public static void main(String[] args) {  
          String sample = null;  
          if(args.length > 0) {  
              sample = args[0];  
          } else {  
        	  System.out.println("default charset : " + Charset.defaultCharset().name());
              // for the sake of not show the character of u+1D56B  
        	  char[] chars = Character.toChars(0x1D56B);
        	  //char 'A'
        	  System.out.println(new String(Character.toChars(0x0041)) + " : char(code unit) : " +  Character.toChars(0x0041).length);
        	  //char 'һ'
        	  System.out.println(new String(Character.toChars(0x4E00)) + " : char(code unit) : " + Character.toChars(0x4E00).length);
        	  System.out.println("supplementary chrar[] length : " + chars.length);
              String special = new String(Character.toChars(0x1D56B));  
              sample = special+" zZ";  
          }  
          System.out.println("sample string is:  "+sample);  
            
          // String.length : Returns the length of this string.  
          // The length is equal to the number of Unicode code units in the string.  
          int len = sample.length();  
          System.out.println("code units count:  "+len);  
          // traverse the string by code units  
          System.out.print("code units are:  ");  
          UTF16Test.traverseByCodeUnits(sample);  
          System.out.println();  
            
            
          // get the number of Unicode code points  
          int cpCount = sample.codePointCount(0, len);  
          System.out.println("code points count:  "+cpCount);  
            
          // traverse the string by code point s  
          System.out.print("code points are:  ");  
          UTF16Test.traverseByCodePoints(sample);  
          System.out.println();  
           
    }  
    /** 
     * traverse the string by code points 
     * @param str the specified string to traverse 
     */  
    public static void traverseByCodePoints(String str) {  
        int cpCount = str.codePointCount(0, str.length());  
         for(int ix = 0;ix < cpCount;ix++) {  
             printCodePoint(str.codePointAt(ix));  
         }  
    }  
    /** 
     * traverse the string by code units 
     * @param str the specified string to traverse 
     */  
    public static void traverseByCodeUnits(String str) {  
        int cuCount = str.length();  
        for(int ix = 0;ix < cuCount;ix++) {  
            String content = String.format("(%04x)  ",  
                    (int)str.charAt(ix)).toUpperCase();  
            System.out.print(content);//get code unit  
        }  
          
    }  
    /** 
     * print code point in hexadecimal form 
     * @param cp the code point 
     */  
    private static void printCodePoint(int cp) {  
          
        //check if is the supplementary code point  
        if(Character.isSupplementaryCodePoint(cp)) {  
            char[] chs = Character.toChars(cp);//stored the code point in  UTF-16 representation  
            String content = String.format("[U+%04x,U+%04x]  ",  
                    (int)chs[0],(int)chs[1]).toUpperCase();  
            System.out.print(content);  
        } else {  
            String content = String.format("[U+%04x]  ",cp).toUpperCase();  
            System.out.print(content);  
        }  
    }  
} 