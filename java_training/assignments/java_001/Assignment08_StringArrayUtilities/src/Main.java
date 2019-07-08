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
		static int[] indexOfOccuranceInArray(String[] a, String s, boolean sensitive) {
			int[] indexes = {-1};
			if(sensitive == true) {
				if(Arrays.asList(a).contains(s)) {
					indexes[0] = Arrays.asList(a).lastIndexOf(s);
					return indexes;
				}
			}
			else if(sensitive == false) {
				for(String x : a) {
					if(x.equalsIgnoreCase(s)) {
						indexes[0] = Arrays.asList(a).lastIndexOf(s);
						return indexes;
					}
				}
				return indexes;
			}
			return indexes;
		}
	

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
		int[] s8 = indexOfOccuranceInArray (myList, "zo", false);
		int[] s9 = indexOfOccuranceInArray (myList, "zoo", false);
		int[] s10 = indexOfOccuranceInArray (myList, "zoo", true);
		int[] s11 = indexOfOccuranceInArray (myList, "foo", true);
		int[] s12 = indexOfOccuranceInArray (myList, "foo", false);
		int[] s13 = indexOfOccuranceInArray (myList, "delta", true);
		int[] s14 = indexOfOccuranceInArray (myList, "Delta", true);
		
		//output
		//array matches
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
		
		//index occurances
		System.out.println("\nSceanrio 8");
		System.out.println("indexOfOccuranceInArray (myList, 'zo', false): returns " + s8);
		System.out.println("\nSceanrio 9");
		System.out.println("indexOfOccuranceInArray (myList, 'zoo', false): returns " + s9);
		System.out.println("\nSceanrio 10");
		System.out.println("indexOfOccuranceInArray (myList, 'zoo', true): returns " + s10);
		System.out.println("\nSceanrio 11");
		System.out.println("indexOfOccuranceInArray (myList, 'foo', true): returns " + s11);
		System.out.println("\nSceanrio 12");
		System.out.println("indexOfOccuranceInArray (myList, 'foo', false): returns " + s12);
		System.out.println("\nSceanrio 13");
		System.out.println("indexOfOccuranceInArray (myList, 'delta', true): returns " + s13);
		System.out.println("\nSceanrio 14");
		System.out.println("indexOfOccuranceInArray (myList, 'Delta', true): returns " + s14);
	}

}
