package task5;

@ThisCodeSmell(reviewer = "Vasya")
@ThisCodeSmell()
public final class AnnotationUsageSample extends AnnotationUsageSampleBase  {
	
	public AnnotationUsageSample(int multiplier) {
		super(multiplier);
	}

	@UseArrayList
	@ThisCodeSmell(reviewer = "Kolya")
	private int[] someField;
	
	@ThisCodeSmell(reviewer = "Vasya")
	public void someDummyMethod() {
	}
	
	@ProdCode
	@UseStackOnly
	public void someUsefulMethod(String text) {
		System.out.println("AnnotationUsageSample.someUsefulMethod says '" + text + "'");
	}
}