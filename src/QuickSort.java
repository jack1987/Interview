import java.util.Arrays;
import java.util.HashSet;

public class QuickSort {
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// Check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low;
		int m = low;
		if (low == high)
			return;
		// Get the pivot element from the middle of the list
		// int pivot = numbers[low + (high - low) / 2];
		int pivot = numbers[low];
		for (i = low + 1; i <= high; i++) {
			if (numbers[i] < pivot)
				exchange(++m, i);
		}
		exchange(low, m);
		if (low != m)
			quicksort(low, m - 1);
		if (m != high)
			quicksort(m + 1, high);
		// Divide into two lists
/*		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);*/
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + Arrays.hashCode(numbers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuickSort other = (QuickSort) obj;
		if (number != other.number)
			return false;
		if (!Arrays.equals(numbers, other.numbers))
			return false;
		return true;
	}

	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		HashSet c = new HashSet();
		c.add(3);
		c.add(2);
		c.add(3);
		System.out.println(c.toString());
		int b = 1;
		for(int i  = 0; i<38; i++){
			b = b*2;
								}
		System.out.println(b-1);
		int[] testArr = { 5, 4, 3};
		test.sort(testArr);
		for (int i = 0; i < testArr.length; i++){
			System.out.print(testArr[i] + " ");}
	}
}
