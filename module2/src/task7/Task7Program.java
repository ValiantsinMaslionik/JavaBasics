package task7;

import task5.*;

public class Task7Program {

	public static void main(String[] args) {
		AnnotationUsageSample sampleObj = new AnnotationUsageSample(1); 
		(new ProdMethodRunner()).runProdMethods(AnnotationUsageSample.class, true, sampleObj);
	}
}