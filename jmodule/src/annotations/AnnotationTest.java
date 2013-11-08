package annotations;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
public class AnnotationTest {

	public static void main(String[] args) {
		RequestMapping requestMapping = AnnotationTest.class.getAnnotation(RequestMapping.class);  
        System.out.println(requestMapping.getClass().getName());
	}
}
