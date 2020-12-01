package task4;

import java.lang.reflect.*;

public abstract class TypeAnalyzerBase {

	protected void analyzeType(Class<?> type, int level, boolean proceedBaseClasses) {
		this.onBeforeAnalyze(type, proceedBaseClasses);
		this.analyzeTypeInternal(type, level, proceedBaseClasses);
		this.onAfterAnalyze(type, proceedBaseClasses);
	}

	protected void onAfterAnalyze(Class<?> type, boolean proceedBaseClasses) {
	}
	
	protected void onBeforeAnalyze(Class<?> type, boolean proceedBaseClasses) {
	}
	
	protected void onConstructorsFound(Constructor<?>[] constructors, int level, Class<?> type) {
	}

	protected void onFieldsFound(Field[] fields, int level, Class<?> type) {
	}
	
	protected void onMethodsFound(Method[] methods, int level, Class<?> type) {
	}
	
	protected void onTypeFound(Class<?> type, int level) {
	}
	
	private void analyzeTypeInternal(Class<?> type, int level, boolean proceedBaseClasses) {
		this.onTypeFound(type, level);
		
		Constructor<?>[] constructors = type.getDeclaredConstructors();
		if(constructors.length > 0) {
			this.onConstructorsFound(constructors, level, type);
		}
		
		Method[] methods = type.getDeclaredMethods();
		if(constructors.length > 0) {
			this.onMethodsFound(methods, level, type);
		}

		Field[] fields = type.getDeclaredFields();
		if(fields.length > 0) {
			this.onFieldsFound(fields, level, type);
		}
		
		if(type.getSuperclass() != null && !type.getSuperclass().getName().equals("java.lang.Object") && proceedBaseClasses) {
			analyzeTypeInternal(type.getSuperclass(), level + 1, proceedBaseClasses);
		}
	}
}