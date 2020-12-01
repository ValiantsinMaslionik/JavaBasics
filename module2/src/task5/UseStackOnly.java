package task5;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface UseStackOnly {
	public boolean value() default true;
}