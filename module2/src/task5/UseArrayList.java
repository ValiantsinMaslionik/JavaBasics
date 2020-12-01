package task5;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface UseArrayList {
	public boolean value() default true;
}
