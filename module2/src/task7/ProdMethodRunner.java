package task7;

import java.lang.reflect.*;
import java.util.*;

import task4.TypeDumper;
import task5.*;

public class ProdMethodRunner extends TypeDumper {
	Map<String, Integer> stat; 
	Object obj;
	
	public void runProdMethods(Class<?> type, boolean proceedBaseClasses, Object obj) {
		this.obj = obj;
		this.dumpType(type, proceedBaseClasses);
	}
	
	@Override
	protected void onBeforeAnalyze(Class<?> type, boolean proceedBaseClasses) {
		super.onBeforeAnalyze(type, proceedBaseClasses);
		this.stat = new HashMap<String, Integer>();
	}

	@Override
	protected void onConstructorFound(Constructor<?> constructor, int level, Class<?> type) {
	}
	
	@Override
	protected void onFieldFound(Field field, int level, Class<?> type) {
	}

	@Override
	protected void onMethodFound(Method method, int level, Class<?> type) {
		ProdCode[] annotations = method.getAnnotationsByType(ProdCode.class);
		if(annotations.length > 0) {
			super.onMethodFound(method, level, type);
			for(ProdCode annotation: annotations) {
				try {
					this.appendText("Call this method, result: " + method.invoke(this.obj, annotation.value()) , this.dump, level + 1);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
					ex.printStackTrace();
					System.exit(0);
				}
			}
		}		
	}
}