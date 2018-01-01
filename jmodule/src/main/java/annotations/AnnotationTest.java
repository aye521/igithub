package annotations;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
public class AnnotationTest {

	public static void main(String[] args) {
		/**
		 * 注解是某种特殊形式的接口，getAnnotation得到的是一个实现了annotation接口的代理类
		 */
		RequestMapping requestMapping = AnnotationTest.class.getAnnotation(RequestMapping.class);
		System.out.println(requestMapping.getClass().getName());
	}
}
