package task4;

import java.lang.reflect.*;

public class TypeDumper extends TypeAnalyzerBase {
	public static int INDENT_SIZE = 2;
	
	protected StringBuilder dump;
	
	public String dumpType(Class<?> type, boolean proceedBaseClasses) {
		this.analyzeType(type, 0, proceedBaseClasses);
		return this.dump.toString();
	}

	@Override
	protected void onBeforeAnalyze(Class<?> type, boolean proceedBaseClasses) {
		this.dump = new StringBuilder();
	}

	@Override
	protected void onConstructorsFound(Constructor<?>[] constructors, int level, Class<?> type) {
		for(Constructor<?> constructor : constructors) {
			this.onConstructorFound(constructor, level, type);
		}
	}

	@Override
	protected void onFieldsFound(Field[] fields, int level, Class<?> type) {
		for(Field field : fields) {
			this.onFieldFound(field, level, type);
		}
	}

	@Override
	protected void onMethodsFound(Method[] methods, int level, Class<?> type) {
		for(Method method : methods) {
			this.onMethodFound(method, level, type);
		}
	}

	@Override
	protected void onTypeFound(Class<?> type, int level) {
		appendTextLine("---- Type: " + type.getName(), this.dump, level);
	}
	
	protected void appendText(String text, StringBuilder sb, int indent) {
		for (int idx = 0; idx < indent * INDENT_SIZE; idx++) {
		   sb.append(" ");
		}
		sb.append(text);
	}
	
	protected void appendTextLine(String text, StringBuilder sb, int indent) {
		appendText(text, sb, indent);
		sb.append("\n");
	}

	protected void onConstructorFound(Constructor<?> constructor, int level, Class<?> type) {
		appendTextLine("+ ctor: " + "[" + constructor.getParameterCount() + "]", this.dump, level + 1);
	}
	
	protected void onFieldFound(Field field, int level, Class<?> type) {
		appendTextLine("* Field: " + field.getName(), this.dump, level + 1);
	}

	protected void onMethodFound(Method method, int level, Class<?> type) {
		appendTextLine(". Method: " + method.getName() + "[" + method.getParameterCount() + "]", this.dump, level + 1);
	}
	
}