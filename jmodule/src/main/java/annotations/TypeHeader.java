package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * this is the annotation to be processed,default for Target is all Java Elements
 * change retention policy to RUNTIME (default is CLASS)
 * @author meaning
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface TypeHeader {
	// default value specified for developer attribute
    String developer() default "Unknown";
    String lastModified();
    String [] teamMembers();
    int meaningOfLife();
}
