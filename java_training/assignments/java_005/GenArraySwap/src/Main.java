import java.util.*;

public class Main {

	public static void main(String[] args) {
		String[] x = {"Elephant", "Tiger", "Lion", "Gazelle", "Zebra"};
		Double[] i = {1.25, 3.50, 5.75, 8.00, 10.25};
		List<String> l = new ArrayList<String>(Arrays.asList(x));
		List<Double> d = new ArrayList<Double>(Arrays.asList(i));
		
		//swapping strings
		System.out.println("The first list is: " + Arrays.toString(x));
		swapElement.swap(l, 0, 2);
		System.out.println("Swap 'Elephant' and 'Gazelle': " + l);
		
		//swapping numbers
		System.out.println("\nThe second list is: " + Arrays.toString(i));
		swapElement.swap(d, 2, 4);
		System.out.println("Swap '5.75' and '10.25': " + d);
		
		
	}

}
