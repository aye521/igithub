package annotations;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
public class AnnotationTest {

	public static void main(String[] args) {
		/**
		 * ע����ĳ��������ʽ�Ľӿڣ�getAnnotation�õ�����һ��ʵ����annotation�ӿڵĴ�����
		 */
		RequestMapping requestMapping = AnnotationTest.class.getAnnotation(RequestMapping.class);  
        System.out.println(requestMapping.getClass().getName());
	}
}