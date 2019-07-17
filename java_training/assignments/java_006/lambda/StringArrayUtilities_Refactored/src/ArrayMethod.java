import java.util.Arrays;

class ArrayMethod {
	//string matches exactly with value in array
	boolean arrayHasExactMatch(String[] arr, String str, boolean sens) {
		ArrayFunc af = (a, s, sensitive) -> {
			//if case sensitive
			if(sensitive == true) {
				if(Arrays.asList(a).contains(s)) {
					return true;
				}
			}
			//if case insensitive
			else if(sensitive == false) {
				for(String x : a) {
					if(x.equalsIgnoreCase(s)) {
						return true;
					}
				}
				return false;
			}
			return false;
		};
		return af.match(arr, str, sens);	
	}
	
	//find index that matched string occurs
	int[] indexOfOccuranceInArray(String[] arr, String str, boolean sens) {
		IndexFunc inF = (a, s, sensitive) -> {
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
		};
		return inF.occurance(arr, str, sens);
	}

}
