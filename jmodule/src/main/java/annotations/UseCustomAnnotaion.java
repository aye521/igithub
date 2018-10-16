package annotations;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

public class UseCustomAnnotaion {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException {
		Class<SetCustomAnnotation> classObject = SetCustomAnnotation.class;
		readAnnotation(classObject);
	}

	static void readAnnotation(AnnotatedElement element) throws SecurityException, NoSuchFieldException {
		//保存生成的代理类文件到硬盘
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		try {
			System.out.println("Annotation element values: \n");
			if(element.isAnnotationPresent(TypeHeader.class)) {
				// getAnnotation returns Annotation type
				Annotation singleAnnotation =
						element.getAnnotation(TypeHeader.class);

				TypeHeader header = (TypeHeader) singleAnnotation;


				System.out.println("Developer: " + header.developer());
				System.out.println("Last Modified: " + header.lastModified());

				// teamMembers returned as String []
				System.out.print("Team members: ");
				for(String member : header.teamMembers())
					System.out.print(member + ", ");
				System.out.print("\n");

				System.out.println("Meaning of Life: "+ header.meaningOfLife());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}


}
