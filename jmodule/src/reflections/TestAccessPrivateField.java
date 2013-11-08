package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 通过反射设置私有变量(没有提供public的setter方法)，像spring对私有变量的依赖注入（没有公开的setter）
 * 应该也是通过这种机制
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
        //设置私有变量的可访问性，如果jvm安全管理不允许的话会报异常：IllegalAccessException
        field.setAccessible(true);
        System.out.println("field type : " + field.getType());
        //给私有变量赋值
        field.set(object,Class.forName(field.getType().getName()).newInstance() );
        ObjWithPrivateField obj = ((ObjWithPrivateField)object);
        //测试调用私有变量的方法
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
