package task5;

@ThisCodeSmell
public class AnnotationUsageSampleBase {
	
	@ThisCodeSmell(reviewer = "Dima")
	private int nestedField1;
	
	@ThisCodeSmell(reviewer = "Dima")
	@ThisCodeSmell(reviewer = "Miha")
	private int nestedField2;

	@ThisCodeSmell(reviewer = "Petya")
	@ThisCodeSmell(reviewer = "Vasya")
	public AnnotationUsageSampleBase(int multiplier) {
		this.nestedField1 = 10 * multiplier;
		this.nestedField1 = 20 * multiplier;
	}
	
	@ThisCodeSmell	
	public int getNestedField1() {
		return this.nestedField1;
	}
	
	@ThisCodeSmell(reviewer = "Dima")
	public int getNestedField2() {
		return this.nestedField2;
	}
}