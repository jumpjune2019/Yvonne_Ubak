import java.util.Arrays;
import java.util.Collections;
import java.text.Collator;

public class SortingMain {

	public static void main(String[] args) {
		Integer[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce"};
		
		//lambda function to sort Integer arrays
		NumSortFunc<Integer> sortedInt = (arr, o) -> {
			//ascending order
			if(o.equals("asc")) {
				Arrays.sort(arr);
			//descending order
			}else if(o.equals("desc")) {
				Arrays.sort(arr, Collections.reverseOrder());
			}
			
			//return array as a string
			String a = Arrays.toString(arr);
			return a;
		};
		
		//lambda function to sort String arrays
		StrSortFunc<String> sortedStr = (arr, o, c) -> {
			//ascending order - case sensitive
			if(o.equals("asc") && c.equals("on")) {
				Arrays.sort(arr);
			//ascending order - case insensitive
			}else if(o.equals("asc") && c.equals("off")) {
				Arrays.sort(arr, Collator.getInstance());
			//descending order - case sensitive
			}else if(o.equals("desc") && c.equals("on")) {
				Arrays.sort(arr, Collections.reverseOrder());
			//descending order - case insensitive
			}else if(o.equals("desc") && c.equals("off")) {
				for(int i = 0; i < arr.length; i++) {
					arr[i] = arr[i].toLowerCase();
				}
				Arrays.sort(arr);
			}
			
			//return array as a string
			String a = Arrays.toString(arr);
			return a;
		};
		
		//output
		System.out.println("Initial Integer array: " + Arrays.toString(numArr));
		System.out.println("Sorted ASC: " + sortedInt.nSort(numArr, "asc"));
		System.out.println("Sorted DESC: " + sortedInt.nSort(numArr, "desc"));
		System.out.println("Initial String array: " + Arrays.toString(strArr));
		System.out.println("Sorted ASC and Case Sensitivity ON: " + sortedStr.strSort(strArr, "asc", "on"));
		System.out.println("Sorted ASC and Case Sensitivity OFF: " + sortedStr.strSort(strArr, "asc", "off"));
		System.out.println("Sorted DESC and Case Sensitivity ON: " + sortedStr.strSort(strArr, "desc", "on"));
		System.out.println("Sorted DESC and Case Sensitivity OFF: " + sortedStr.strSort(strArr, "desc", "off"));
		
	}

}
