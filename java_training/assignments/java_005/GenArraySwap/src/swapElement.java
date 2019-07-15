import java.util.*;
class swapElement <T>{
//array
/*public static <T> void swapElement(T[] x, int y, int z) {
	T a = x[y];
	x[y] = x[z];
	x[z] = a;
	
}*/

//list	
public static <T> void swap(List<?> arrList, int y, int z) {
	Collections.<T>swap(arrList, y, z);
	
}
	
}
