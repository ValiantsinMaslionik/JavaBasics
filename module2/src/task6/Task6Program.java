package task6;

import task5.*;

public class Task6Program {

	public static void main(String[] args) {
		System.out.println((new CodeReviewAnalyzer()).dumpType(AnnotationUsageSample.class, true));
	}
}