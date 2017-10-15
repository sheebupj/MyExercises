package algorithm.sorting;

public class SelectionSort2 {

	public static int[] doSelectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int selePosition=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[selePosition]){
					selePosition=j;
				}
			}
			int smallest=arr[selePosition];
			arr[selePosition]=arr[i];
			arr[i]=smallest;

		}
		return arr;
	}

	public static void main(String a[]) {

		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doSelectionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}
}
