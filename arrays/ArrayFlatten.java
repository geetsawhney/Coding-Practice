public class ArrayFlatten {

	public static void main(String[] args) {
		Object[] arr = { 1119, "1111", 19.0,'a' };
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].toString();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

