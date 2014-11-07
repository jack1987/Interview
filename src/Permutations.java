import java.util.ArrayList;

/*************************************************************************
 * Compilation: javac Permutations.java Execution: java Permutations N
 * 
 * Enumerates all permutations on N elements. Two different approaches are
 * included.
 * 
 * % java Permutations 3 abc acb bac bca cab cba
 * 
 *************************************************************************/

public class Permutations {

	// print N! permutation of the characters of the string s (in order)
	static int N;

	public static void perm1(String s) {
		//ArrayList<String> res = new ArrayList<String>();
		String S = "abc";
		System.out.println(s.substring(0, 1));
		perm1("", s);
		//System.out.println(res);
	}

	private static void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0) {
			System.out.println(prefix);
			//result.add(prefix);
			return;
		}
		for (int i = 0; i < N; i++)
			perm1(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1, N));
	}

	// print N! permutation of the elements of array a (not in order), like
	// recursion backtrack;
	public static ArrayList<String> perm2(String s) {
		ArrayList<String> res = new ArrayList<String>();
		N = s.length();
		char[] a = new char[N];
		for (int i = 0; i < N; i++)
			a[i] = s.charAt(i);
		perm2(a, N, res);
		return res;
	}

	private static void perm2(char[] a, int n, ArrayList<String> res) {
		if (n == 1) {
			//System.out.println(a);
			res.add(new String(a));
			return;
		}
		for (int i = N - n; i < N; i++) {
			swap(a, N - n, i);
			perm2(a, n - 1, res);
			swap(a, N - n, i);
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		char c;
		c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void main(String[] args) {
		int N = 4;
		ArrayList<String> result1 = new ArrayList<String>();
		int value = Integer.MIN_VALUE;
		//value = value>>>1;
		int a = 3;
		a= a>>1;
		System.out.println(value);
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, N);
		perm1(elements);
		System.out.println();
		result1 = perm2(elements);
		for(String iter: result1)
		 System.out.println(iter + " * ");
	}
}