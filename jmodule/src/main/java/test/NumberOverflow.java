package test;

public class NumberOverflow {

	public static void main(String[] args) {
		int i3 = 1000000;
	    System.out.println (Long.toHexString (i3*i3).toUpperCase());
	    System.out.println (Integer.toHexString (i3*i3).toUpperCase());
	    //整型相乘结果超出最大整型值就会发生数据溢出，直接截取低32位的数值
	    System.out.println (i3*i3);
	    //解决方案：强制转换为更大类型的数据，或者提升某一操作数的类型
	    System.out.println ((long)i3*i3);
	    System.out.println (i3*1000000l);
	}
}
