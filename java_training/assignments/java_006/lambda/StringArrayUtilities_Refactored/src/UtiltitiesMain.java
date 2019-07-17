import java.util.Arrays;

public class UtiltitiesMain {

	public static void main(String[] args) {
		ArrayMethod arrM = new ArrayMethod();
		
		//array
		String[] myList = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		
		//scenarios
		boolean s1 = arrM.arrayHasExactMatch (myList, "zo", false);
		boolean s2 = arrM.arrayHasExactMatch (myList, "zoo", false);
		boolean s3 = arrM.arrayHasExactMatch (myList, "zoo", true);
		boolean s4 = arrM.arrayHasExactMatch (myList, "foo", true);
		boolean s5 = arrM.arrayHasExactMatch (myList, "foo", false);
		boolean s6 = arrM.arrayHasExactMatch (myList, "delta", true);
		boolean s7 = arrM.arrayHasExactMatch (myList, "Delta", true);
			//work in progress
		int[] s8 = arrM.indexOfOccuranceInArray (myList, "zo", false);
		int[] s9 = arrM.indexOfOccuranceInArray (myList, "zoo", false);
		int[] s10 = arrM.indexOfOccuranceInArray (myList, "zoo", true);
		int[] s11 = arrM.indexOfOccuranceInArray (myList, "foo", true);
		int[] s12 = arrM.indexOfOccuranceInArray (myList, "foo", false);
		int[] s13 = arrM.indexOfOccuranceInArray (myList, "delta", true);
		int[] s14 = arrM.indexOfOccuranceInArray (myList, "Delta", true);
		
		//output
		//array matches
		System.out.println("This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.print("The array to test contains the following items: ");
		System.out.println(Arrays.toString(myList));
		System.out.println("\nScenario 1");
		System.out.println("arrayHasExactMatch (myList, “zo”, false): is " + s1);
		System.out.println("\nScenario 2");
		System.out.println("arrayHasExactMatch (myList, 'zoo', false): is " + s2);
		System.out.println("\nScenario 3");
		System.out.println("arrayHasExactMatch (myList, 'zoo', true): is " + s3);
		System.out.println("\nScenario 4");
		System.out.println("arrayHasExactMatch (myList, 'foo', true): is " + s4);
		System.out.println("\nScenario 5");
		System.out.println("arrayHasExactMatch (myList, 'foo', false): is " + s5);
		System.out.println("\nScenario 6");
		System.out.println("arrayHasExactMatch (myList, 'delta', true): is " + s6);
		System.out.println("\nScenario 7");
		System.out.println("arrayHasExactMatch (myList, 'Delta', true): is " + s7);
		
		//index occurances
		System.out.println("\nScenario 8");
		System.out.println("indexOfOccuranceInArray (myList, 'zo', false): returns " + Arrays.toString(s8));
		System.out.println("\nScenario 9");
		System.out.println("indexOfOccuranceInArray (myList, 'zoo', false): returns " + Arrays.toString(s9));
		System.out.println("\nScenario 10");
		System.out.println("indexOfOccuranceInArray (myList, 'zoo', true): returns " +  Arrays.toString(s10));
		System.out.println("\nScenario 11");
		System.out.println("indexOfOccuranceInArray (myList, 'foo', true): returns " +  Arrays.toString(s11));
		System.out.println("\nScenario 12");
		System.out.println("indexOfOccuranceInArray (myList, 'foo', false): returns " +  Arrays.toString(s12));
		System.out.println("\nScenario 13");
		System.out.println("indexOfOccuranceInArray (myList, 'delta', true): returns " +  Arrays.toString(s13));
		System.out.println("\nScenario 14");
		System.out.println("indexOfOccuranceInArray (myList, 'Delta', true): returns " +  Arrays.toString(s14));


	}

}
