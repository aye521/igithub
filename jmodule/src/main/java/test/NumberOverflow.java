package test;

public class NumberOverflow {

	public static void main(String[] args) {
		int i3 = 1000000;
	    System.out.println (Long.toHexString (i3*i3).toUpperCase());
	    System.out.println (Integer.toHexString (i3*i3).toUpperCase());
	    //������˽�������������ֵ�ͻᷢ�����������ֱ�ӽ�ȡ��32λ����ֵ
	    System.out.println (i3*i3);
	    //���������ǿ��ת��Ϊ�������͵����ݣ���������ĳһ������������
	    System.out.println ((long)i3*i3);
	    System.out.println (i3*1000000l);
	}
}