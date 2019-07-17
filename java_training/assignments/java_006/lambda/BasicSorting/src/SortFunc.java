//default super-interface
interface BaseSortFunc <T> {
	default void func(T arr[], String o, String c) {}
}

//handles 2 arguments for a Number array
interface NumSortFunc <T> extends BaseSortFunc<T>{
	String nSort(T arr[], String o);
	default void func(T arr[], String o, String c) {
		nSort(arr, o);
	}
}

//handles 3 arguments for a String array
interface StrSortFunc <T> extends BaseSortFunc<T>{
	String strSort(T arr[], String o, String c);
	default void func(T arr[], String o, String c) {
		strSort(arr, o, c);
	}
}