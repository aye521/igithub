package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharByteBitTest {

	public static void main(String ... args) throws Exception {
		//负数的正数（位操作）：减1取反（补码）
//		toBits(~(-3-1));
//		//正数的负数（位操作）：取反加1（补码）
//		toBits(~3 + 1);
//		toBits(1 << 32);
//		
		echoBytesTest("cn=中 ");
		charEncode();
//		System.out.printf("%d",0xFE);
		System.out.println(Charset.defaultCharset());
		System.out.println(new String(Character.toChars(0x0D0A)));
	}


	private static void toBits(Integer i) {
		String binary = Integer.toBinaryString(i);
		String hex = Integer.toHexString(i);
		System.out.printf("Decimal: %11s, Binary : %32s(%2d), Hex: %8s \n",i,binary , binary.length(),hex);
	}
	
	
	@SuppressWarnings("unused")
	static void charEncode() throws UnsupportedEncodingException{
//		System.getProperties().list(System.out);
		//affects the creation of file name,Command line arguments,Environment variables
		String jnu = System.getProperty("sun.jnu.encoding");
		//affects the content of a file
		String fileEncoding = System.getProperty("file.encoding");
		String cpu_endian = System.getProperty("sun.cpu.endian");
		String unicode_encoding = System.getProperty("sun.io.unicode.encoding");
		System.out.println("unicode encoding : " + unicode_encoding);
		System.out.println("file encoding : " + fileEncoding);
		String cn = "中a";
		byte[] bytes = cn.getBytes();
		byte[] bytes2 = cn.getBytes("UTF-8");
		byte[] bytes3 = cn.getBytes("GBK");
		System.out.println(bytes.equals(bytes2));
		System.out.println(bytes.length + " bytes");
		toByteStr("UNICODE".getBytes());
		toByteStr(bytes);
		toByteStr(bytes2);
		toByteStr(bytes3);
		System.out.println("unicode");
		String s = "a";
	    byte[] arr = s.getBytes("UNICODE");
	    System.out.println(Arrays.toString(arr)); // 12
	}


	private static void toByteStr(byte[] bytes) {
		System.out.println();
		System.out.println(Arrays.toString(bytes));
	}
	
	static void echoBytesTest(String s) {
		echoBytes(s, "GBK");
		echoBytes(s, "Unicode");
		echoBytes(s, "UnicodeBig");
		echoBytes(s, "UnicodeLittle");
		echoBytes(s, "UnicodeBigUnmarked");
		echoBytes(s, "UnicodeLittleUnmarked");
		echoBytes(s, "UTF-16");
		echoBytes(s, "UTF-16BE");
		echoBytes(s, "UTF-16LE");
		echoBytes(s, "UTF-8");
	}
	 
	static void echoBytes(String s, String encoding) {
		byte[] bytes = null;
		try {
			bytes = s.getBytes(encoding);
			System.out.printf("%-21s(%d) : ",encoding,bytes.length);
		} catch (UnsupportedEncodingException e) {
			System.err.println("unsupportedEncoding : " + encoding);
			e.printStackTrace();
		}
		for (byte b : bytes) {
			int i = b & 0xff;
			System.out.print(Integer.toHexString(i) + " ");
		}
		System.out.println();
	}
}
