import java.util.*;

public class Main {
	
	//array exact match by string
		static boolean arrayHasExactMatch(String[] a, String s, boolean sensitive) {
			if(sensitive == true) {
				if(Arrays.asList(a).contains(s)) {
					return true;
				}
			}
			else if(sensitive == false) {
				for(String x : a) {
					if(x.equalsIgnoreCase(s)) {
						return true;
					}
				}
				return false;
			}
			return false;
		}
		
		//finding indexes
		//int[] indexOfOccuranceInArray(String[] a, String s, boolean sensitive) {
			
		//}
	

	public static void main(String[] args) {

		//array
		String[] myList = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		
		//scenarios
		boolean s1 = arrayHasExactMatch (myList, "zo", false);
		boolean s2 = arrayHasExactMatch (myList, "zoo", false);
		boolean s3 = arrayHasExactMatch (myList, "zoo", true);
		boolean s4 = arrayHasExactMatch (myList, "foo", true);
		boolean s5 = arrayHasExactMatch (myList, "foo", false);
		boolean s6 = arrayHasExactMatch (myList, "delta", true);
		boolean s7 = arrayHasExactMatch (myList, "Delta", true);
		
		//output
		System.out.println("This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.println("{'"+myList[0]+"', '" + myList[1]+"', '" + myList[2]+"', '" + myList[3]+"', '" + myList[4]+"', '" + myList[5]+"', '" + myList[6]+ "'}");
		System.out.println("\nSceanrio 1");
		System.out.println("arrayHasExactMatch (myList, “zo”, false): is " + s1);
		System.out.println("\nSceanrio 2");
		System.out.println("arrayHasExactMatch (myList, 'zoo', false): is " + s2);
		System.out.println("\nSceanrio 3");
		System.out.println("arrayHasExactMatch (myList, 'zoo', true): is " + s3);
		System.out.println("\nSceanrio 4");
		System.out.println("arrayHasExactMatch (myList, 'foo', true): is " + s4);
		System.out.println("\nSceanrio 5");
		System.out.println("arrayHasExactMatch (myList, 'foo', false): is " + s5);
		System.out.println("\nSceanrio 6");
		System.out.println("arrayHasExactMatch (myList, 'delta', true): is " + s6);
		System.out.println("\nSceanrio 7");
		System.out.println("arrayHasExactMatch (myList, 'Delta', true): is " + s7);
		
	}

}
