package task5;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Repeatable(ThisCodeSmells.class)
public @interface ThisCodeSmell {
	public String reviewer() default "Petya";
}