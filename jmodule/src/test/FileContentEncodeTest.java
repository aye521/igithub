package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileContentEncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException,
			IOException {
		String fileName = "c:\\code.txt";
		FileInputStream in = new FileInputStream(fileName);
		
		readUnicode(in);

	}

	/**
	 * windows 记事本的unicode对应little endian（低byte地址存储高位，高byte地址存储地位，多字节的时候，big endian相反�?
	 * @param in
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void readUnicode(FileInputStream in) throws IOException {
		byte[] data = new byte[2];
		// byte[] text = new byte[1024];
		while (in.read(data) != -1) {
			int hex = ((data[0] << 8) | (data[1] & 0xFF)) & 0XFFFF;
			System.out.printf("%h ", hex);
			System.out.println(new String(data,"UTF-16LE"));
		}
		in.close();
	}

	/**
	 * utf-8是unicode的实现之�?��不过采用变长的存储方式，比如字母用一个byte，一个中文字符用3个byte等，�?��读取的时候必须判断字符的存储方式
	 * @param in
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	static void readUTF8File(FileInputStream in) throws UnsupportedEncodingException, IOException {
		byte[] first = new byte[1];
		byte[] remain = new byte[3];
		while (in.read(first) != -1) {
			if (first[0] >= 0) { // ASCII 字元
				System.out.print(new String(first, "UTF-8"));
				System.out.printf("  %h%n", first[0] & 0x00FF);
			} else if (first[0] >= -16) { // 四�?位元組字�?
				in.read(remain, 0, 3);
				System.out.print(new String(new byte[] { first[0], remain[0],
						remain[1], remain[2] }, "UTF-8"));
				System.out.printf(" %h %h %h %h%n", first[0] & 0x00FF,
						remain[0] & 0x00FF, remain[1] & 0x00FF,
						remain[2] & 0x00FF);
			} else if (first[0] >= -32) { // 三�?位元組字�?
				in.read(remain, 0, 2);
				System.out.print(new String(new byte[] { first[0], remain[0],
						remain[1] }, "UTF-8"));
				System.out.printf(" %h %h %h%n", first[0] & 0x00FF,
						remain[0] & 0x00FF, remain[1] & 0x00FF);
			} else if (first[0] >= -64) { // 兩�?位元組字�?
				in.read(remain, 0, 1);
				System.out.print(new String(new byte[] { first[0], remain[0] },
						"UTF-8"));
				System.out.printf(" %h %h%n", first[0] & 0x00FF,
						remain[0] & 0x00FF);
			}
		}
		in.close();
	}
}
