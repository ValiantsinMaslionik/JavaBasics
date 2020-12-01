package task6;

import java.lang.reflect.*;
import java.util.*;

import task4.TypeDumper;
import task5.*;

public class CodeReviewAnalyzer extends TypeDumper {
	Map<String, Integer> stat; 
	
	@Override
	protected void onBeforeAnalyze(Class<?> type, boolean proceedBaseClasses) {
		super.onBeforeAnalyze(type, proceedBaseClasses);
		this.stat = new HashMap<String, Integer>();
	}

	@Override
	protected void onConstructorFound(Constructor<?> constructor, int level, Class<?> type) {
		ThisCodeSmell[] annotations = constructor.getAnnotationsByType(ThisCodeSmell.class);
		if(annotations.length > 0) {
			super.onConstructorFound(constructor, level, type);
			this.appendAnnotations("ctor", annotations, this.stat, this.dump, level + 1);
		}		
	}
	
	@Override
	protected void onFieldFound(Field field, int level, Class<?> type) {
		ThisCodeSmell[] annotations = field.getAnnotationsByType(ThisCodeSmell.class);
		if(annotations.length > 0) {
			super.onFieldFound(field, level, type);
			this.appendAnnotations("field", annotations, this.stat, this.dump, level + 1);
		}		
	}

	@Override
	protected void onMethodFound(Method method, int level, Class<?> type) {
		ThisCodeSmell[] annotations = method.getAnnotationsByType(ThisCodeSmell.class);
		if(annotations.length > 0) {
			super.onMethodFound(method, level, type);
			this.appendAnnotations("field", annotations, this.stat, this.dump, level + 1);
		}		
	}
	
	@Override
	protected void onTypeFound(Class<?> type, int level) {
		super.onTypeFound(type, level);
		ThisCodeSmell[] annotations = type.getAnnotationsByType(ThisCodeSmell.class);
		this.appendAnnotations("Type", annotations, this.stat, this.dump, level + 1);
	}
	
	private void appendAnnotations(String target, ThisCodeSmell[] annotations, Map<String, Integer> stat, StringBuilder info, int indent) {
		if(annotations.length == 0) {
			return;
		} else {
			this.appendText("Reviewed by: ", info, indent);
			for(ThisCodeSmell annotation : annotations) {
				this.appendText(annotation.reviewer() + ";", info, 0);
				int reviewedCount = stat.getOrDefault(target, 0) + 1;
				stat.put(target, reviewedCount);
			}
		}
		info.append("\n");
	}
}