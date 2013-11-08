package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ͨ����������˽�б���(û���ṩpublic��setter����)����spring��˽�б���������ע�루û�й�����setter��
 * Ӧ��Ҳ��ͨ�����ֻ���
 * @author meaning
 *
 */

public class TestAccessPrivateField {
	
	static Modifier accessLevel;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class<?> class1 = Class.forName("reflections.ObjWithPrivateField");
        Object object = class1.newInstance();
        Field[] fields = class1.getDeclaredFields();
        Field field = fields[0];
        System.out.println("field name : " + field.getName() + ", modifier : " + Modifier.toString(field.getModifiers()));
        //����˽�б����Ŀɷ����ԣ����jvm��ȫ�����������Ļ��ᱨ�쳣��IllegalAccessException
        field.setAccessible(true);
        System.out.println("field type : " + field.getType());
        //��˽�б�����ֵ
        field.set(object,Class.forName(field.getType().getName()).newInstance() );
        ObjWithPrivateField obj = ((ObjWithPrivateField)object);
        //���Ե���˽�б����ķ���
        System.out.println("private field's desc : "+obj.getPrivateField().getDesc());
	}
	
//	static String getEnum(int ordinal){
//		Modifier[] values = Modifier.values();
//		for (Modifier modifier : values) {
//			if (modifier.ordinal() == ordinal) {
//				return modifier.toString();
//			}
//		}
//		return "illegal ordinal";
//	}
}